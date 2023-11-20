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

import com.godlife.godlifeback.dto.request.study.PostNoticeListRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyResponseDto;
import com.godlife.godlifeback.dto.response.user.PostUserResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchNoticeListRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;

import com.godlife.godlifeback.dto.response.study.DeleteNoticeListResponseDto;

import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.entity.StudyToDoListEntity;
import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.entity.UserAttendanceInformationEntity;

import com.godlife.godlifeback.repository.StudyMaterialCommentRepository;
import com.godlife.godlifeback.repository.StudyMaterialRepository;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.repository.StudyToDoListRespository;
import com.godlife.godlifeback.repository.StudyUserListRepository;
import com.godlife.godlifeback.repository.UserAttendanceInformationRepository;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;
    private final StudyToDoListRespository studyToDolistRepository;
    
    private final UserAttendanceInformationRepository userAttendanceInformationRepository;
    private final StudyUserListRepository studyUserListRepository;
    
    private final StudyMaterialCommentRepository studyMaterialCommentRepository;
    private final StudyMaterialRepository studyMaterialRepository;

    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetNoticeListResponseDto> getNotice(Integer studyNoticeNumber) {

        List<StudyNoticeEntity> studyNoticeEntities  = new ArrayList<>();

        try {

            studyNoticeEntities = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntities == null) return GetNoticeListResponseDto.notExistNotice();


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNoticeListResponseDto.success(studyNoticeEntities);
    }

    
    @Override
    public ResponseEntity<? super GetToDoListResponseDto> getToDoList(Integer studyToDoListNumber) {
        
        List<StudyToDoListEntity> studyToDoListEntities  = new ArrayList<>();

        try {
            


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToDoListResponseDto.success(studyToDoListEntities);
    }


    @Override
    public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail) {
        
        List<StudyUserListEntity> studyUserListEntities = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(userEmail);
            if(!existedUser ) return PostUserResponseDto.notExistsUser();

            boolean existedStudy =   studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return PostStudyResponseDto.notExistStudy();

            boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber(studyNumber, userEmail);
            if(!existedUserList) return GetStudyUserListResponseDto.notUserList();

            studyUserListEntities = studyUserListRepository.findByStudyUserList(studyNumber, userEmail);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetStudyUserListResponseDto.success(studyUserListEntities);
    }

    @Override
    public ResponseEntity<? super GetAttendanceInformationResponseDto> getUserAttendanceInformationList(Integer studyNumber,String userEmail) {
        
        List<UserAttendanceInformationResultset> attendanceResultsets = new ArrayList<>();

        try {
      
            boolean existedUser = userRepository.existsByEmail(userEmail);
            if(!existedUser) return PostUserResponseDto.notExistsUser();

            boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return PostStudyResponseDto.notExistStudy();

            boolean  existedAttendInformation = userAttendanceInformationRepository.existsByUserEmailAndStudyNumber(studyNumber, userEmail);
            if(!existedAttendInformation) return GetAttendanceInformationResponseDto.notExistUserAttendanceInformation();

            attendanceResultsets = userAttendanceInformationRepository.findByStudyAttenanceInformationList(studyNumber, userEmail);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAttendanceInformationResponseDto.success(attendanceResultsets);
    }
        
    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeListRequestDto dto, Integer studyNoticeNumber) {


        try {
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return PostNoticeResponseDto.notExistNotice();
            
            studyNoticeRepository.save(studyNoticeEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeListRequestDto dto, Integer studyNoticeNumber) {
        
        List<StudyNoticeEntity> studyNoticeEntities  = new ArrayList<>();

        try {

            studyNoticeEntities = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntities == null) return PatchNoticeResponseDto.notExistNotice();

            ((StudyNoticeEntity) studyNoticeEntities).patchNotice(dto);
            studyNoticeRepository.saveAll(studyNoticeEntities);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchNoticeResponseDto.success(studyNoticeEntities);
    }

    @Override
    public ResponseEntity<? super DeleteNoticeListResponseDto> deleteNotice(Integer studyNoticeNumber) {
        
        try {

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return DeleteNoticeListResponseDto.notExistNotice();    
            
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteNoticeListResponseDto.success();

    }







}
