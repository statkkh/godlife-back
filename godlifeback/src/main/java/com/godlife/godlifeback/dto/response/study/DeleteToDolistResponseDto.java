package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteToDolistResponseDto extends ResponseDto{
    
    private DeleteToDolistResponseDto (String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteToDolistResponseDto> success(){
        DeleteToDolistResponseDto result = new DeleteToDolistResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistToDoList(){
        ResponseDto result = new ResponseDto( ResponseCode.NOT_TODOLIST_EXISTS, ResponseMessage.NOT_TODOLIST_EXISTS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
