package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.repository.resultSet.StudyUserAttendanceListResultset;

@Repository
public interface StudyUserListRepository extends JpaRepository<StudyUserListEntity,Integer>{
    

    List<StudyUserListEntity> findByStudyNumber(Integer studyNumber);


}
