-- 등급이 방장인 사람을 정보를 가지고 있는 코멘트  
-- 유저등급, 유저프로필이미지,유저닉네임 자료코멘트 , 작성시간

-- 유저리스트에 속하고 스터디 방생성자인 유저
SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade
FROM user AS U
INNER JOIN study_user_list AS SULcommentstudy_todolist
ON U.user_email = SUL.user_email
INNER JOIN study AS S
ON U.user_email = S.create_study_user_email;

-- 스터디 자료 코멘트의  자료번호가 일치하고 스터디 자료가 있는 스터디 방번호가 일치한 
SELECT SMC.study_material_comment_content AS material_comment_content
FROM study AS S
INNER JOIN study_material AS SM
ON S.study_number = SM.study_number
INNER JOIN study_material_comment AS SMC
ON  SM.study_material_number = SMC.study_material_number;

-- INNER JOIN(
--     SELECT study_material_comment_content, user_email, study_material_comment_number
--     FROM study_material_comment
-- ) AS SMC
-- ON U.user_email = SMC.user_email
-- WHERE SUL.study_grade = '방장'
-- ;



-- 코멘투 유저가  사람을 정보를 가지고 있는 코멘트  
CREATE VIEW study_user AS
SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
;

SELECT * FROM study_user;

DELETE  FROM study_user_view;

-- 접속유저가 방생성자인 정보
SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    SUL.study_grade
FROM study AS S 
INNER JOIN study_user_list AS SUL
ON S.create_study_user_email = SUL.user_email;

-- -- -- -- -- -- notice && user && user_list && study-- -- -- -- -- -- 

-- 공지사항의 스터디 방번호가 유저리스트의 방번호가 일치한   스터디 방 생성자인 유저
SELECT S.study_number,SN.study_notice_number,SN.study_notice_content
FROM study AS S
INNER JOIN User AS U
ON  S.create_study_user_email = U.user_email
INNER JOIN study_user_list AS SUL
ON S.study_number = SUL.study_number AND S.create_study_user_email = SUL.study_number
INNER JOIN study_notice AS SN
ON S.study_number = SN.study_number
;

-- 공지사항의 스터디 방번호가 유저리스트의 방번호가 일치한  유저
-- -- -- -- -- --study_user_list&&  notice && study -- -- -- -- -- -- 

-- CREATE VIEW study_user_view AS
SELECT 
	SN.study_notice_number, 
	SUL.study_number,
    SN.study_notice_content
FROM study_user_list AS  SUL
INNER JOIN User AS U
ON U.user_email = SUL.user_email
INNER JOIN study_notice AS SN
ON	SUL.study_number = SN.study_number
WHERE SN.study_number = 1
;


-- 투두의 스터디 방번호가 유저리스트의 방번호가 일치한   스터디 방 생성자인 유저
SELECT ST.study_list_number, S.study_number,ST.study_list_content, ST.study_list_check
FROM study AS S
INNER JOIN User AS U
ON  S.create_study_user_email = U.user_email
INNER JOIN study_user_list AS SUL
ON S.study_number = SUL.study_number AND S.create_study_user_email = SUL.study_number
INNER JOIN study_todolist AS ST
ON S.study_number = ST.study_number
;

-- 할일  목록의 스터디 방번호가 유저리스트의 방번호가 일치한  유저

-- -- -- -- -- --study_user_list&&  study_todolist && study -- -- -- -- -- -- 

SELECT 
	ST.study_list_number, 
    SUL.study_number,
    ST.study_list_content,
    ST.study_list_check
FROM study_user_list AS  SUL
INNER JOIN User AS U
ON U.user_email = SUL.user_email
INNER JOIN study_todolist AS ST
ON	SUL.study_number = ST.study_number
WHERE ST.study_number = 1
;

INSERT INTO study_todolist (study_list_number, study_number, study_list_content, study_list_check)
						VALUES(1,1,"sdfsdfsdfsdf",true);

SELECT 

    U.user_email AS userEmail,
    U.user_profile_image_url AS profileImage,
    SUL.study_grade AS studyGrade,
    SMC.study_material_comment_content AS studyMaterialCommetContent
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN(
    SELECT study_material_comment_content, user_email
    FROM study_material_comment AS SMC
    INNER JOIN study_material AS SM
    ON SMC.study_material_number = SM.study_material_number
) AS SMC
ON U.user_email = SMC.user_email
;

-- user && study_user_list == study_material_comment_content &&  study_material

SELECT 
	SMC.
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade,
    SMC.study_material_comment_content AS comment
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN(
    SELECT study_material_comment_content, user_email,SMC.study_material_comment_number
    FROM study_material_comment AS SMC
) AS SMC
ON U.user_email = SMC.user_email

;

-- user && study_user_list

CREATE VIEW study_user_view AS
SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    U.user_nickname AS user_nickname,
    SUL.study_grade AS study_grade
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
;



-- user && study_user_list && user_attendance_information -- -- -- -- -- 
-- 유저 등급, 유저 프로필 이미지,유저 닉네임, 스터디 방번호


SELECT 
	UAI.study_number AS study_number,
    U.user_profile_image_url AS profile_image,
    U.user_nickname AS user_nickname,
    SUL.study_grade AS study_grade,
    UAI.owner_attendance_start,
    UAI.user_attendance_check
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN user_attendance_information AS UAI 
ON U.user_email = UAI.user_email;

SELECT 
	UAI.study_number AS study_number,
	SUL.study_grade AS study_grade, 
	U.user_profile_image_url AS user_profile_image,
	U.user_nickname AS nickname
FROM user_attendance_information AS UAI
INNER JOIN user AS  U
ON UAI.user_email = U.user_email
INNER JOIN study_user_list AS SUL
ON UAI.user_email = SUL.user_email
;


-- user && study_user_list && study_chat -- -- -- -- -- 

SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    U.user_nickname AS user_nickname,
    SUL.study_grade AS study_grade,
    SC.study_chat_content
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN study_chat AS SC
ON U.user_email = SC.user_email
;


-- user && study_user_list && user_attendance_information -- -- -- -- -- 

-- 유저 등급, 유저 프로필 이미지,유저 닉네임, 스터디 방번호

SELECT 
	UAI.study_number AS study_number,
	SUL.study_grade AS study_grade, 
	U.user_profile_image_url AS user_profile_image,
	U.user_nickname AS nickname
FROM user_attendance_information AS UAI
INNER JOIN user AS  U
ON UAI.user_email = U.user_email
INNER JOIN study_user_list AS SUL
ON UAI.user_email = SUL.user_email
;


SELECT 
	SM.study_material_number AS studyMaterialName, 
	SUL.study_number AS studyNumber,
    SM.study_material_name AS studyMaterialName,
    SM.study_material_image_url AS studyMaterialImageUrl,
    SM.study_material_writer AS studyMaterialWriter,
    SM.study_material_datetime AS studyMaterialMaterialDatetime
FROM study_user_list AS  SUL
INNER JOIN User AS U
ON U.user_email = SUL.user_email
INNER JOIN study_material AS SM
ON	SUL.study_number = SM.study_number
WHERE SM.study_number = 1 
;

-- email : email1@email.com
-- token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlbWFpbDFAZW1haWwuY29tIiwiaWF0IjoxNTE2MjM5MDIyfQ.Y33ipiDkVYaCLSS0JMc666LsdbwgjF5AxF4a6xTnJ_E

-- email : email2@email.com
-- token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlbWFpbDJAZW1haWwuY29tIiwiaWF0IjoxNTE2MjM5MDIyfQ.yyF0O6I6dkLwcqtPA0FPFEFs6U8g0gCrMQUaCORCERg
