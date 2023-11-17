package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.NoticeListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyNoticeListEntity;

import lombok.Getter;

@Getter
public class PatchNoticeResponseDto extends ResponseDto{

    private List<NoticeListItem> noticeList;  

    private PatchNoticeResponseDto(String code, String message, List<StudyNoticeListEntity> studyNoticeEntities){
        super(code, message);
    }

    public static ResponseEntity<PatchNoticeResponseDto> success(List<StudyNoticeListEntity> studyNoticeEntities){
        PatchNoticeResponseDto result = new PatchNoticeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyNoticeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
