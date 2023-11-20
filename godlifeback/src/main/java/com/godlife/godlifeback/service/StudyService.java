package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.study.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetAttendanceInformationResponseDto;
import com.godlife.godlifeback.dto.response.study.GetMaterialCommentResponseDto;


import com.godlife.godlifeback.dto.request.study.PostNoticeListRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyResponseDto;

import com.godlife.godlifeback.dto.request.study.PatchNoticeListRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;

import com.godlife.godlifeback.dto.response.study.DeleteNoticeListResponseDto;



public interface StudyService {

    ResponseEntity<? super GetNoticeListResponseDto> getNotice(Integer studyNoticeNumber);   
    
    ResponseEntity<? super GetToDoListResponseDto> getToDoList(Integer studyToDoListNumber);
    // ResponseEntity<? super GetAttendanceInformationResponseDto> getAttendanceInformation(Integer studyNumber, String userEmail);  
    // ResponseEntity<? super GetMaterialCommentResponseDto> getMaterialCommetList(Integer );
      
    ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail);
    ResponseEntity<? super GetAttendanceInformationResponseDto> getUserAttendanceInformationList(Integer studyNumber , String userEmail);
    
    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeListRequestDto dto, Integer studyNoticeNumber);
    

    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeListRequestDto dto, Integer studyNoticeNumber);
    
    
    ResponseEntity<? super DeleteNoticeListResponseDto> deleteNotice(Integer studyNoticeNumber);

}
