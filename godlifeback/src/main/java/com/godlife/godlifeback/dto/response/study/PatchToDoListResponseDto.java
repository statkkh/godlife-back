package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchToDoListResponseDto extends ResponseDto{
    
    private PatchToDoListResponseDto(String code, String message){
        super(code, message);
    }

   public static ResponseEntity<PatchToDoListResponseDto> success(){
    PatchToDoListResponseDto result = new PatchToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    return  ResponseEntity.status(HttpStatus.OK).body(result);
   }

   public static ResponseEntity<PatchToDoListResponseDto> notExistToDolist(){
    PatchToDoListResponseDto result = new PatchToDoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
   }

}
