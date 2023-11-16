package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyNoticeEntity;

import lombok.Getter;

@Getter
public class GetNoticeResponseDto extends ResponseDto{
    
    private int studyNoticeNumber;
    private int studyNumber;
    private String noticeContent;

    private GetNoticeResponseDto(String code, String message, StudyNoticeEntity studyNoticeEntity ){
        super(code, message);

        this.studyNoticeNumber = studyNoticeEntity.getNoticeNumber();
        this.studyNumber = studyNoticeEntity.getStudyNumber();
        this.noticeContent = studyNoticeEntity.getNoticeContent();
        
    }

    public static ResponseEntity<GetNoticeResponseDto> success(StudyNoticeEntity studyNoticeEntity){
        GetNoticeResponseDto  result = new GetNoticeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyNoticeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
}
