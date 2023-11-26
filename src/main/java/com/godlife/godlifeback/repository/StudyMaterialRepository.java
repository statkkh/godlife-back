package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyMaterialEntity;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;

@Repository
public interface StudyMaterialRepository extends JpaRepository<StudyMaterialEntity ,Integer>{


    @Query(
        value = 
        "SELECT " +
            "SM.study_material_number AS studyMaterialNumber, "+
            "SM.study_number AS studyNumber, " +
            "SM.study_material_name AS studyMaterialName, " +
            "SM.study_material_image_url AS studyMaterialImageUrl, "+
            "SM.study_material_writer AS studyMaterialWriter, "+
            "SM.study_material_datetime AS studyMaterialMaterialDatetime "+
        "FROM study_user_list AS  SUL "+
        "INNER JOIN User AS U "+
        "ON U.user_email = SUL.user_email "+
        "INNER JOIN study_material AS SM " + 
        "ON SUL.study_number = SM.study_number "+
        "WHERE SM.study_number = ?1 ",
        nativeQuery = true
    )
    List<StudyMaterialListResultSet> findByMaterialList(Integer studyNumber);    

    StudyMaterialEntity findByStudyMaterialNumber(Integer studyMaterialNumber);
    
}
