package com.godlife.godlifeback.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;
import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;

@Repository
public interface StudyMaterialCommentRepository extends JpaRepository<StudyMaterialCommentEntity,Integer>{
    
    @Query(
        value =
        "SELECT " +
            "SMC.study_material_comment_number AS studyMaterialNumber, "+
            "SMC.study_material_number AS studyMaterialNumber, " + 
            "SUL.user_email AS userEmail, "+
            "U.user_profile_image_url AS userProfileImageUrl, " +
            "SUL.study_grade AS studyGrade, " +
            "U.user_nickname AS userNickName, " +
            "SMC.study_material_comment_content AS studyMaterialComment " +
        "FROM user AS U " +
        "INNER JOIN study_user_list AS SUL " +
        "ON U.user_email = SUL.user_email " +
        "INNER JOIN study_material_comment AS  SMC " +
        "ON U.user_email = SMC.user_email "+
        "WHERE SMC.study_material_number = ?1 ",
        nativeQuery = true
    )
    List<StudyCommentListResultSet> findByMaterialList(Integer studyNumber);

    StudyMaterialCommentEntity findByStudyMaterialCommentNumber(Integer studyMaterialCommentNumber);
      
}