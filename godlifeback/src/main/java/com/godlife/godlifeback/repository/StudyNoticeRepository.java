package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyNoticeEntity;
import java.util.List;


@Repository
public interface StudyNoticeRepository extends JpaRepository<StudyNoticeEntity, Integer>{

    // boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);

    // 공지사항의 스터디 방번호가 유저리스트의 방번호가 일치한   스터디 방 생성자인 유저
    // SELECT S.study_number,SN.study_notice_number,SN.study_notice_content
    // FROM study AS S
    // INNER JOIN User AS U
    // ON  S.create_study_user_email = U.user_email
    // INNER JOIN study_user_list AS SUL
    // ON S.study_number = SUL.study_number AND S.create_study_user_email = SUL.study_number
    // INNER JOIN study_notice AS SN
    // ON S.study_number = SN.study_number
    // ;


    // -- 공지사항의 스터디 방번호가 유저리스트의 방번호가 일치한  유저
    // SELECT SN.study_notice_number, SUL.study_number,SN.study_notice_content
    // FROM study_user_list AS  SUL
    // INNER JOIN User AS U
    // ON U.user_email = SUL.user_email
    // INNER JOIN study_notice AS SN
    // ON	SUL.study_number = SN.study_number
    // ;

        

    StudyNoticeEntity findByStudyNoticeNumber(Integer studyNoticeNumber);

    List<StudyNoticeEntity> findByStudyNumber(Integer studyNumber);

    boolean existsByStudyNoticeNumber(Integer studyNoticeNumber);

}
