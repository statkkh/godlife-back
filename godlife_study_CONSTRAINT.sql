CREATE TABLE `user` (
  `user_email` VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '유저 이메일',
  `user_password` VARCHAR(255) NULL COMMENT '유저 비밀번호',
  `user_nickname` VARCHAR(50) NOT NULL COMMENT '유저 닉네임',
  `user_favorite1` VARCHAR(20) NOT NULL COMMENT '유저 관심 1',
  `user_favorite2` VARCHAR(20) NULL COMMENT '유저 관심 2',
  `user_favorite3` VARCHAR(20) NULL COMMENT '유저 관심 3',
  `user_profile_image_url` VARCHAR(255) NULL COMMENT '유저 프로필 사진 URL',
  `user_experience` INT NOT NULL DEFAULT 0 COMMENT '유저 경험치'
);

DROP TABLE user;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `study_material` (
	`study_material_number`	 INT PRIMARY KEY AUTO_INCREMENT COMMENT '스터디 자료 번호',
	`study_number`	INT	NOT NULL	COMMENT '스터디 방 번호',
	`study_material_name` VARCHAR(50)	NULL COMMENT '스터디 자료 이름',
	`study_material_image_url` VARCHAR(500) NULL COMMENT '스터디 자료 이름',
	`study_material_writer`	VARCHAR(50)	NOT NULL COMMENT '스터디 자료 작성자',
	`study_material_datetime` DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP COMMENT '스터디 자료 업로드 일자',
    CONSTRAINT `fk_study_material_study_idx` FOREIGN KEY (study_number) REFERENCES study (study_number) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE study_material;

CREATE TABLE `study_material_comment` (
	`study_material_comment_number`	INT	PRIMARY KEY AUTO_INCREMENT	COMMENT '스터디 자료 코멘트 번호',
	`study_material_number`  INT NOT NULL COMMENT '스터디 자료 번호',
	`user_email` VARCHAR(50)	NOT NULL COMMENT '유저 이메일',
	`study_material_comment_content` VARCHAR(255)	NULL COMMENT '스터디 자료 코멘트 내용',
	`study_material_comment_datetime` DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '코멘트 등록 시간',
    CONSTRAINT `fk_study_material_comment_study_material_idx` FOREIGN KEY (study_material_number) REFERENCES study_material (study_material_number)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT `fk_study_material_comment_user_idx` FOREIGN KEY (user_email) REFERENCES user (user_email)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

DROP TABLE study_material_comment;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `user_attendance_information` (
	`study_number`	INT	NOT NULL COMMENT '스터디 방 번호',
	`user_email`	VARCHAR(50)	NOT NULL COMMENT '유저 이메일',
	`user_attendance_check`	VARCHAR(10)	NOT NULL COMMENT '출석체크',
	`owner_attendance_start`	DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '방장 출석 시작시간',
    CONSTRAINT `fk_user_attendance_information_study_idx`  FOREIGN KEY (study_number) REFERENCES study (study_number)
    ON UPDATE CASCADE    ON DELETE CASCADE,
    CONSTRAINT `fk_user_attendance_information_user_idx` FOREIGN KEY (user_email) REFERENCES user (user_email)
    ON UPDATE CASCADE    ON DELETE CASCADE
);

DROP TABLE user_attendance_information;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `study_user_list` (
	`study_number`	INT	NOT NULL COMMENT '스터디 방 번호',
	`user_email`	VARCHAR(50)	NOT NULL COMMENT '유저 이메일',
	`study_grade`	VARCHAR(255)	NOT NULL COMMENT '권한',
    CONSTRAINT `fk_study_user_list_study_idx`FOREIGN KEY (study_number) REFERENCES study (study_number)
    ON UPDATE CASCADE  ON DELETE CASCADE,
    CONSTRAINT `fk_study_user_list_user_idx`FOREIGN KEY (user_email) REFERENCES user (user_email) 
    ON UPDATE CASCADE  ON DELETE CASCADE
);

DROP TABLE study_user_list;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `study` (
	`study_number`	INT	PRIMARY KEY AUTO_INCREMENT	COMMENT '스터디 방 번호',
	`study_name`	VARCHAR(255)	NOT NULL COMMENT '스터디 제목',
	`study_start_date`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP COMMENT '스터디 시작일',
	`study_end_date`	DATETIME	NOT NULL COMMENT '스터디 종료일',
	`study_personal`	INT	NOT NULL	DEFAULT 0 COMMENT '스터디 인원',
	`study_category1`	VARCHAR(20)	NOT NULL COMMENT '스터디 카테고리1',
	`study_category2`	VARCHAR(20)	NULL COMMENT '',
	`study_category3`	VARCHAR(20)	NULL COMMENT '',
	`study_public_check`	BOOLEAN	NOT NULL	DEFAULT true COMMENT '스터디 공개 구분',
	`study_private_password`	VARCHAR(20)	NULL COMMENT '스터디 비공개 비밀번호',
	`study_cover_image_url`	VARCHAR(255)	NULL COMMENT '스터디 커버 이미지 URL',
	`study_next_start_datetime`	DATETIME	NULL COMMENT '다음 스터디 시작 시간',
	`study_next_end_datetime`	DATETIME	NULL COMMENT '다음 스터디 종료 시간',
	`study_total_day`	INT	NULL DEFAULT 0 COMMENT '총 스터디 일수',
	`create_study_user_email`	VARCHAR(50)	NOT NULL COMMENT '방 생성 유저 이메일'
);

DROP TABLE study;

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `study_notice` (
	`study_notice_number`	 INT PRIMARY KEY AUTO_INCREMENT COMMENT '스터디 공지사항 번호',
	`study_number` INT NOT NULL COMMENT '스터디 방 번호',
	`study_notice_content` VARCHAR(255)	NULL COMMENT '스터디 공지사항 내용',
    CONSTRAINT `fk_study_notice_study_idx` FOREIGN KEY (`study_number`) REFERENCES study (`study_number`)
    ON UPDATE CASCADE    ON DELETE CASCADE
);

DROP TABLE study_notice;

CREATE TABLE `study_todolist` (
	`study_list_number`	INT PRIMARY KEY AUTO_INCREMENT COMMENT '스터디 투두리스트 번호',
	`study_number`	INT	NOT NULL COMMENT '스터디 방 번호', 
	`study_list_content` VARCHAR(255) NULL COMMENT '스터디 투두리스트 내용',
	`study_list_check`	BOOLEAN	NOT NULL	DEFAULT false COMMENT '스터디 투두리스트 확인',
    CONSTRAINT `fk_study_todolist_study_idx` FOREIGN KEY (study_number) REFERENCES study (study_number)
    ON UPDATE CASCADE    ON DELETE CASCADE
);

DROP TABLE study_todolist;
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE `study_chat` (
	`study_number`	INT	NOT NULL COMMENT '스터디방 번호',
	`user_email`	VARCHAR(50)	NOT NULL COMMENT '유저이메일',
	`study_chat_content`  VARCHAR(255) NULL COMMENT '스터디채팅내용',
	`study_chat_datetime`  DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '채팅종료시간',
    CONSTRAINT `fk_study_chat_study_idx` FOREIGN KEY (study_number) REFERENCES study (study_number)
    ON UPDATE CASCADE  ON DELETE CASCADE,
    CONSTRAINT `fk_study_chat_user_idx` FOREIGN KEY (user_email) REFERENCES user(user_email)
    ON UPDATE CASCADE  ON DELETE CASCADE    
);

DROP TABLE study_chat;

DROP TABLE user_todolist;

DROP TABLE email_transfer_code;

-- ALTER TABLE study_notice ADD 