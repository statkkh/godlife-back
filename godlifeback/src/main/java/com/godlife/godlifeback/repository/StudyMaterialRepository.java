package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.godlifeback.entity.StudyMaterialEntity;

public interface StudyMaterialRepository extends JpaRepository<StudyMaterialEntity, Integer>{

    // StudyMaterialEntity findByStudyMaterialNumber(Integer studyMaterilNumber);
    
    List<StudyMaterialEntity> findByStudyMaterialNumber(Integer studyMaterialNumber);
} 