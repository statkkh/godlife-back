package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.request.study.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.study.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.response.study.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.study.PostNoticeResponseDto;

public interface StudyService {

    ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto, Integer noticeNumber);
    
    
    ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto, Integer noticeNumber);
    ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(Integer noticeNumber);


    
}
