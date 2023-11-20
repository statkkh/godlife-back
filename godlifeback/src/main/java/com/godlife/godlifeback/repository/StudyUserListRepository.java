package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.entity.primaryKey.StudyUserListPK;


@Repository
public interface StudyUserListRepository extends JpaRepository<StudyUserListEntity,StudyUserListPK>{
    
    boolean existByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);
    
    List<StudyUserListEntity> findByStudyNumber(Integer studyNumber);


}
