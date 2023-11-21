package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PostToDoListResponseDto extends ResponseDto{
    
    private PostToDoListResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<PostToDoListResponseDto> success(){
        PostToDoListResponseDto result = new PostToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistToDolist(){
        ResponseDto result = new PostToDoListResponseDto(ResponseCode.NOT_TODOLIST_EXISTS, ResponseMessage.NOT_TODOLIST_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> misMatchLeaderEmail(){
        ResponseDto result = new ResponseDto(ResponseCode.MISMATCH_LEADER_EMAIL, ResponseMessage.MISMATCH_LEADER_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
