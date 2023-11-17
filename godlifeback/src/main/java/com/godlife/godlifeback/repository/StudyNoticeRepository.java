package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyNoticeListEntity;
import java.util.List;


@Repository
public interface StudyNoticeRepository extends JpaRepository<StudyNoticeListEntity, Integer>{


    StudyNoticeListEntity findByNoticeNumber(Integer noticeNumber);

    List<StudyNoticeListEntity> findByStudyNoticeNumber(Integer studyNoticeNumber);

    
}
