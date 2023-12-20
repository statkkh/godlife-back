USE sample_board_1;

CREATE DATABASE godlife_study;

CREATE TABLE `study_notice` (
	`study_notice_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_number`	INT	NOT NULL,
	`study_notice_content`	VARCHAR(255)	NULL
);


-- 등급이 방장인 사람을 정보를 가지고 있는 코멘트  

SELECT 
	SMC.study_material_comment_number AS studyMaterialNumber,
    SMC.study_material_number AS studyMaterialNumber,
    SUL.user_email AS userEmail,
    U.user_profile_image_url AS userProfileImageUrl,
    SUL.study_grade AS studyGrade,
    U.user_nickname AS userNickName,
    SMC.study_material_comment_content AS studyMaterialComment
FROM user AS U
INNER JOIN study_user_list AS SUL
ON U.user_email = SUL.user_email
INNER JOIN study_material_comment AS  SMC
ON U.user_email = SMC.user_email
;


