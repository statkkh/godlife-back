CREATE TABLE `user` (
  `user_email` VARCHAR(50) NOT NULL PRIMARY KEY,
  `user_password` VARCHAR(255) NULL,
  `user_nickname` VARCHAR(50) NOT NULL,
  `user_favorite1` VARCHAR(20) NOT NULL,
  `user_favorite2` VARCHAR(20) NULL,
  `user_favorite3` VARCHAR(20) NULL,
  `user_profile_image_url` VARCHAR(255) NULL,
  `user_exp` INT NOT NULL DEFAULT 0
);

DROP TABLE user;



CREATE TABLE `study_todolist` (
	`study_list_number`	INT PRIMARY KEY AUTO_INCREMENT,
	`study_number`	INT	NOT NULL,
	`study_list_content`	VARCHAR(255)	NULL,
	`study_list_check`	BOOLEAN	NOT NULL	DEFAULT false,
    FOREIGN KEY (study_number) REFERENCES study (study_number)
);

DROP TABLE study_todolist;

CREATE TABLE study_notice (
	study_notice_number	 INT PRIMARY KEY AUTO_INCREMENT,
	study_number	INT	NOT NULL,
	study_notice_content	VARCHAR(255)	NULL,
    FOREIGN KEY (study_number) REFERENCES study (study_number)
);

DROP TABLE study_notice;

CREATE TABLE `study_material` (
	`study_material_number`	 INT PRIMARY KEY AUTO_INCREMENT,
	`study_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_material_name`	VARCHAR(50)	NULL,
	`study_material_image_url`	VARCHAR(500)	NULL,
	`study_material_writer`	VARCHAR(50)	NOT NULL,
	`study_material_datetime`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (study_number) REFERENCES study (study_number)
);

DROP TABLE study_material;

CREATE TABLE `study_material_comment` (
	`study_material_comment_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_material_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_material_comment_content`	VARCHAR(255)	NULL,
	`study_material_comment_datetime`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (study_material_number) REFERENCES study_material (study_material_number),
    FOREIGN KEY (user_email) REFERENCES user (user_email)
);

DROP TABLE study_material_comment;

CREATE TABLE `user_attendance_information` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`user_attendance_check`	VARCHAR(10)	NOT NULL,
	`owner_attendance_start`	DATETIME	NOT NULL,
    FOREIGN KEY (study_number) REFERENCES study (study_number),
    FOREIGN KEY (user_email) REFERENCES user (user_email)
);

DROP TABLE user_attendance_information;

CREATE TABLE `study_user_list` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_grade`	VARCHAR(255)	NOT NULL,
    FOREIGN KEY (study_number) REFERENCES study (study_number),
    FOREIGN KEY (user_email) REFERENCES user (user_email)
);

DROP TABLE study_user_list;

DROP TABLE user;

-- ALTER TABLE study_notice ADD 