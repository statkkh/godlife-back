package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;

import java.util.List;


@Repository
public interface StudyNoticeRepository extends JpaRepository<StudyNoticeEntity, Integer>{

    // boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);

    // -- 공지사항의 스터디 방번호가 유저리스트의 방번호가 일치한  유저
    @Query(
        value =
        "SELECT " +
            "SN.study_notice_number AS studyNoticeNumber, " +
            "SUL.study_number AS studyNumber, " +
            "SN.study_notice_content AS studyNoticeContent " +
        "FROM study_user_list AS SUL "+    
        "INNER JOIN user AS U " +
        "ON U.user_email = SUL.user_email " +
        "INNER JOIN study_notice AS SN " +
        "ON SUL.study_number = SN.study_number " +
        "WHERE SN.study_number = ?1 ",
        nativeQuery = true
    )
    List<StudyNoticeListResultSet> findByNoticeList(Integer studyNumber);

    StudyNoticeEntity findByStudyNoticeNumber(Integer studyNoticeNumber);    

}
