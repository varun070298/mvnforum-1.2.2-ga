-- This script is used to upgrade mvnForum from beta3 to rc1
-- This sql script creates 2 new table : mvnforumWatch and mvnforumAttachment
--
-- Database: PostgreSql



-- drop table mvnforumWatch;
-- drop table mvnforumAttachment;


--
-- drop sequences
--
-- drop sequence mvnforumWatch_seq;
-- drop sequence mvnforumAttachment_seq;

--
-- create sequences
--
create sequence mvnforumWatch_seq;
create sequence mvnforumAttachment_seq;



create table mvnforumWatch
(
   WatchID                        INT                            NOT NULL DEFAULT nextval('mvnforumWatch_seq'),
   MemberID                       INT                            NOT NULL,
   CategoryID                     INT                            NOT NULL,
   ForumID                        INT                            NOT NULL,
   ThreadID                       INT                            NOT NULL,
   WatchType                      INT                            NOT NULL,
   WatchOption                    INT                            NOT NULL,
   WatchStatus                    INT                            NOT NULL,
   WatchCreationDate              TIMESTAMP                      NOT NULL,
   WatchLastSentDate              TIMESTAMP                      NOT NULL,
   WatchEndDate                   TIMESTAMP                      NOT NULL,
   PRIMARY KEY (WatchID),
   UNIQUE (MemberID, CategoryID, ForumID, ThreadID)
);

create index Watch_MemberID_idx on mvnforumWatch
(
   MemberID
);

create index Watch_CategoryID_idx on mvnforumWatch
(
   CategoryID
);

create index Watch_ForumID_idx on mvnforumWatch
(
   ForumID
);

create index Watch_ThreadID_idx on mvnforumWatch
(
   ThreadID
);

create table mvnforumAttachment
(
   AttachID                       INT                            NOT NULL DEFAULT nextval('mvnforumAttachment_seq'),
   PostID                         INT                            NOT NULL,
   MemberID                       INT                            NOT NULL,
   AttachFilename                 VARCHAR(250)                   NOT NULL,
   AttachFileSize                 INT                            NOT NULL,
   AttachMimeType                 VARCHAR(70)                    NOT NULL,
   AttachDesc                     VARCHAR(250)                   NOT NULL,
   AttachCreationIP               VARCHAR(20)                    NOT NULL,
   AttachCreationDate             TIMESTAMP                      NOT NULL,
   AttachModifiedDate             TIMESTAMP                      NOT NULL,
   AttachDownloadCount            INT                            NOT NULL,
   AttachOption                   INT                            NOT NULL,
   AttachStatus                   INT                            NOT NULL,
   PRIMARY KEY (AttachID)
);

create index Attachment_PostID_idx on mvnforumAttachment
(
   PostID
);

create index Attachment_MemberID_idx on mvnforumAttachment
(
   MemberID
);

