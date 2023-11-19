-- 등급이 방장인 사람을 정보를 가지고 있는 코멘트  

SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade,
    SMC.study_material_comment_content AS comment
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN(
    SELECT study_material_comment_content, user_email
    FROM study_material_comment
) AS SMC
ON U.user_email = SMC.user_email
WHERE SUL.study_grade = '방장'
;

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


-- 유저등급이 방장인 사람의 
SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    SUL.study_grade
FROM study AS S 
INNER JOIN study_user_list AS SUL
ON S.create_study_user_email = SUL.user_email;


SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    SUL.study_grade AS study_grade,
    SN.study_notice_content AS notice_content
FROM study AS S 
INNER JOIN study_user_list AS SUL
ON S.create_study_user_email = SUL.user_email
INNER JOIN study_notice AS SN
ON S.study_number = SN.study_number
;

SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    SN.study_notice_content AS notice_content
FROM study AS S 
INNER JOIN study_notice AS SN
ON S.study_number = SN.study_number
;

SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    SUL.study_grade AS study_grade,
    ST.study_list_content AS notice_content
FROM study AS S 
INNER JOIN study_user_list AS SUL
ON S.create_study_user_email = SUL.user_email
INNER JOIN study_todolist AS ST
ON S.study_number = ST.study_number
;

SELECT 
    S.study_number AS studyNumber,  
    S.create_study_user_email AS email, 
    ST.study_list_content AS notice_content
FROM study AS S 
INNER JOIN study_todolist AS ST
ON S.study_number = ST.study_number
;


SELECT 
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade,
    SMC.study_material_comment_content AS comment
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
    U.user_email AS user_email,
    U.user_profile_image_url AS profile_image,
    SUL.study_grade AS study_grade,
    SMC.study_material_comment_content AS comment
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



SELECT 
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

SELECT * FROM study_user_list;
SELECT * FROM study_chat;

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


