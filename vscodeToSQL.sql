create DATABASE board_kkh;

USE board_kkh;


CREATE TABLE user (
  email varchar(50) COLLATE utf8mb3_bin NOT NULL COMMENT '유저 이메일',
  `password` varchar(200) COLLATE utf8mb3_bin NOT NULL COMMENT '암호화된 비밀번호',
  `nickname` varchar(50) COLLATE utf8mb3_bin NOT NULL COMMENT '유저 닉네임',
  `tel_number` varchar(15) COLLATE utf8mb3_bin NOT NULL COMMENT '유저 휴대전화 번호',
  `address` text COLLATE utf8mb3_bin NOT NULL COMMENT '유저 주소',
  `address_detail` text COLLATE utf8mb3_bin COMMENT '유저 상세 주소',
  `agreed_personal` tinyint NOT NULL COMMENT '개인정보 동의 여부',
  `profile_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL COMMENT '유저 프로필 사진 URL',
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `tel_number_UNIQUE` (`tel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='사용자 테이블';

CREATE TABLE `board` (
  `board_number` int NOT NULL AUTO_INCREMENT COMMENT '게시물 번호',
  `title` text COLLATE utf8mb3_bin NOT NULL COMMENT '게시물 제목',
  `contents` text COLLATE utf8mb3_bin NOT NULL COMMENT '게시물 내용',
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시물 작성 날짜 및 시간',
  `view_count` int NOT NULL DEFAULT '0' COMMENT '게시물 조회수',
  `writer_email` varchar(50) COLLATE utf8mb3_bin NOT NULL COMMENT '작성자 이메일',
  `comment_count` int NOT NULL DEFAULT '0' COMMENT '댓글 수',
  `favorite_count` int NOT NULL DEFAULT '0' COMMENT '좋아요 수',
  PRIMARY KEY (`board_number`),
  UNIQUE KEY `board_number_UNIQUE` (`board_number`),
  KEY `fk_board_user_idx` (`writer_email`),
  CONSTRAINT `fk_board_user` FOREIGN KEY (`writer_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='게시물 테이블';

CREATE TABLE `comment` (
  `user_email` varchar(50) COLLATE utf8mb3_bin NOT NULL COMMENT '댓글 작성자 이메일',
  `board_number` int NOT NULL COMMENT '댓글 대상 게시물 번호',
  `contents` text COLLATE utf8mb3_bin NOT NULL COMMENT '댓글 내용',
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '댓글 작성 날짜 및 시간',
  KEY `comment_user_FK_idx` (`user_email`),
  KEY `comment_board_FK_idx` (`board_number`),
  CONSTRAINT `comment_board_FK` FOREIGN KEY (`board_number`) REFERENCES `board` (`board_number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_user_FK` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='댓글 관계 테이블 (유저 - 게시물)';

CREATE TABLE `favorite` (
  `user_email` varchar(50) COLLATE utf8mb3_bin NOT NULL COMMENT '좋아요한 사용자 이메일',
  `board_number` int NOT NULL COMMENT '대상 게시물 번호',
  PRIMARY KEY (`user_email`,`board_number`),
  KEY `fk_user_has_board_board1_idx` (`board_number`),
  KEY `fk_user_has_board_user1_idx` (`user_email`),
  CONSTRAINT `fk_user_has_board_board1` FOREIGN KEY (`board_number`) REFERENCES `board` (`board_number`),
  CONSTRAINT `fk_user_has_board_user1` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='좋아요 관계 테이블 (유저 - 게시물)';


CREATE TABLE `search_log` (
  `search_word` text COLLATE utf8mb3_bin NOT NULL COMMENT '검색어',
  `relation_word` text COLLATE utf8mb3_bin COMMENT '관련검색어',
  `relation` tinyint(1) NOT NULL COMMENT '연관검색어여부'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='검색 기록 테이블';