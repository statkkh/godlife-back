CREATE TABLE `study_user_list` (
	`study_number`	INT	NOT NULL,
	`user_email`	VARCHAR(50)	NOT NULL,
	`study_grade`	VARCHAR(255)	NOT NULL
);

CREATE TABLE study_material_comment (
	study_material_comment_number	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	study_material_number	INT	NOT NULL,
	user_email	VARCHAR(50)	NOT NULL,
	study_material_comment_content	VARCHAR(255)	NULL,
	study_material_comment_datetime	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (study_material_number)  REFERENCES study_material (study_material_number)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);



DROP TABLE study_material_comment;
