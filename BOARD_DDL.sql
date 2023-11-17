# 게시판 프로젝트 스키마 정의

# 데이터베이스 생성
CREATE DATABASE sample_board_1;

USE sample_board_1;

# 데이터베이스 테이블 생성
# 회원정보 (user) / 게시물 (board)
CREATE TABLE user (
	email VARCHAR(50),
    password VARCHAR(255),
    nickname VARCHAR(20),
    tel_number VARCHAR(15),
    address TEXT,
    address_detail TEXT,
    agreed_personal BOOLEAN,
    profile_image TEXT
);
# 게시물 번호 / 제목 / 내용 / 작성일 / [작성자 이메일] / 작성자 닉네임 / 
# 작성자 프로필 사진 / 
# 댓글 수 / 좋아요 수 / 조회 수 / 게시물 이미지(여러개) / 
# 좋아요한 사용자의 프로필 사진 / [좋아요한 사용자의 이메일] / 
# 좋아요한 사용자의 닉네임 / 
# 댓글 작성자의 프로필 사진 / 댓글 작성자의 닉네임 / 댓글 작성 시간 / 
# 댓글 내용 
CREATE TABLE board (
	board_number INT,
    title TEXT,
    contents TEXT,
    write_datetime DATETIME,
    writer_email VARCHAR(50),
    writer_nickname VARCHAR(20),
    writer_profile_image TEXT,
    view_count INT
);