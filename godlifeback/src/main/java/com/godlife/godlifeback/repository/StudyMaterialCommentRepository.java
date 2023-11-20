package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;
import com.godlife.godlifeback.repository.resultSet.StudyCommentListResultSet;

@Repository
public interface StudyMaterialCommentRepository extends JpaRepository<StudyMaterialCommentEntity, Integer>{
    

    List<StudyMaterialCommentEntity> findByStudyMaterialCommentNumber(Integer studyMaterialCommentNumber);

    List<StudyCommentListResultSet> findByCommentList(Integer studyNumber);

}
