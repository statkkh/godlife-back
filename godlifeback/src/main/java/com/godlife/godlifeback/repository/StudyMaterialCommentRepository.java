package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;
import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;

@Repository
public interface StudyMaterialCommentRepository extends JpaRepository<StudyMaterialCommentEntity, Integer>{


    // @Query(
    //     value =
    //     "SELECT " + 
    //     "U.user_email AS user_email, "+
    //     "U.user_profile_image_url AS profile_image,  "+
    //     "SUL.study_grade AS study_grade, " +  
    //     "SMC.study_material_comment_content AS comment "+
    //     "FROM user AS U  " +
    //     "INNER JOIN study_user_list AS SUL   "+
    //     "ON U.user_email = SUL.user_email    "+
    //     "INNER JOIN study AS S   " +
    //     "ON U.user_email = S.create_study_user_email; "   
    // )

    // SELECT *
    // FROM study AS S
    // INNER JOIN study_material AS SM
    // ON S.study_number = SM.study_number
    // INNER JOIN study_material_comment AS SMC
    // ON  SM.study_material_number = SMC.study_material_number;
        
    boolean existsByStudyMaterialNumber(Integer StudyMaterialNumber);

    List<StudyMaterialCommentEntity> findByStudyMaterialCommentNumber(Integer studyMaterialCommentNumber);

    // List<StudyCommentListResultSet> findByCommentList(Integer studyNumber);

}
