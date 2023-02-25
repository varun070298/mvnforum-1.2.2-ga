-- $Header: /cvsroot/mvnforum/mvnforum/sql/upgrade/1_0_0_rc1_to_1_0_0_rc2/mvnForum_update_postgresql.sql,v 1.3 2007/07/02 13:05:30 minhnn Exp $
-- $Author: minhnn $
-- $Revision: 1.3 $
-- $Date: 2007/07/02 13:05:30 $
--
-- This script is used to upgrade mvnForum from RC1 to RC2
-- This script creates 3 new table : mvnforumMemberForum
--                                   mvnforumFavoriteThread
--                                   mvnforumRank
--
-- Database: PostgreSql



-- drop table mvnforumMemberForum;
-- drop table mvnforumFavoriteThread;
-- drop table mvnforumRank;

--
-- drop sequences
--
-- drop sequence mvnforumRank_seq;


--
-- create sequences
--
create sequence mvnforumRank_seq;


create table mvnforumMemberForum
(
   MemberID                       INT                            NOT NULL,
   ForumID                        INT                            NOT NULL,
   Permission                     INT                            NOT NULL,
   PRIMARY KEY (MemberID, ForumID, Permission)
);

create index MemberForum_1_idx on mvnforumMemberForum
(
   MemberID
);

create index MemberForum_2_idx on mvnforumMemberForum
(
   ForumID
);

create table mvnforumFavoriteThread
(
   MemberID                       INT                            NOT NULL,
   ThreadID                       INT                            NOT NULL,
   ForumID                        INT                            NOT NULL,
   FavoriteCreationDate           TIMESTAMP                      NOT NULL,
   FavoriteType                   INT                            NOT NULL,
   FavoriteOption                 INT                            NOT NULL,
   FavoriteStatus                 INT                            NOT NULL,
   PRIMARY KEY (MemberID, ThreadID)
);

create index FavorThread_1_idx on mvnforumFavoriteThread
(
   MemberID
);

create index FavorThread_2_idx on mvnforumFavoriteThread
(
   ThreadID
);

create table mvnforumRank
(
   RankID                         INT                            NOT NULL DEFAULT nextval('mvnforumRank_seq'),
   RankMinPosts                   INT                            NOT NULL,
   RankLevel                      INT                            NOT NULL,
   RankTitle                      VARCHAR(250)                   NOT NULL,
   RankImage                      VARCHAR(250)                   NOT NULL,
   RankType                       INT                            NOT NULL,
   RankOption                     INT                            NOT NULL,
   PRIMARY KEY (RankID),
   UNIQUE (RankMinPosts),
   UNIQUE (RankTitle)
);



--
-- data for table mvnforumRank
--
INSERT INTO mvnforumRank (RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption) 
                  VALUES (0, 0, 'Stranger',                   '',        0,        0);
INSERT INTO mvnforumRank (RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption) 
                  VALUES (20, 0, 'Newbie',                    '',        0,        0);
INSERT INTO mvnforumRank (RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption) 
                  VALUES (50, 0, 'Member',                    '',        0,        0);
INSERT INTO mvnforumRank (RankMinPosts, RankLevel, RankTitle, RankImage, RankType, RankOption) 
                  VALUES (100, 0, 'Advanced Member',          '',        0,        0);

