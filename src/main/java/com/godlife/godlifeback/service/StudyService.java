package com.godlife.godlifeback.service;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchMaterialRequestDto;
import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;

import com.godlife.godlifeback.dto.response.study.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.request.study.PostToDoListRequestDto;
import com.godlife.godlifeback.dto.response.study.PostToDoListResponseDto;
import com.godlife.godlifeback.dto.request.study.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteToDolistResponseDto;


import com.godlife.godlifeback.dto.response.study.GetMaterialResponseDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchMaterialResponseDto;


import com.godlife.godlifeback.dto.response.study.PatchMaterialCommentResponseDto;

import com.godlife.godlifeback.dto.response.study.GetAttendanceInformationResponseDto;

public interface StudyService {

    ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(Integer studyNumber, String userEmail);   
    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);
    ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);
    
    ResponseEntity<? super GetToDoListResponseDto> getTodolist(Integer studyNumber, String userEmail);
    ResponseEntity<? super PostToDoListResponseDto > postTodo(PostToDoListRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    ResponseEntity<? super PatchToDoListResponseDto> patchTodo(PatchToDoListRequestDto requestBody, String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    ResponseEntity<? super DeleteToDolistResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber,Integer studyListNumber);
    
    ResponseEntity<? super GetMaterialResponseDto> getMaterialList(Integer studyNumber, String userEmail);
    ResponseEntity<? super PostMaterialResponseDto> postMaterial(PostMaterialRequestDto dto, Integer studyNumber,String createStudyUserEmail);
    ResponseEntity<? super PatchMaterialResponseDto> patchMaterial(PatchMaterialRequestDto dto,String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber);
    ResponseEntity<? super DeleteMaterialResponseDto> deleteMaterial(String createStudyUserEmail,Integer studyNumber, Integer studyMaterialNumber);
    
    ResponseEntity<? super GetAttendanceInformationResponseDto> getAttendanceInformation(Integer studyNumber, String userEmail);

}
