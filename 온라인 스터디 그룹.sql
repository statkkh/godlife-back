

CREATE TABLE `study` (
	`study_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_name`	VARCHAR(255)	NOT NULL,
	`study_start_date`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`study_end_date`	DATETIME	NOT NULL,
	`study_personal`	INT	NOT NULL	DEFAULT 0,
	`study_category1`	VARCHAR(20)	NOT NULL,
	`study_category2`	VARCHAR(20)	NULL,
	`study_category3`	VARCHAR(20)	NULL,
	`study_public_check`	BOOLEAN	NOT NULL	DEFAULT true,
	`study_private_password`	VARCHAR(20)	NULL,
	`study_cover_image_url`	VARCHAR(255)	NULL,
	`study_next_start_datetime`	DATETIME	NULL,
	`study_next_end_datetime`	DATETIME	NULL,
	`study_total_day`	INT	NULL	DEFAULT 0,
	`create_study_user_email`	VARCHAR(50)	NOT NULL
);

CREATE TABLE `study_material` (
	`study_material_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_material_name`	VARCHAR(50)	NULL,
	`study_material_image_url`	VARCHAR(500)	NULL,
	`study_material_writer`	VARCHAR(50)	NOT NULL,
	`study_material_datetime`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

﻿CREATE TABLE `user`(
	`user_email`	VARCHAR(50)	NOT NULL PRIMARY KEY,
	`user_password`	VARCHAR(255)	NULL,
	`user_nickname`	VARCHAR(50)	NOT NULL,
	`user_favorite1`	VARCHAR(20)	NOT NULL,
	`user_favorite2`	VARCHAR(20)	NULL,
	`user_favorite3`	VARCHAR(20)	NULL,
	`user_profile_image_url`	VARCHAR(255)	NULL,
	`user_exp`	INT	NOT NULL	DEFAULT 0
);


CREATE TABLE `user_todolist` (
	`user_list_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`user_email`	VARCHAR(50)	NOT NULL,
	`user_list_datetime`	DATETIME	NULL,
	`user_list_content`	VARCHAR(255)	NULL,
	`user_list_check`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `study_notice` (
	`study_notice_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_number`	INT	NOT NULL,
	`study_notice_content`	VARCHAR(255)	NULL
);

CREATE TABLE `study_todolist` (
	`study_list_number`	INT PRIMARY KEY AUTO_INCREMENT,
	`study_number`	INT	NOT NULL,
	`study_list_content`	VARCHAR(255)	NULL,
	`study_list_check`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `study_material_comment` (
	`study_material_comment_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_material_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_material_comment_content`	VARCHAR(255)	NULL,
	`study_material_comment_datetime`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP
    
);


CREATE TABLE `study_chat` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_chat_content`	VARCHAR(255)	NULL,
	`study_chat_datetime`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `user_attendance_information` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`user_attendance_check`	VARCHAR(10)	NOT NULL,
	`owner_attendance_start`	DATETIME	NOT NULL
);

CREATE TABLE `study_user_list` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_grade`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `email_transfer_code` (
	`email_number_code`	VARCHAR(6)	NOT NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_email`
);

ALTER TABLE `study` ADD CONSTRAINT `PK_STUDY` PRIMARY KEY (
	`study_number`
);

ALTER TABLE `study_material` ADD CONSTRAINT `PK_STUDY_MATERIAL` PRIMARY KEY (
	`study_material_number`
);

ALTER TABLE `user_todolist` ADD CONSTRAINT `PK_USER_TODOLIST` PRIMARY KEY (
	`user_list_number`
);

ALTER TABLE `study_notice` ADD CONSTRAINT `PK_STUDY_NOTICE` PRIMARY KEY (
	`study_notice_number`
);

ALTER TABLE `study_todolist` ADD CONSTRAINT `PK_STUDY_TODOLIST` PRIMARY KEY (
	`study_list_number`
);

ALTER TABLE `study_material_comment` ADD CONSTRAINT `PK_STUDY_MATERIAL_COMMENT` PRIMARY KEY (
	`study_material_comment_number`
);

