package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.godlifeback.entity.StudyEntity;

public interface StudyRepository extends JpaRepository<StudyEntity, Integer>{
    
    boolean existsByStudyNumber(Integer studyNumber);

    StudyEntity findByStudyNumber(Integer studyNumber);

    StudyEntity findByCreateStudyUserEmail(String createStudyUserEmail);
}
