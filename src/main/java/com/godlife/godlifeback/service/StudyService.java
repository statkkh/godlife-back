package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;

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
// import com.godlife.godlifeback.dto.request.studyService.material.PatchMaterialRequestDto;

import com.godlife.godlifeback.dto.response.studyService.material.GetStudyMaterialListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.PostStudyMaterialResponseDto;
import com.godlife.godlifeback.dto.response.studyService.material.DeleteStudyMaterialResponseDto;

import com.godlife.godlifeback.dto.request.studyService.materialComment.PostMaterialCommentRequestDto;
import com.godlife.godlifeback.dto.request.studyService.materialComment.PatchMaterialCommentReqeuestDto;

import com.godlife.godlifeback.dto.response.studyService.materialComment.GetStudyMaterialCommentListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.PostMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.PatchMaterialCommentResponseDto;
import com.godlife.godlifeback.dto.response.studyService.materialComment.DeleteStudyMaterialCommentResponseDto;


public interface StudyService {

    ResponseEntity<? super GetStudyResponseDto> getStudy(Integer studyNumber,String userEmail);

    ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(Integer studyNumber, String userEmail);   
    ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);
    ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);
    
    ResponseEntity<? super GetStudyTodoListResponseDto> getTodolist(Integer studyNumber, String userEmail);
    ResponseEntity<? super PostStudyTodoListResponseDto > postTodo(PostToDoListRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodo(PatchToDoListRequestDto requestBody, String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    
    ResponseEntity<? super GetStudyMaterialListResponseDto> getMaterialList(Integer studyNumber, String userEmail);
    ResponseEntity<? super PostStudyMaterialResponseDto> postMaterial(PostMaterialRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    // ResponseEntity<? super PatchStudyMaterialResponseDto> patchMaterial(PatchMaterialRequestDto dto,String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber);
    ResponseEntity<? super DeleteStudyMaterialResponseDto> deleteMaterial(String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber);

    ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialCommentList(String userEmail,Integer studyNumber,Integer studyMaterialNumber);    
    ResponseEntity<? super PostStudyMaterialCommentResponseDto> postMaterialComment(PostStudyMaterialCommentRequestDto dto, String userEmail,Integer studyNumber,Integer studyMaterialNumber);
    ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(PatchStudyMaterialCommentRequestDto dto,String userEmail,Integer studyNumber,Integer studyMaterialNumber);
    ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterilComment(String userEmail,Integer studyNumber,Integer studyMaterialNumber,Integer studyMaterialCommentNumber);

}
