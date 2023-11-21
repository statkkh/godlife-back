package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteNoticeListResponseDto extends ResponseDto{
    
    private DeleteNoticeListResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteNoticeListResponseDto> success(){
        DeleteNoticeListResponseDto result = new DeleteNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistNotice(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_NOTICE_EXISTS, ResponseMessage.NOT_NOTICE_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> misMatchLeaderEmail(){
        ResponseDto result = new ResponseDto(ResponseCode.MISMATCH_LEADER_EMAIL, ResponseMessage.MISMATCH_LEADER_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
 