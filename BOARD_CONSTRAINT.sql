CREATE DATABASE sample_board_2;
USE board_kkh;


CREATE TABLE user (
	email VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(20) NOT NULL UNIQUE,
    tel_number VARCHAR(15) NOT NULL UNIQUE,
    address TEXT NOT NULL,
    address_detail TEXT,
    agreed_personal BOOLEAN NOT NULL CHECK(agreed_personal IS true),
    profile_image VARCHAR(500) NOT NULL DEFAULT 'https://blog.kakaocdn.net/dn/bj4oa7/btqLJWFLMgd/wu4GV8PKbXdICuyW0me0zk/img.jpg'
);

CREATE TABLE board (
	board_number INT PRIMARY KEY AUTO_INCREMENT,
    title TEXT NOT NULL,
    contents TEXT NOT NULL,
    write_datetime DATETIME NOT NULL DEFAULT now(),
    writer_email VARCHAR(50) NOT NULL,
    view_count INT NOT NULL DEFAULT 0,
    FOREIGN KEY (writer_email) REFERENCES user (email)
);

CREATE TABLE favorite (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    UNIQUE (board_number, user_email),
    FOREIGN KEY (board_number) REFERENCES board (board_number),
    FOREIGN KEY (user_email) REFERENCES user (email)
);

CREATE TABLE comment (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    write_datetime DATETIME NOT NULL DEFAULT now(),
    FOREIGN KEY (board_number) REFERENCES board (board_number),
    FOREIGN KEY (user_email) REFERENCES user (email)
);