DROP TABLE IF EXISTS "category";
CREATE TABLE "category" ("category_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "category" VARCHAR(200) NOT NULL  UNIQUE , "desc" TEXT, "is_inactive" INTEGER(1) NOT NULL  DEFAULT 0, "parent_category_id" INTEGER, FOREIGN KEY(parent_category_id) REFERENCES category(category_id));
DROP TABLE IF EXISTS "comment";
CREATE TABLE "comment" ("comment_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "post_id" INTEGER NOT NULL , "user_id" INTEGER NOT NULL , "comment" TEXT NOT NULL , "reply_to_id" INTEGER, "dt_cre" DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP, "dt_upd" DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(post_id) REFERENCES post(post_id),
FOREIGN KEY(user_id) REFERENCES user(user_id),
FOREIGN KEY(reply_to_id) REFERENCES comment(comment_id));
DROP TABLE IF EXISTS "post";
CREATE TABLE "post" ("post_id"  INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ,"title" VARCHAR(255) NOT NULL ,"description" TEXT,"post" TEXT NOT NULL ,"user_id" INTEGER NOT NULL,"category_id" INTEGER NOT NULL ,"rate_like" DOUBLE NOT NULL  DEFAULT (0) ,"dt_cre" DATETIME NOT NULL  DEFAULT (CURRENT_TIMESTAMP) ,"dt_upd" DATETIME DEFAULT (CURRENT_TIMESTAMP),
FOREIGN KEY(user_id) REFERENCES user(user_id),
FOREIGN KEY(category_id) REFERENCES category(category_id));
DROP TABLE IF EXISTS "tag";
CREATE TABLE "tag" ("tag_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "tag" VARCHAR(200) NOT NULL  UNIQUE , "desc" TEXT, "post_id" VARCHAR(255));
DROP TABLE IF EXISTS "user";
CREATE TABLE "user" ("user_id" INTEGER PRIMARY KEY  NOT NULL ,"username" VARCHAR(50) NOT NULL ,"password" VARCHAR(50) NOT NULL ,"email" VARCHAR(50) NOT NULL ,"last_ip" VARCHAR(20) NOT NULL ,"last_dt_login" DATETIME NOT NULL  DEFAULT (CURRENT_TIMESTAMP) ,"dt_cre" DATETIME NOT NULL  DEFAULT (CURRENT_TIMESTAMP) );
INSERT INTO "user" VALUES(1,'admin','admin','metreysk@gmail.com','172.0.0.1','2012-09-17 16:06:46','2012-09-17 16:06:46');
