/*
 * CompressionServletResponseWrapper.java
 * $Header: /cvsroot/mvnforum/myvietnam/src/net/myvietnam/mvncore/servlet/filter/CompressionServletResponseWrapper.java,v 1.9 2008/05/30 04:18:37 minhnn Exp $
 * $Revision: 1.9 $
 * $Date: 2008/05/30 04:18:37 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */

package net.myvietnam.mvncore.servlet.filter;

import java.io.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Implementation of <b>HttpServletResponseWrapper</b> that works with
 * the CompressionServletResponseStream implementation..
 *
 * @author Amy Roh
 * @author Dmitri Valdin
 * @version $Revision: 1.9 $, $Date: 2008/05/30 04:18:37 $
 */

public class CompressionServletResponseWrapper extends HttpServletResponseWrapper {

    //minhnn : I remove the log because log4j does not support TRACE level
    //private static final Log log = LogFactory.getLog(CompressionServletResponseWrapper.class);

    // ----------------------------------------------------- Constructor

    /**
     * Calls the parent constructor which creates a ServletResponse adaptor
     * wrapping the given response object.
     */

    public CompressionServletResponseWrapper(HttpServletResponse response) {
        super(response);
        origResponse = response;
        //log.trace("CompressionServletResponseWrapper constructor gets called");
    }


    // ----------------------------------------------------- Instance Variables

    /**
     * Original response
     */

    protected HttpServletResponse origResponse = null;

    /**
     * Descriptive information about this Response implementation.
     */

    protected static final String info = "CompressionServletResponseWrapper";

    /**
     * The ServletOutputStream that has been returned by
     * <code>getOutputStream()</code>, if any.
     */

    protected ServletOutputStream stream = null;


    /**
     * The PrintWriter that has been returned by
     * <code>getWriter()</code>, if any.
     */

    protected PrintWriter writer = null;

    /**
     * The threshold number to compress
     */
    protected int threshold = 0;

    /**
     * Debug level
     */
//    private int debug = 0;

    /**
     * Content type
     */
    protected String contentType = null;

    // --------------------------------------------------------- Public Methods


    /**
     * Set content type
     */
    public void setContentType(String contentType) {
        //log.trace("setContentType to " + contentType);
        this.contentType = contentType;
        origResponse.setContentType(contentType);
    }


    /**
     * Set threshold number
     */
    public void setCompressionThreshold(int threshold) {
        //log.trace("setCompressionThreshold to " + threshold);
        this.threshold = threshold;
    }


    /**
     * Set debug level
     */
//    public void setDebugLevel(int debug) {
//        this.debug = debug;
//    }


    /**
     * Create and return a ServletOutputStream to write the content
     * associated with this Response.
     *
     * @exception IOException if an input/output error occurs
     */
    public ServletOutputStream createOutputStream() throws IOException {
        //log.trace("createOutputStream gets called");

        CompressionResponseStream stream = new CompressionResponseStream(origResponse);
        //stream.setDebugLevel(debug);
        stream.setBuffer(threshold);

        return stream;

    }


    /**
     * Finish a response.
     */
    public void finishResponse() {
        try {
            if (writer != null) {
                writer.close();
            } else {
                if (stream != null)
                    stream.close();
            }
        } catch (IOException e) {
        }
    }


    // ------------------------------------------------ ServletResponse Methods


    /**
     * Flush the buffer and commit this response.
     *
     * @exception IOException if an input/output error occurs
     */
    public void flushBuffer() throws IOException {
        //log.trace("flush buffer @ CompressionServletResponseWrapper");

        // minhnn fix NullPointerException
        // this NPE occur when it filter a servlet mapping and then it later forward to not-exist jsp file
        if (stream != null) {
            //minhnn @todo : how to ensure the stream still open ???
            ((CompressionResponseStream)stream).flush();
        }

    }

    /**
     * Return the servlet output stream associated with this Response.
     *
     * @exception IllegalStateException if <code>getWriter</code> has
     *  already been called for this response
     * @exception IOException if an input/output error occurs
     */
    public ServletOutputStream getOutputStream() throws IOException {

        if (writer != null)
            throw new IllegalStateException("getWriter() has already been called for this response");

        if (stream == null) {
            // minhnn: due to IE issue that ignore the Content-Encoding if Content-Type is a zip file
            //         so we will return the original OutputStream
            // http://blogs.msdn.com/wndp/archive/2006/08/21/Content-Encoding-not-equal-Content-Type.aspx
            //stream = createOutputStream();
            stream = origResponse.getOutputStream();
        }
        //log.trace("stream is set to " + stream + " in getOutputStream");

        return (stream);

    }

    /**
     * Return the writer associated with this Response.
     *
     * @exception IllegalStateException if <code>getOutputStream</code> has
     *  already been called for this response
     * @exception IOException if an input/output error occurs
     */
    public PrintWriter getWriter() throws IOException {

        if (writer != null)
            return (writer);

        if (stream != null)
            throw new IllegalStateException("getOutputStream() has already been called for this response");

        stream = createOutputStream();
        //log.trace("stream is set to " + stream + " in getWriter");
        //String charset = getCharsetFromContentType(contentType);
        String charEnc = origResponse.getCharacterEncoding();
        //log.trace("character encoding is " + charEnc);
        // HttpServletResponse.getCharacterEncoding() shouldn't return null
        // according the spec, so feel free to remove that "if"
        if (charEnc != null) {
            writer = new PrintWriter(new OutputStreamWriter(stream, charEnc));
        } else {
            writer = new PrintWriter(stream);
        }

        return (writer);

    }


    public void setContentLength(int length) {
    }


    /**
     * Returns character from content type. This method was taken from tomcat.
     * @author rajo
     */
    private static String getCharsetFromContentType(String type) {

        if (type == null) {
            return null;
        }
        int semi = type.indexOf(";");
        if (semi == -1) {
            return null;
        }
        String afterSemi = type.substring(semi + 1);
        int charsetLocation = afterSemi.indexOf("charset=");
        if(charsetLocation == -1) {
            return null;
        } else {
            String afterCharset = afterSemi.substring(charsetLocation + 8);
            String encoding = afterCharset.trim();
            return encoding;
        }
    }

}
