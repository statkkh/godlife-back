package com.godlife.godlifeback.service.implement;

import com.godlife.godlifeback.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseDto;

import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchMaterialResponseDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostToDoListRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostToDoListResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchMaterialRequestDto;
import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteToDolistResponseDto;
import com.godlife.godlifeback.dto.response.study.GetAttendanceInformationResponseDto;
import com.godlife.godlifeback.dto.response.study.GetMaterialResponseDto;
import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;
import com.godlife.godlifeback.entity.StudyMaterialEntity;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.entity.StudyTodolistEntity;
import com.godlife.godlifeback.repository.StudyMaterialRepository;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.repository.StudyToDoListRespository;
import com.godlife.godlifeback.repository.StudyMaterialCommentRepository;
// import com.godlife.godlifeback.repository.UserAttendanceInformationRepository;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;
    private final StudyToDoListRespository studyToDoListRespository;

    private final StudyMaterialRepository studyMaterialRepository;
    private final StudyMaterialCommentRepository studyMaterialCommentRepository;

    private final StudyRepository studyRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(Integer studyNumber, String userEmail) {

        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();

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
    public ResponseEntity<? super PostToDoListResponseDto> postTodo(PostToDoListRequestDto dto, Integer studyNumber, String createStudyUserEmail) {

        try {

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistsStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostNoticeResponseDto.mistMatchLeaderEmail();
            
            StudyTodolistEntity studyTodolistEntity = new StudyTodolistEntity(dto , studyNumber);
            studyToDoListRespository.save(studyTodolistEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostToDoListResponseDto.success();
    }


    @Override
    public ResponseEntity<? super GetToDoListResponseDto> getTodolist(Integer studyNumber, String userEmail) {

        List<StudyToDoListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) GetToDoListResponseDto.notExistsUser();

            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetToDoListResponseDto.notExistStudy();

            resultSets = studyToDoListRespository.findByStudyNumber(studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToDoListResponseDto.success(resultSets);
    }    


    @Override
    public ResponseEntity<? super PatchToDoListResponseDto> patchTodo(PatchToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyListNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return PatchToDoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return PatchToDoListResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchToDoListResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return PatchToDoListResponseDto.notExistTodolist();

            studyTodolistEntity.patchTodoList(dto);
            studyToDoListRespository.save(studyTodolistEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchToDoListResponseDto.success();
    }    

    @Override
    public ResponseEntity<? super DeleteToDolistResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber,  Integer studyListNumber) {

        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  DeleteToDolistResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return DeleteToDolistResponseDto.notExistStudy();
            
            // studyRepository.d
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteToDolistResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return DeleteToDolistResponseDto.notExistToDoList();


            studyToDoListRespository.delete(studyTodolistEntity);
 
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteToDolistResponseDto.success();
    }


    @Override
    public ResponseEntity<? super GetMaterialResponseDto> getMaterialList(Integer studyNumber, String userEmail) {
        
        List<StudyMaterialListResultSet> resultSets = new ArrayList<>();

        System.out.println(userEmail);

        try {

            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return GetMaterialResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return GetMaterialResponseDto.notExistStudy();    
            
            resultSets = studyMaterialRepository.findByMaterialList(studyNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMaterialResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PostMaterialResponseDto> postMaterial(PostMaterialRequestDto dto, Integer studyNumber, String createStudyUserEmail) {
        
        try {
            
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistsStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostMaterialResponseDto.noPermission();
            
            StudyMaterialEntity studyMaterialEntity = new StudyMaterialEntity(dto, studyNumber);
            studyMaterialRepository.save(studyMaterialEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostMaterialResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchMaterialResponseDto> patchMaterial(PatchMaterialRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyMaterialNumber) {

        try {
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  PatchMaterialResponseDto.notExistUser();            
 
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PatchMaterialResponseDto.notExistStudy();

            StudyMaterialEntity studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);
            if(studyMaterialEntity == null) return PatchMaterialResponseDto.notExistMaterial();

            studyMaterialEntity.patchMaterial(dto);
            studyMaterialRepository.save(studyMaterialEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return   PatchMaterialResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteMaterialResponseDto> deleteMaterial(String createStudyUserEmail, Integer studyNumber,Integer studyMaterialNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  DeleteToDolistResponseDto.notExistUser();            
 
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return DeleteMaterialResponseDto.notExistStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteMaterialResponseDto.noPermission();            
    
            StudyMaterialEntity studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);
            if(studyMaterialEntity == null) return DeleteMaterialResponseDto.notExistMaterial();

            studyMaterialRepository.delete(studyMaterialEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteMaterialResponseDto.success();        
    }    

    @Override
    public ResponseEntity<? super PostMaterialCommentResponseDto> postMaterialComment(PostMaterialCommentRequestDto dto, Integer studyNumber ,String commentUserEmail ,String userEmail) {
        
        try {
            
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return PostMaterialCommentResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return PostMaterialCommentResponseDto.notExistUser();     
            
            StudyMaterialCommentEntity studyMaterialCommentEntity = new StudyMaterialCommentEntity(dto,commentUserEmail, studyNumber);
            studyMaterialCommentRepository.save(studyMaterialCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostMaterialCommentResponseDto.success();
    }


    @Override
    public ResponseEntity<? super GetAttendanceInformationResponseDto> getAttendanceInformation(Integer studyNumber,String userEmail) {

        List<UserAttendanceInformationResultset> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return GetAttendanceInformationResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return GetAttendanceInformationResponseDto.notExistUser();


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAttendanceInformationResponseDto.success(resultSets);
    }



}
