package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteNoticeResponseDto extends ResponseDto{
    
    private DeleteNoticeResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteNoticeResponseDto> success(){
        DeleteNoticeResponseDto result = new DeleteNoticeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
