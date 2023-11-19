USE sample_board_1;

CREATE TABLE `study_notice` (
	`study_notice_number`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`study_number`	INT	NOT NULL,
	`study_notice_content`	VARCHAR(255)	NULL
);


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


