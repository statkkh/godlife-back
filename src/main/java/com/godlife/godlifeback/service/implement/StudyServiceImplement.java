package com.godlife.godlifeback.service.implement;

import com.godlife.godlifeback.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseDto;
      
                             
import com.godlife.godlifeback.dto.request.studyService.notice.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.notice.PatchNoticeRequestDto;

import com.godlife.godlifeback.dto.response.studyService.notice.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.DeleteNoticeResponseDto;

import com.godlife.godlifeback.dto.request.studyService.todo.PostToDoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchToDoListRequestDto;

import com.godlife.godlifeback.dto.response.studyService.todo.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PostToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.DeleteToDolistResponseDto;

import com.godlife.godlifeback.dto.request.studyService.materialPostMaterialRequestDto;
import com.godlife.godlifeback.dto.request.studyService.material.PatchMaterialRequestDto;

import com.godlife.godlifeback.dto.response.studyService.material.GetMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.PatchMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.DeleteMaterialResponseDto;

import com.godlife.godlifeback.dto.request.studyService.materialComment.PostMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.request.studyService.materialComment.PatchMaterialCommentReqeuestDto;


import com.godlife.godlifeback.dto.response.studyService.materialCommentGetStudyMaterialCommentListResponseDto;
import com.godlife.godlifeback.dto.request.studyService.materialCommentPatchStudyMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.PostStudyMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.DeleteStudyMaterialCommentResponseDto;


import com.godlife.godlifeback.dto.request.studyService.notice.PostStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.notice.PatchStudyNoticeRequestDto;

import com.godlife.godlifeback.dto.response.studyService.notice.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.PostStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.PatchStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.notice.DeleteStudyNoticeResponseDto;


import com.godlife.godlifeback.dto.request.studyService.todo.PostStudyTodoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyTodoListRequestDto;

import com.godlife.godlifeback.dto.response.studyService.todo.GetStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PostStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.PatchStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.todo.DeleteStudyTodoListResponseDto;

import com.godlife.godlifeback.dto.request.studyService.material.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.request.studyService.material.PatchMaterialRequestDto;

import com.godlife.godlifeback.dto.response.studyService.material.PostStudyMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.GetStudyMaterialListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.DeleteStudyMaterialResponseDto;

import com.godlife.godlifeback.dto.request.studyService.PostStudyMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyMaterialCommentRequestDto;

import com.godlife.godlifeback.dto.response.studyService.GetStudyMaterialCommentListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyMaterialCommentResponseDto;


import com.godlife.godlifeback.dto.response.studyService.GetAttendanceInformationResponseDto;


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


import com.godlife.godlifeback.repository.UserRepository;

import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyMaterialCommentListResultSet;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{
    
    private final StudyNoticeRepository studyNoticeRepository;
    private final StudyToDoListRespository studyToDoListRespository;

    private final StudyMaterialRepository studyMaterialRepository;
    private final StudyMaterialCommentRepository studyMaterialCommentRepository;


    println final UserAttendanceInformationRepository userAttendanceInformationRepository

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
    public ResponseEntity<? super PatchStudyMaterialResponseDto> patchMaterial(PatchMaterialRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyMaterialNumber) {

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
    public ResponseEntity<? super DeleteStudyMaterialResponseDto> deleteMaterial(String createStudyUserEmail, Integer studyNumber,Integer studyMaterialNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  DeleteToDolistResponseDto.notExistUser();            
 
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return DeleteStudyMaterialResponseDto.notExistStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteStudyMaterialResponseDto.noPermission();            
    
            StudyMaterialEntity studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);
            if(studyMaterialEntity == null) return DeleteStudyMaterialResponseDto.notExistMaterial();

            studyMaterialRepository.delete(studyMaterialEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteMaterialResponseDto.success();        
    }    


    @Override
<<<<<<< HEAD
    public ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialCommentList(String userEmail,Integer studyNumber, Integer studyMaterialNumber) {

        List<StudyMaterialCommentListResultSet> resultSets = new ArrayList<>();

        try {
          boolean existedUser = userRepository.existsByUserEmail(userEmail);
          if(!existedUser) return  GetStudyMaterialCommentListResponseDto.notExistUser();


          StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
          if( studyEntity == null) return GetStudyMaterialCommentListResponseDto.notExistStudy();

          StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);
          if(studyMaterialEntity == null) return GetStudyMaterialCommentListResponseDto.notExistMaterial();

          resultSets = studyMaterialCommentRepository.findByMaterialCommentList(studyMaterialNumber);

        } catch(Exception exception){
          exception.printStackTrace();
          return ResponseDto.databaseError();  
        }

        return  GetStudyMaterialCommentListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super PostMaterialCommentResponseDto> postMaterialComment(PostMaterialCommentRequestDto dto, Integer studyNumber ,String commentUserEmail ,String userEmail) {
=======
    public ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialCommentList(String userEmail,Integer studyNumber, Integer studyMaterialNumber) {

        List<StudyMaterialCommentListResultSet> resultSets = new ArrayList<>();

        try {
          boolean existedUser = userRepository.existsByUserEmail(userEmail);
          if(!existedUser) return  GetStudyMaterialCommentListResponseDto.notExistUser();


          StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
          if( studyEntity == null) return GetStudyMaterialCommentListResponseDto.notExistStudy();

          StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);
          if(studyMaterialEntity == null) return GetStudyMaterialCommentListResponseDto.notExistMaterial();

          resultSets = studyMaterialCommentRepository.findByMaterialCommentList(studyMaterialNumber);

        } catch(Exception exception){
          exception.printStackTrace();
          return ResponseDto.databaseError();  
        }

        return  GetStudyMaterialCommentListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super PostStudyMaterialCommentResponseDto> postMaterialComment(PostMaterialCommentRequestDto dto, Integer studyNumber ,String commentUserEmail ,String userEmail) {
>>>>>>> 3bd9b62d4657b6b3faa6f1fb49de53da32dce1e2
        
        try {
            
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return PatchStudyMaterialCommentResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return PostStudyMaterialCommentResponseDto.notExistUser(); 
          
            StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);            
            if(studyMaterialEntity == null) return PostStudyMaterialCommentResponseDto.notExistMaterial();

            // 자료 코멘트 엔터티 저장
            StudyMaterialCommentEntity studyMaterialCommentEntity = new StudyMaterialCommentEntity(dto,userEmail, studyMaterialNumber);
            studyMaterialCommentRepository.save(studyMaterialCommentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostStudyMaterialCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(PatchStudyMaterialCommentRequestDto dto, String userEmail, Integer studyNumber, Integer studyMaterialNumber) {

      try {
            UserEntity  userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return PatchStudyMaterialCommentResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return PatchStudyMaterialCommentResponseDto.notExistUser(); 
          
            StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);            
            if(studyMaterialEntity == null) return PatchStudyMaterialCommentResponseDto.notExistMaterial();        

            StudyMaterialCommentEntity studyMaterialCommentEntity = studyMaterialCommentRepository.findByStudyMaterialCommentNumber(dto.getStudyMaterialCommentNumber());
            if(studyMaterialCommentEntity == null) return PatchStudyMaterialCommentResponseDto.notExistMaterialCommment();

            boolean equalWriter = studyMaterialCommentEntity.getUserEmail().equals(userEmail);
            if(!equalWriter) return PatchStudyMaterialCommentResponseDto.noPermision();

            
            studyMaterialCommentEntity.patchMaterialComment(dto);
            studyMaterialCommentRepository.save(studyMaterialCommentEntity);

      } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();  
      }
      return PatchStudyMaterialCommentResponseDto.success();
    }

    @Override
<<<<<<< HEAD
    public ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterialComment(String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber,Integer studyMaterialCommentNumber) {

        try {
          
          boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
          if(!existedUser) return DeleteStudyMaterialCommentResponseDto.notExistUser();

          StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
          if(studyEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistUser(); 

          StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);            
          if(studyMaterialEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistMaterial();  
          
          StudyMaterialCommentEntity studyMaterialCommentEntity = studyMaterialCommentRepository.findByStudyMaterialCommentNumber(studyMaterialCommentNumber);
          if(studyMaterialCommentEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistComment();

          boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
          if(!equalCreater) return DeleteStudyMaterialCommentResponseDto.noPermission();       
          
          studyMaterialCommentRepository.delete(studyMaterialCommentEntity);

        } catch (Exception exception) {
          exception.printStackTrace();
          return ResponseDto.databaseError();  
        }
        return DeleteStudyMaterialCommentResponseDto.success();
    }    

    @Override
    public ResponseEntity<? super GetAttendanceInformationResponseDto> getAttendanceInformation(Integer studyNumber,String userEmail) {
=======
    public ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(PatchStudyMaterialCommentRequestDto dto, String userEmail, Integer studyNumber, Integer studyMaterialNumber) {
>>>>>>> 3bd9b62d4657b6b3faa6f1fb49de53da32dce1e2

      try {
            UserEntity  userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return PatchStudyMaterialCommentResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if(studyEntity == null) return PatchStudyMaterialCommentResponseDto.notExistUser(); 
          
            StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);            
            if(studyMaterialEntity == null) return PatchStudyMaterialCommentResponseDto.notExistMaterial();        

            StudyMaterialCommentEntity studyMaterialCommentEntity = studyMaterialCommentRepository.findByStudyMaterialCommentNumber(dto.getStudyMaterialCommentNumber());
            if(studyMaterialCommentEntity == null) return PatchStudyMaterialCommentResponseDto.notExistMaterialCommment();

            boolean equalWriter = studyMaterialCommentEntity.getUserEmail().equals(userEmail);
            if(!equalWriter) return PatchStudyMaterialCommentResponseDto.noPermision();

            
            studyMaterialCommentEntity.patchMaterialComment(dto);
            studyMaterialCommentRepository.save(studyMaterialCommentEntity);

      } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();  
      }
      return PatchStudyMaterialCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterialComment(String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber,Integer studyMaterialCommentNumber) {

        try {
          
          boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
          if(!existedUser) return DeleteStudyMaterialCommentResponseDto.notExistUser();

          StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
          if(studyEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistUser(); 

          StudyMaterialEntity  studyMaterialEntity = studyMaterialRepository.findByStudyMaterialNumber(studyMaterialNumber);            
          if(studyMaterialEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistMaterial();  
          
          StudyMaterialCommentEntity studyMaterialCommentEntity = studyMaterialCommentRepository.findByStudyMaterialCommentNumber(studyMaterialCommentNumber);
          if(studyMaterialCommentEntity == null) return DeleteStudyMaterialCommentResponseDto.notExistComment();

          boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
          if(!equalCreater) return DeleteStudyMaterialCommentResponseDto.noPermission();       
          
          studyMaterialCommentRepository.delete(studyMaterialCommentEntity);

        } catch (Exception exception) {
          exception.printStackTrace();
          return ResponseDto.databaseError();  
        }
        return DeleteStudyMaterialCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostStudyUserListResponseDto> postStudyUserList(Integer studyNumber, String userEmail,String studyGrade) {

      try {
        
        boolean existedUser = userRepository.existsByUserEmail(userEmail);
        if(!existedUser) return PostStudyUserListResponseDto.notExistUser();

        StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
        if(studyEntity == null) return PostStudyUserListResponseDto.notExistUser();

        StudyUserListEntity studyUserListEntity = new StudyUserListEntity(studyNumber,userEmail,studyGrade);
        studyUserListRepository.save(studyUserListEntity);

      } catch (Exception exception) {
          exception.printStackTrace();
          return ResponseDto.databaseError();  
      }

      return PostStudyUserListResponseDto.success();
    }


}
