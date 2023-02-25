/*
 * $Header: /cvsroot/mvnforum/mvnforum/docs/README.txt,v 1.39.2.1 2008/11/17 10:12:51 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.39.2.1 $
 * $Date: 2008/11/17 10:12:51 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2006 by MyVietnam.net
 *
 * All copyright notices regarding mvnForum MUST remain 
 * intact in the scripts and in the outputted HTML.
 * The "powered by" text/logo with a link back to
 * http://www.mvnForum.com and http://www.MyVietnam.net in 
 * the footer of the pages MUST remain visible when the pages
 * are viewed on the internet or intranet.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Support can be obtained from support forums at:
 * http://www.mvnForum.com/mvnforum/index
 *
 * Correspondence and Marketing Questions can be sent to:
 * info at MyVietnam net
 *
 */

//////////////////////////////////////////////////////////////////////////////////
//      mvnForum 1.2.1 GA   -  $Date: 2008/11/17 10:12:51 $
//////////////////////////////////////////////////////////////////////////////////




    IMPORTANT: READ THIS FILE THOTHOUGHLY BEFORE USING mvnForum



0. Table of Contents
==================================================================================

0. Table of Contents
1. mvnForum 1.2.1 GA Introduction
2. Installation/Upgrade Instruction
3. Build Instructions
4. mvnForum Development
5. mvnForum License Agreement



1. mvnForum 1.1 General Availability (GA) Introduction
==================================================================================

Thank you for downloading mvnForum from http://www.mvnForum.com. If you
downloaded this zip-file from an other sites, please check http://www.mvnForum.com
for the latest official release.

This version is the eighth and greatest public release and has a lot of new exciting features.
The next release will have major refactor and require JDK 1.4. 
Please see the file TODO.TXT for the planned tasks.

At this point of development, we need your help with testing, bug report and feature
discussion, please post your feedback, comments and bugs to http://www.mvnForum.com

NOTE: The mvnForum distribution package does not have the file FEATURE.txt. The
      reason for this is mvnForum features are added quite often, so please
      visit http://www.mvnForum.com/mvnforumweb/feature.jsp for the
      latest features list.

NOTE: At this 1.2.x GA release we support 9 DBMS: MySql, Oracle, Sql Server, DB2,
      PostgreSql, hsqldb and Interbase/Firebird, SAPDB, Sybase. The next releases (1.1 or later)
      will support more databases. (If mvnForum doesn't support your database, don't worry,
      you can port the script from mvnForum_JDBC.sql to your database easily)

NOTE: At this 1.2.x GA release mvnForum supports 23 languages: English, Vietnamese, Russian,
      Traditional Chinese, Simplified Chinese, Spanish, French, Italian,
      German, Danish, Latvian, Serbian (latin), Serbian (cyrillic), Arabic,
      Slovenian, Dutch, Slovenian, Greek, Japanese, Korean, Portuguese, Turkish and Norwegian.
      (If mvnForum has not been localized to your language, don't worry,
      you can translate the file mvnForum_i18n.properties and mvncore_java_i18n.properties
      to your language, and if you would like mvnForum officially supports your language
      in later releases, please email me your translation)

All security bugs should be sent directly to minhnn at MyVietnam _ net and
the subject should begin with [mvnForum SECURITY]

mvnForum should run on any Servlet Container which supports JSP 1.2 and Servlet 2.3.
However, this release has only been tested on the following configurations:

on the following databases:
    * MySql version 3.23.51/5.0.18
    * Oracle 8i 8.1.7
    * Sql Server 2000
    * postgreSQL 7.3/8.1.x
    * hsqldb 1.7.1/1.7.2/1.7.3/1.8.0_02
on the following App Servers:
    * Tomcat 4.1.27
    * Tomcat 5.0.16/5.0.28
    * Tomcat 5.5.16
    * Resin 2.1.11
    * Resin 3.0.8
    * Web Logic 7, Web Logic 8
    * Jboss 3.2.2 & Jetty 4.2.14
on the following JDK:
    * Sun JDK 1.4
    * Sun JDK 1.4.1
    * Sun JDK 1.4.2
    * Sun JDK 1.5.0_06
on the following OS:
    * Windows 2000
    * Fedora Core 4/Fedora Core 5

Developed by
- Minh Nguyen <minhnn at MyVietnam net>
- Mai Nguyen <mai.nh at MyVietnam net>
and the support group at http://www.mvnForum.com

And many thanks to all the contributors to mvnForum, among them are:
- Anatol Pomozov       (aka wassup)     anatol.pomozov at pms-software com
- Cord Thomas          (aka cord)       cord at lupinex com
- Dejan Krsmanovic     (aka dejan)      dejan_krsmanovic at yahoo com
- Gunther Strube       (aka gbs)        gbs at users.sourceforge net
- Imants Firsts        (aka Fii)        imantsf at inbox lv
- Luis Miguel Hernanz                   luish at germinus com
- Sven Kohler          (aka skoehler)   skoehler at upb de
- Igor Manic           (aka imanic)     imanic at users.sourceforge net



2. Installation/Upgrade Instructions
==================================================================================
Please read the file INSTALL.TXT for detailed information on
how to install and/or upgrade mvnForum. This instruction is for
the binary distribution package of mvnForum.



3. Build Instructions
==================================================================================
Please read the file BUILD.TXT for detailed information on
how to build mvnForum. This instruction is for
the source distribution package of mvnForum.



3. mvnForum Development
==================================================================================
If you would like join the mvnForum development team and contribute your
code/patch, please read the file DEVELOPER.TXT first. It contains some
important notes



5. mvnForum License Agreement
==================================================================================
You MUST agree the "mvnForum License Agreement" before using mvnForum:

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or any later version.

All copyright notices regarding mvnForum MUST remain intact in
the scripts and in the outputted HTML. The "powered by" text/logo
with a link back to http://www.mvnForum.com and http://www.MyVietnam.net
in the footer of the pages MUST remain visible when the pages are viewed
on the internet or intranet.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

STOP USING MVNFORUM NOW IF YOU DO NOT AGREE THE ABOVE LICENSE

NOTE: In case you need to remove this "Powered by mvnForum", please contact us at
      web site www.MyVietnam.net to order a special "Copyright notice Removal" license
      with a small license fee. After receiving this special license, you can remove
      the copyright notice in this footer.jsp file.

NOTE: This product includes software developed by the
      Apache Software Foundation (http://www.apache.org/) and others:
      
      Activation Framework     http://java.sun.com/products/javabeans/jaf/index.jsp
      Common BeanUtils         http://jakarta.apache.org/commons/beanutils
      Common Codec             http://jakarta.apache.org/commons/codec
      Common Collections       http://jakarta.apache.org/commons/collections
      Common Digester          http://jakarta.apache.org/commons/digester
      Common IO                http://jakarta.apache.org/commons/io
      Common Lang              http://jakarta.apache.org/commons/lang
      Common Logging           http://jakarta.apache.org/commons/logging
      Configuration            http://jakarta.apache.org/commons/configuration
      Concurrent               http://gee.cs.oswego.edu/dl/classes/EDU/oswego/cs/dl/util/concurrent/intro.html
      Dom4J                    http://www.dom4j.org
      FreeMarker               http://freemarker.sourceforge.net
      Jakarta RegExp           http://jakarta.apache.org/regexp/index.html
      JCaptcha                 http://jcaptcha.sourceforge.net
      JDom                     http://www.jdom.org
      JSTL                     http://jakarta.apache.org/taglibs/index.html
      Jzonic                   http://jlo.jzonic.org
      Log4J                    http://logging.apache.org
      Lucene                   http://lucene.apache.org/
      Mail                     http://java.sun.com/products/javamail/
      Pager Taglib             http://jsptags.com/index.jsp
      dnsjava                  http://www.dnsjava.org/
      Aspirin                  https://aspirin.dev.java.net/
      WhirlyCache              https://whirlycache.dev.java.net/
      
      MySql Driver             http://dev.mysql.com/downloads/connector/j/3.0.html
      hsqldb                   http://hsqldb.sourceforge.net
      Jtds Driver              http://jtds.sourceforge.net
      PostgreSQL Driver        http://jdbc.postgresql.org

==================================================================================

Cheers!

minhnn (Minh Nguyen)
http://www.mvnForum.com
minhnn at MyVietnam d0t net
