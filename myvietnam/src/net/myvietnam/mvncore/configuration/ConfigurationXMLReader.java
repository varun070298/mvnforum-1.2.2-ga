package net.myvietnam.mvncore.configuration;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999-2003 The Apache Software Foundation.  All rights
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
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
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
 */

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 * <p>A base class for &quot;faked&quot; <code>XMLReader</code> classes
 * that transform a configuration object in a set of SAX parsing events.</p>
 * <p>This class provides dummy implementations for most of the methods
 * defined in the <code>XMLReader</code> interface that are not used for this
 * special purpose. There will be concrete sub classes that process specific
 * configuration classes.</p>
 *
 * @author <a href="mailto:oliver.heger@t-online.de">Oliver Heger</a>
 * @version $Id: ConfigurationXMLReader.java,v 1.1 2003/12/09 08:25:30 huumai Exp $
 */
public abstract class ConfigurationXMLReader implements XMLReader
{
    /** Constant for the namespace URI.*/
    protected static final String NS_URI = "";

    /** Constant for the default name of the root element.*/
    private static final String DEFAULT_ROOT_NAME = "config";

    /** An empty attributes object.*/
    private static final Attributes EMPTY_ATTRS = new AttributesImpl();

    /** Stores the content handler.*/
    private ContentHandler contentHandler;

    /** Stores an exception that occurred during parsing.*/
    private SAXException exception;

    /** Stores the name for the root element.*/
    private String rootName;

    /**
     * Creates a new instance of <code>ConfigurationXMLReader</code>.
     */
    protected ConfigurationXMLReader()
    {
        super();
        setRootName(DEFAULT_ROOT_NAME);
    }

    /**
     * Parses the acutal configuration object. The passed system ID will be
     * ignored.
     * @param systemId the system ID (ignored)
     * @throws IOException if no configuration was specified
     * @throws SAXException if an error occurs during parsing
     */
    public void parse(String systemId) throws IOException, SAXException
    {
        parseConfiguration();
    }

    /**
     * Parses the acutal configuration object. The passed input source will be
     * ignored.
     * @param input the input source (ignored)
     * @throws IOException if no configuration was specified
     * @throws SAXException if an error occurs during parsing
     */
    public void parse(InputSource input) throws IOException, SAXException
    {
        parseConfiguration();
    }

    /**
     * Dummy implementation of the interface method.
     * @param name the name of the feature
     * @return always <b>false</b> (no features are supported)
     */
    public boolean getFeature(String name)
    {
        return false;
    }

    /**
     * Dummy implementation of the interface method.
     * @param name the name of the feature to be set
     * @param value the value of the feature
     */
    public void setFeature(String name, boolean value)
    {
    }

    /**
     * Returns the actually set content handler.
     * @return the content handler
     */
    public ContentHandler getContentHandler()
    {
        return contentHandler;
    }

    /**
     * Sets the content handler. The object specified here will receive SAX
     * events during parsing.
     * @param handler the content handler
     */
    public void setContentHandler(ContentHandler handler)
    {
        contentHandler = handler;
    }

    /**
     * Returns the DTD handler. This class does not support DTD handlers,
     * so this method always returns <b>null</b>.
     * @return the DTD handler
     */
    public DTDHandler getDTDHandler()
    {
        return null;
    }

    /**
     * Sets the DTD handler. The passed value is ignored.
     * @param handler the handler to be set
     */
    public void setDTDHandler(DTDHandler handler)
    {
    }

    /**
     * Returns the entity resolver. This class does not support an entity
     * resolver, so this method always returns <b>null</b>.
     * @return the entity resolver
     */
    public EntityResolver getEntityResolver()
    {
        return null;
    }

    /**
     * Sets the entity resolver. The passed value is ignored.
     * @param resolver the entity resolver
     */
    public void setEntityResolver(EntityResolver resolver)
    {
    }

    /**
     * Returns the error handler. This class does not support an error handler,
     * so this method always returns <b>null</b>.
     * @return the error handler
     */
    public ErrorHandler getErrorHandler()
    {
        return null;
    }

    /**
     * Sets the error handler. The passed value is ignored.
     * @param handler the error handler
     */
    public void setErrorHandler(ErrorHandler handler)
    {
    }

    /**
     * Dummy implementation of the interface method. No properties are
     * supported, so this method always returns <b>null</b>.
     * @param name the name of the requested property
     * @return the property value
     */
    public Object getProperty(String name)
    {
        return null;
    }

    /**
     * Dummy implementation of the interface method. No properties are
     * supported, so a call of this method just has no effect.
     * @param name the property name
     * @param value the property value
     */
    public void setProperty(String name, Object value)
    {
    }

    /**
     * Returns the name to be used for the root element.
     * @return the name for the root element
     */
    public String getRootName()
    {
        return rootName;
    }

    /**
     * Sets the name for the root element.
     * @param string the name for the root element.
     */
    public void setRootName(String string)
    {
        rootName = string;
    }

    /**
     * Fires a SAX element start event.
     * @param name the name of the actual element
     * @param attribs the attributes of this element (can be <b>null</b>)
     */
    protected void fireElementStart(String name, Attributes attribs)
    {
        if (getException() == null)
        {
            try
            {
                Attributes at = (attribs == null) ? EMPTY_ATTRS : attribs;
                getContentHandler().startElement(NS_URI, name, name, at);
            } /* try */
            catch (SAXException ex)
            {
                exception = ex;
            } /* catch */
        } /* if */
    }

    /**
     * Fires a SAX element end event.
     * @param name the name of the affected element
     */
    protected void fireElementEnd(String name)
    {
        if (getException() == null)
        {
            try
            {
                getContentHandler().endElement(NS_URI, name, name);
            } /* try */
            catch (SAXException ex)
            {
                exception = ex;
            } /* catch */
        } /* if */
    }

    /**
     * Fires a SAX characters event.
     * @param text the text
     */
    protected void fireCharacters(String text)
    {
        if (getException() == null)
        {
            try
            {
                char[] ch = text.toCharArray();
                getContentHandler().characters(ch, 0, ch.length);
            } /* try */
            catch (SAXException ex)
            {
                exception = ex;
            } /* catch */
        } /* if */
    }

    /**
     * Returns a reference to an exception that occurred during parsing.
     * @return a SAXExcpetion or <b>null</b> if none occurred
     */
    public SAXException getException()
    {
        return exception;
    }

    /**
     * Parses the configuration object and generates SAX events. This is the
     * main processing method.
     * @throws IOException if no configuration has been specified
     * @throws SAXException if an error occurs during parsing
     */
    protected void parseConfiguration() throws IOException, SAXException
    {
        if (getParsedConfiguration() == null)
        {
            throw new IOException("No configuration specified!");
        } /* if */

        if (getContentHandler() != null)
        {
            exception = null;
            getContentHandler().startDocument();
            processKeys();
            if (getException() != null)
            {
                throw getException();
            } /* if */
            getContentHandler().endDocument();
        } /* if */
    }

    /**
     * Returns a reference to the configuration that is parsed by this object.
     * @return the parsed configuration
     */
    public abstract Configuration getParsedConfiguration();

    /**
     * Processes all keys stored in the actual configuration. This method is
     * called by <code>parseConfiguration()</code> to start the main parsing
     * process. <code>parseConfiguration()</code> calls the content handler's
     * <code>startDocument()</code> and <code>endElement()</code> methods
     * and cares for exception handling. The remaining actions are left to this
     * method that must be implemented in a concrete sub class.
     * @throws IOException if an IO error occurs
     * @throws SAXException if a SAX error occurs
     */
    protected abstract void processKeys() throws IOException, SAXException;
}
