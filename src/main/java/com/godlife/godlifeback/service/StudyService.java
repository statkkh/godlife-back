package com.godlife.godlifeback.service;


import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.study.GetStudyNoticeListResponseDto;



import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostMaterialRequestDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostMaterialResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;



public interface StudyService {

    ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(Integer studyNumber, String userEmail);   
    
    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer studyNumber,String createStudyUserEmail);

    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);
    
    ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer studyNumber, String createStudyUserEmail,Integer studyNoticeNumber);

    ResponseEntity<? super PostMaterialResponseDto> postMaterial(PostMaterialRequestDto dto, Integer studyNumber,String createStudyUserEmail, String studyMaterialImageUrl);
}
