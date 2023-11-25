package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.godlife.godlifeback.entity.StudyTodolistEntity;
import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;

@Repository
public interface StudyToDoListRespository extends JpaRepository<StudyTodolistEntity, Integer>{
    
    // boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);
    
    @Query(
        value = 
        "SELECT " +
            "ST.study_list_number AS studyListNumber, "+   
            "SUL.study_number AS studyNumber, " +
            "ST.study_list_content AS studyListContent, "+
            "ST.study_list_check AS studyListCheck "+
        "FROM study_user_list AS  SUL "+
        "INNER JOIN User AS U "+
        "ON U.user_email = SUL.user_email "+
        "INNER JOIN study_todolist AS ST "+
        "ON SUL.study_number = ST.study_number "+
        "WHERE ST.study_number = ?1 ",
        nativeQuery = true    
    )
    List<StudyToDoListResultSet> findByStudyNumber(Integer studyNumber);

    StudyTodolistEntity findByStudyListNumber(Integer studyListNumber);
}   

