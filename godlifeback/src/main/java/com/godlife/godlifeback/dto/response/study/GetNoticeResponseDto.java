package com.godlife.godlifeback.dto.response.study;

import com.godlife.godlifeback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetNoticeResponseDto extends ResponseDto{
    
    private int studyNoticeNumber;
    private int studyNumber;
    private String noticeContent;

    // private GetNoticeResponseDto(String code, String message, )
}
