package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;
import com.godlife.godlifeback.entity.primaryKey.UserAttendanceInformationListPk;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

@Repository
public interface UserAttendanceInformationRepository extends JpaRepository<UserAttendanceInformationEntity,UserAttendanceInformationListPk>{
    
    @Query(
        value = 
        "SELECT " + 
            "UAI.study_number AS study_number, " +
            "UAI.user_email AS user_email    " +
            "SUL.study_grade AS study_grade, " +
            "U.user_profile_image_url AS user_profile_image, " +
            "U.user_nickname AS nickname " +
        "FROM user_attendance_information AS UAI " +
        "INNER JOIN user AS  U   " +
        "ON UAI.user_email = U.user_email    " +
        "INNER JOIN study_user_list AS SUL   " +
        "ON UAI.user_email = SUL.user_email ",
        nativeQuery =  true
    )
    boolean existsByUserEmailAndStudyNumber(Integer studyNumber,String userEmail );
    
    
    List<UserAttendanceInformationResultset> findByStudyAttenanceInformationList(Integer studyNumber,String userEmail);
}
