package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyNoticeEntity;
import java.util.List;


@Repository
public interface StudyNoticeRepository extends JpaRepository<StudyNoticeEntity, Integer>{

    // boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);

    StudyNoticeEntity findByStudyNoticeNumber(Integer studyNoticeNumber);

    List<StudyNoticeEntity> findByStudyNumber(Integer studyNumber);

}
