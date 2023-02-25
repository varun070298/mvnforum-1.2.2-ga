/*
 * Copyright (c) 2005 Kurt Miller <truk@optonline.net>
 *
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

/* This file rewritten from a sample implementation of JDBCRealm written by Kurt Miller.
 * 
 * We configure realm with no digest, then encode it when authenticating 
 * instead of decoding database credentials. Because We don't know why 
 * MVNTomcatJDBCRealm is never called  
 * 
 * View Thread: http://www.mvnforum.com/mvnforum/mvnforum/viewthread?thread=2782
 */
package com.mvnsoft.auth.realm;

import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.X509Certificate;

import org.apache.catalina.realm.JDBCRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

public class MVNTomcatJDBCRealm extends JDBCRealm {

    private static final Log log = LogFactory.getLog(MVNTomcatJDBCRealm.class);

    protected String getPassword(String username) {
        // I don't know why this method is never called
        return super.getPassword(username);
    }

    public String getMD5_Base64(String input) {
        // please note that we don't use digest, because if we
        // cannot get digest, then the second time we have to call it
        // again, which will fail again
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            log.fatal("Cannot get MessageDigest. Application may fail to run correctly.", ex);
        }
        if (digest == null) {
            return input;
        }
        if (input == null) {
            return null;
        }

        // now everything is ok, go ahead
        try {
            digest.update(input.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            log.error("Assertion: This should never occur.");
        }
        byte[] rawData = digest.digest();
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(rawData);
    }

    protected String digest(String credentials) {
        System.out.println("MVNTomcatJDBCRealm.digest()");
        //return super.digest(credentials);
        return getMD5_Base64(credentials);
    }

    /**
     * This is a sample implementation of JDBCRealm using password
     */

    public Principal authenticate(String username, String password) {
        String md5_base64 = getMD5_Base64(password);
        System.out.println("MVNTomcatJDBCRealm.authenticate(username, password) with username = " + username);
        //System.out.println("Authenticate 2 params " + username + " and " + md5_base64);
        //return super.authenticate(username, md5_base64);
        return super.authenticate(username, password);
    }

    public Principal authenticate(String username, byte[] credentials) {
        System.out.println("Authenticate byte");
        return super.authenticate(username, credentials);
    }

    public Principal authenticate(String username, String clientDigest, String nOnce, String nc, String cnonce,
            String qop, String realm, String md5a2) {
        //System.out.println("Authenticate username, clientDigest, nOnce, nc, cnonce, qop, realm, md5a2");
        return super.authenticate(username, clientDigest, nOnce, nc, cnonce, qop, realm, md5a2);
    }

    public Principal authenticate(X509Certificate[] certs) {
        //System.out.println("Authenticate X509Certificate");
        return super.authenticate(certs);
    }
}