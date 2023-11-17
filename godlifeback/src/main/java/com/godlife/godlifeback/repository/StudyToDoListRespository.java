package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.godlife.godlifeback.entity.StudyToDoListEntity;

@Repository
public interface StudyToDoListRespository extends JpaRepository<StudyToDoListEntity, Integer>{

    StudyToDoListEntity findByStudyListNumber(Integer studyToDoListNumber);

    List<StudyToDoListEntity> findByStudyNumber(Integer studyNumber);

}

