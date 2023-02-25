/*
 * $Header: /cvsroot/mvnforum/myvietnam/src/net/myvietnam/mvncore/db/MVNDataSource.java,v 1.4 2007/09/26 04:11:06 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.4 $
 * $Date: 2007/09/26 04:11:06 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2007 by MyVietnam.net
 *
 * All copyright notices regarding MyVietnam and MyVietnam CoreLib
 * MUST remain intact in the scripts and source code.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Correspondence and Marketing Questions can be sent to:
 * info at MyVietnam net
 *
 * @author: Minh Nguyen  
 */
package net.myvietnam.mvncore.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.lang.NotImplementedException;

/**
 * Implementation of DataSource based on built-in connection pool
 * 
 */
public class MVNDataSource extends AbstractDataSource {
    
    private boolean autoCommit;
    
    public MVNDataSource(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DBUtils.getConnection();
        if (connection.getAutoCommit() != autoCommit) {
            connection.setAutoCommit(autoCommit);
        }
        return connection;
    }

    public Connection getConnection(String username, String password) throws SQLException {
        throw new NotImplementedException("getConnection");
    }

}
