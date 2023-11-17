package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.study.PatchNoticeListRequestDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeListRequestDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;

public interface StudyService {

    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeListRequestDto dto, Integer studyNoticeNumber);
    
    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeListRequestDto dto, Integer studyNoticeNumber);
    ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer studyNoticeNumber);

    // ResponseEntity<? super GetNoticeListResponseDto> getNotice(Integer studyNoticeNumber);   
}
