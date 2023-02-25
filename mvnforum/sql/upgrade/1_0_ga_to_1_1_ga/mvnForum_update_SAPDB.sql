-- $Header: /cvsroot/mvnforum/mvnforum/sql/upgrade/1_0_ga_to_1_1_ga/mvnForum_update_SAPDB.sql,v 1.5 2008/01/14 09:50:09 minhnn Exp $
-- $Author: minhnn $
-- $Revision: 1.5 $
-- $Date: 2008/01/14 09:50:09 $
--
-- This script is used to upgrade mvnForum from 1.0 GA to 1.1 GA
--
-- Database: SAPDB 



ALTER TABLE mvnforumForum ADD ForumOwnerName VARCHAR(30);
UPDATE mvnforumForum SET ForumOwnerName = '' ;

ALTER TABLE mvnforumThread ADD ThreadPriority INT ;
UPDATE mvnforumThread SET ThreadPriority = 0 ;

ALTER TABLE mvnforumMember ADD MemberPasswordExpireDate TIMESTAMP;
UPDATE mvnforumMember SET MemberPasswordExpireDate = MemberCreationDate ;
