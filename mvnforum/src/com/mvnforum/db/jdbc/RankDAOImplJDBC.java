/*
 * $Header: /cvsroot/mvnforum/mvnforum/src/com/mvnforum/db/jdbc/RankDAOImplJDBC.java,v 1.17 2008/05/30 04:41:33 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.17 $
 * $Date: 2008/05/30 04:41:33 $
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
 * @author: Mai  Nguyen
 */
package com.mvnforum.db.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import com.mvnforum.db.RankBean;
import com.mvnforum.db.RankDAO;
import net.myvietnam.mvncore.db.DBUtils;
import net.myvietnam.mvncore.exception.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RankDAOImplJDBC implements RankDAO {

    private static final Log log = LogFactory.getLog(RankDAOImplJDBC.class);

    // this variable will support caching if cache for this class is needed
    private static boolean m_dirty = true;

    public RankDAOImplJDBC() {
    }

    public static boolean isDirty() {
        return m_dirty;
    }

    public static void setDirty(boolean dirty) {
        m_dirty = dirty;
    }

    public void findByAlternateKey_RankTitle(String rankTitle)
        throws ObjectNotFoundException, DatabaseException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("SELECT RankTitle");
        sql.append(" FROM " + TABLE_NAME);
        if (DBUtils.isCaseSensitiveDatebase()) {
            sql.append(" WHERE lower(RankTitle) = lower(?)");
        } else {
            sql.append(" WHERE RankTitle = ?");
        }
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, rankTitle);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ObjectNotFoundException("Cannot find the alternate key [RankTitle] (" + rankTitle + ") in table 'Rank'.");
            }
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.findByAlternateKey_RankTitle.");
        } finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    public void findByAlternateKey_RankMinPosts(int rankMinPosts)
        throws ObjectNotFoundException, DatabaseException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("SELECT RankMinPosts");
        sql.append(" FROM " + TABLE_NAME);
        sql.append(" WHERE RankMinPosts = ?");
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, rankMinPosts);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ObjectNotFoundException("Cannot find the alternate key [RankMinPosts] (" + rankMinPosts + ") in table 'Rank'.");
            }
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.findByAlternateKey_RankMinPosts.");
        } finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    /*
     * Included columns: RankMinPosts, RankLevel, RankTitle, RankImage, RankType,
     *                   RankOption
     * Excluded columns: RankID
     */
    public void create(int rankMinPosts, int rankLevel, String rankTitle,
                       String rankImage, int rankType, int rankOption)
        throws CreateException, DatabaseException, DuplicateKeyException {

        // @todo: Comment this try-catch block if the needed columns don't have attribute 'include'
        // If this is the case, then it is highly recommended that you regenerate this method with the attribute 'include' turned on
        try {
            //Check if alternate key already exists
            findByAlternateKey_RankTitle(rankTitle);
            //If so, then we have to throw an exception
            throw new DuplicateKeyException("Alternate key already exists. Cannot create new Rank with the same [RankTitle] (" + rankTitle + ").");
        } catch(ObjectNotFoundException e) {
            //Otherwise we can go ahead
        }

        // @todo: Comment this try-catch block if the needed columns don't have attribute 'include'
        // If this is the case, then it is highly recommended that you regenerate this method with the attribute 'include' turned on
        try {
            //Check if alternate key already exists
            findByAlternateKey_RankMinPosts(rankMinPosts);
            //If so, then we have to throw an exception
            throw new DuplicateKeyException("Alternate key already exists. Cannot create new Rank with the same [RankMinPosts] (" + rankMinPosts + ").");
        } catch(ObjectNotFoundException e) {
            //Otherwise we can go ahead
        }

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("INSERT INTO " + TABLE_NAME + " (RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption)");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?)");
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());

            statement.setInt(1, rankMinPosts);
            statement.setInt(2, rankLevel);
            statement.setString(3, rankTitle);
            statement.setString(4, rankImage);
            statement.setInt(5, rankType);
            statement.setInt(6, rankOption);

            if (statement.executeUpdate() != 1) {
                throw new CreateException("Error adding a row into table 'Rank'.");
            }
            m_dirty = true;
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.create.");
        } finally {
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    /*
     * Included columns: RankMinPosts, RankLevel, RankTitle, RankImage, RankType,
     *                   RankOption
     * Excluded columns: RankID
     */
    public void update(int rankID, // primary key
                       int rankMinPosts, int rankLevel, String rankTitle,
                       String rankImage, int rankType, int rankOption)
        throws ObjectNotFoundException, DatabaseException, DuplicateKeyException {

        RankBean bean = getRank(rankID);

        if (rankTitle.equalsIgnoreCase(bean.getRankTitle()) == false) {
            // Rank tries to change its alternate key <RankTitle>, so we must check if it already exist
            try {
                findByAlternateKey_RankTitle(rankTitle);
                throw new DuplicateKeyException("Alternate key [RankTitle] (" + rankTitle + ") already exists. Cannot update Rank.");
            } catch(ObjectNotFoundException e) {
                //Otherwise we can go ahead
            }
        }

        if (rankMinPosts != bean.getRankMinPosts()) {
            // Rank tries to change its alternate key <RankMinPosts>, so we must check if it already exist
            try {
                findByAlternateKey_RankMinPosts(rankMinPosts);
                throw new DuplicateKeyException("Alternate key [RankMinPosts] (" + rankMinPosts + ") already exists. Cannot update Rank.");
            } catch(ObjectNotFoundException e) {
                //Otherwise we can go ahead
            }
        }

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("UPDATE " + TABLE_NAME + " SET RankMinPosts = ?, RankLevel = ?, RankTitle = ?, RankImage = ?, RankType = ?, RankOption = ?");
        sql.append(" WHERE RankID = ?");
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());

            // // column(s) to update
            statement.setInt(1, rankMinPosts);
            statement.setInt(2, rankLevel);
            statement.setString(3, rankTitle);
            statement.setString(4, rankImage);
            statement.setInt(5, rankType);
            statement.setInt(6, rankOption);

            // primary key column(s)
            statement.setInt(7, rankID);

            if (statement.executeUpdate() != 1) {
                throw new ObjectNotFoundException("Cannot update table Rank where primary key = (" + rankID + ").");
            }
            m_dirty = true;
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.update.");
        } finally {
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    public void delete(int rankID)
        throws DatabaseException, ObjectNotFoundException {

        Connection connection = null;
        PreparedStatement statement = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("DELETE FROM " + TABLE_NAME);
        sql.append(" WHERE RankID = ?");

        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, rankID);
            if (statement.executeUpdate() != 1) {
                throw new ObjectNotFoundException("Cannot delete a row in table Rank where primary key = (" + rankID + ").");
            }
            m_dirty = true;
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.delete.");
        } finally {
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    /*
     * Included columns: RankMinPosts, RankLevel, RankTitle, RankImage, RankType,
     *                   RankOption
     * Excluded columns: RankID
     */
    public RankBean getRank(int rankID)
        throws ObjectNotFoundException, DatabaseException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuffer sql = new StringBuffer(512);
        sql.append("SELECT RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption");
        sql.append(" FROM " + TABLE_NAME);
        sql.append(" WHERE RankID = ?");
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());
            statement.setInt(1, rankID);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ObjectNotFoundException("Cannot find the row in table Rank where primary key = (" + rankID + ").");
            }

            RankBean bean = new RankBean();
            // @todo: uncomment the following line(s) as needed
            bean.setRankID(rankID);
            bean.setRankMinPosts(resultSet.getInt("RankMinPosts"));
            bean.setRankLevel(resultSet.getInt("RankLevel"));
            bean.setRankTitle(resultSet.getString("RankTitle"));
            bean.setRankImage(resultSet.getString("RankImage"));
            bean.setRankType(resultSet.getInt("RankType"));
            bean.setRankOption(resultSet.getInt("RankOption"));
            return bean;
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.getRank(pk).");
        } finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    /*
     * Included columns: RankID, RankMinPosts, RankLevel, RankTitle, RankImage,
     *                   RankType, RankOption
     * Excluded columns:
     */
    public Collection getRanks()
        throws DatabaseException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Collection retValue = new ArrayList();
        StringBuffer sql = new StringBuffer(512);
        sql.append("SELECT RankID, RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption");
        sql.append(" FROM " + TABLE_NAME);
        //sql.append(" WHERE "); // @todo: uncomment as needed
        sql.append(" ORDER BY RankMinPosts ASC ");
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RankBean bean = new RankBean();
                bean.setRankID(resultSet.getInt("RankID"));
                bean.setRankMinPosts(resultSet.getInt("RankMinPosts"));
                bean.setRankLevel(resultSet.getInt("RankLevel"));
                bean.setRankTitle(resultSet.getString("RankTitle"));
                bean.setRankImage(resultSet.getString("RankImage"));
                bean.setRankType(resultSet.getInt("RankType"));
                bean.setRankOption(resultSet.getInt("RankOption"));
                retValue.add(bean);
            }
            return retValue;
        } catch(SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.getRanks.");
        } finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

    public int getRankIDFromRankTitle(String rankTitle)
        throws ObjectNotFoundException, DatabaseException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT RankID FROM " + TABLE_NAME +
                     " WHERE RankTitle = ?";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, rankTitle);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ObjectNotFoundException("Cannot find the alternate key [RankTitle] (" + rankTitle + ") in table 'Rank'.");
            }
            return resultSet.getInt(1);
        } catch (SQLException sqle) {
            log.error("Sql Execution Error!", sqle);
            throw new DatabaseException("Error executing SQL in RankDAOImplJDBC.getRankIDFromRankTitle.");
        } finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeStatement(statement);
            DBUtils.closeConnection(connection);
        }
    }

}// end of class RankDAOImplJDBC
