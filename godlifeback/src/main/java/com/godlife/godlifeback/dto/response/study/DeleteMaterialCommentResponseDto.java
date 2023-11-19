package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class DeleteMaterialCommentResponseDto extends ResponseDto{
    
    private DeleteMaterialCommentResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteMaterialCommentResponseDto> success(){
        DeleteMaterialCommentResponseDto result = new DeleteMaterialCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
