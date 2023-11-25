package com.godlife.godlifeback.service.implement;

import com.godlife.godlifeback.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseDto;

import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;

import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;

import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyMaterialEntity;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.repository.StudyMaterialRepository;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.repository.StudyRepository;
// import com.godlife.godlifeback.repository.StudyToDoListRespository;
// import com.godlife.godlifeback.repository.StudyUserListRepository;
// import com.godlife.godlifeback.repository.UserAttendanceInformationRepository;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;

    private final StudyMaterialRepository studyMaterialRepository;

    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice( Integer studyNumber, String userEmail) {

        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();

        System.out.println(userEmail);

        try {
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetStudyNoticeListResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyNoticeListResponseDto.notExistStudy();

            resultSets = studyNoticeRepository.findByNoticeList(studyNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetStudyNoticeListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer studyNumber, String createStudyUserEmail) {

        try {

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistsStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostNoticeResponseDto.mistMatchLeaderEmail();

            StudyNoticeEntity studyNoticeEntity = new StudyNoticeEntity(dto, studyNumber);
            studyNoticeRepository.save(studyNoticeEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return PatchNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PatchNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchNoticeResponseDto.misMatchLeaderEmail();           
            
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return PatchNoticeResponseDto.notExistNotice();
            
            studyNoticeEntity.patchNotice(dto);
            studyNoticeRepository.save(studyNoticeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer studyNumber, String createStudyUserEmail ,Integer studyNoticeNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return PatchNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PatchNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchNoticeResponseDto.misMatchLeaderEmail();    
            
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return PatchNoticeResponseDto.notExistNotice();
            
            studyNoticeRepository.delete(studyNoticeEntity);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteNoticeResponseDto.success();

    }

    @Override
    public ResponseEntity<? super PostMaterialResponseDto> postMaterial(PostMaterialRequestDto dto, Integer studyNumber, String createStudyUserEmail, String studyMaterialImageUrl) {
        
        try {
            
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistsStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostNoticeResponseDto.mistMatchLeaderEmail();
            
            StudyMaterialEntity studyMaterialEntity = new StudyMaterialEntity(dto, studyNumber, studyMaterialImageUrl);
            studyMaterialRepository.save(studyMaterialEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostMaterialResponseDto.success();
    }












}
