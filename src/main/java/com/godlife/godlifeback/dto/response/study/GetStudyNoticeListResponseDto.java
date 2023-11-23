package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.NoticeListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;

import lombok.Getter;

@Getter
public class GetStudyNoticeListResponseDto extends ResponseDto{
    

    private List<NoticeListItem> noticeList;        

    private GetStudyNoticeListResponseDto(String code ,String message, List<StudyNoticeListResultSet> resultSets){
        super(code, message);
        this.noticeList = NoticeListItem.getNoticeList(resultSets);
    } 

    public static ResponseEntity<GetStudyNoticeListResponseDto> success( List<StudyNoticeListResultSet> resultSets){
        GetStudyNoticeListResponseDto result = new GetStudyNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_NOTICE, ResponseMessage.NOT_EXIST_NOTICE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_ROOM, ResponseMessage.NOT_EXIST_STUDY_ROOM);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
    
    
}
