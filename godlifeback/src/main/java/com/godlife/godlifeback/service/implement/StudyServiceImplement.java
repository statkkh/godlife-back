package com.godlife.godlifeback.service.implement;

import com.godlife.godlifeback.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseDto;

import com.godlife.godlifeback.dto.response.study.GetAttendanceInformationResponseDto;
import com.godlife.godlifeback.dto.response.study.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetToDoListResponseDto;

import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyResponseDto;
import com.godlife.godlifeback.dto.response.user.GetUserResponseDto;
import com.godlife.godlifeback.dto.response.user.PostUserResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;

import com.godlife.godlifeback.dto.response.study.DeleteNoticeListResponseDto;

import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.entity.StudyToDoListEntity;
import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;
import com.godlife.godlifeback.entity.UserEntity;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.repository.StudyRepository;
// import com.godlife.godlifeback.repository.StudyToDoListRespository;
// import com.godlife.godlifeback.repository.StudyUserListRepository;
// import com.godlife.godlifeback.repository.UserAttendanceInformationRepository;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;
    
    // private final StudyToDoListRespository studyToDolistRepository;
    
    // private final UserAttendanceInformationRepository userAttendanceInformationRepository;
    // private final StudyUserListRepository studyUserListRepository;

    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetNoticeListResponseDto> getNotice( Integer studyNumber, String userEmail) {

        // List<StudyNoticeEntity> studyNoticeEntities  = new ArrayList<>();
        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();
// 
        try {
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetNoticeListResponseDto.notExistUser();

            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetNoticeListResponseDto.notExistStudy();

            // 유저이메일이 유저 리스트에 포함되어 있는지 확인 절차필요 여부
            // boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber( userEmail, studyNumber);
            // if(!existedUserList) return GetStudyUserListResponseDto.notUserList();            
            // studyNoticeEntities = studyNoticeRepository.findByStudyNumber(studyNumber);
            resultSets = studyNoticeRepository.findByNoticeList(studyNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNoticeListResponseDto.success(resultSets);
    }

    
    @Override
    public ResponseEntity<? super GetToDoListResponseDto> getToDoList(Integer studyToDoListNumber,   Integer studyNumber) {
        
        List<StudyToDoListEntity> studyToDoListEntities  = new ArrayList<>();

        try {
            
            boolean existedStudy =   studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyResponseDto.notExistStudy();

            // boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber( userEmail, studyNumber);
            // if(!existedUserList) return GetStudyUserListResponseDto.notUserList();   
            
            // studyToDoListEntities = StudyToDoListRespository.findByStudyListNumber();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToDoListResponseDto.success(null);
    }

    @Override
    public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail) {
        
        List<StudyUserListEntity> studyUserListEntities = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetUserResponseDto.notExistsUser();

            boolean existedStudy =   studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyResponseDto.notExistStudy();


            // studyUserListEntities = studyUserListRepository.findByStudyUserList(studyNumber, userEmail);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetStudyUserListResponseDto.success(studyUserListEntities);
    }

    @Override
    public ResponseEntity<? super GetAttendanceInformationResponseDto> getUserAttendanceInformationList(String userEmail, Integer studyNumber) {
        
        List<UserAttendanceInformationResultset> attendanceResultsets = new ArrayList<>();

        try {
      
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return GetUserResponseDto.notExistsUser();

            boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyResponseDto.notExistStudy();

            // boolean existedAttendInformation = userAttendanceInformationRepository.existsByUserEmailAndStudyNumber(userEmail,studyNumber );
            // if(!existedAttendInformation) return GetAttendanceInformationResponseDto.notExistUserAttendanceInformation();

            // attendanceResultsets = userAttendanceInformationRepository.findByStudyAttenanceInformationList(userEmail, studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAttendanceInformationResponseDto.success(attendanceResultsets);
    }
        
    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer studyNumber, String createUserEmail) {

        try {

            boolean existedUser = userRepository.existsByUserEmail(createUserEmail);
            if(!existedUser) return PostNoticeResponseDto.notExistsUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistsStudy();

            //  TODO :유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createUserEmail);
            if(!equalCreater) return PostNoticeResponseDto.mistMatchLeaderEmail();

            StudyNoticeEntity studyNoticeEntity = new StudyNoticeEntity(dto, studyNumber, createUserEmail);
            studyNoticeRepository.save(studyNoticeEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer studyNumber, String createUserEmail) {
        
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createUserEmail);
            if(!existedUser) return PatchNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PatchNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createUserEmail);
            if(!equalCreater) return PatchNoticeResponseDto.misMatchLeaderEmail();            



        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteNoticeListResponseDto> deleteNotice(Integer studyNumber, String createUserEmail) {
        
        try {

         
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteNoticeListResponseDto.success();

    }







}
