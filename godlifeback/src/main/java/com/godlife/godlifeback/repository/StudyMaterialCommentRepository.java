package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;

public interface StudyMaterialCommentRepository extends JpaRepository<StudyMaterialCommentEntity, Integer>{
    

    List<StudyMaterialCommentEntity> findByStudyMaterialCommentNumber(Integer studyMaterialCommentNumber);

}
