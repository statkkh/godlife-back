package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.NoticeListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyNoticeEntity;

import lombok.Getter;

@Getter
public class GetNoticeListResponseDto extends ResponseDto{
    

    private List<NoticeListItem> noticeList;        

    private GetNoticeListResponseDto(String code ,String message, List<StudyNoticeEntity> studyNoticeEntities){
        super(code, message);
        this.noticeList = NoticeListItem.getNoticeList(studyNoticeEntities);
    } 

    public static ResponseEntity<GetNoticeListResponseDto> success( List<StudyNoticeEntity> studyNoticeEntities){
        GetNoticeListResponseDto result = new GetNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyNoticeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
}
