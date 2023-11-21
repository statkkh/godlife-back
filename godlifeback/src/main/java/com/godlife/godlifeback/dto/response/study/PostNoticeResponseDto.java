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
public class PostNoticeResponseDto extends ResponseDto{
    
    private List<NoticeListItem> noticeList;

    private PostNoticeResponseDto(String code, String message, List<StudyNoticeEntity> studyNoticeEntities){
        super(code, message);
    }

    public static ResponseEntity<PostNoticeResponseDto> success(List<StudyNoticeEntity> studyNoticeEntities){
        PostNoticeResponseDto  result = new PostNoticeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyNoticeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> mistMatchLeaderEmail(){
        ResponseDto result = new ResponseDto(ResponseCode.MISMATCH_LEADER_EMAIL, ResponseMessage.MISMATCH_LEADER_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
}
