/*
 * $Header: /cvsroot/mvnforum/mvnforum/contrib/phpbb2mvnforum/src/org/mvnforum/phpbb2mvnforum/db/CategoryDAO.java,v 1.6 2007/01/15 10:27:34 dungbtm Exp $
 * $Author: dungbtm $
 * $Revision: 1.6 $
 * $Date: 2007/01/15 10:27:34 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2007 by MyVietnam.net
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
 * @author: Minh Nguyen  
 */
package org.mvnforum.phpbb2mvnforum.db;

import java.sql.Timestamp;
import java.util.Collection;

import net.myvietnam.mvncore.exception.CreateException;
import net.myvietnam.mvncore.exception.DatabaseException;
import net.myvietnam.mvncore.exception.DuplicateKeyException;
import net.myvietnam.mvncore.exception.ObjectNotFoundException;

public interface CategoryDAO {

    public static final String TABLE_NAME = "mvnforumCategory";

    public void findByPrimaryKey(int categoryID) throws ObjectNotFoundException, DatabaseException;

    public void findByAlternateKey_CategoryName(String categoryName) throws ObjectNotFoundException, DatabaseException;

    public void create(int categoryID, int parentCategoryID, String categoryName, String categoryDesc,
            Timestamp categoryCreationDate, Timestamp categoryModifiedDate, int categoryOrder, int categoryOption,
            int categoryStatus) 
        throws CreateException, DatabaseException, DuplicateKeyException;

    public void createMultiple(Collection beans);

}
