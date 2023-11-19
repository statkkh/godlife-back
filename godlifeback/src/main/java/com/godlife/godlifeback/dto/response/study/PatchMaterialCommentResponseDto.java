package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class PatchMaterialCommentResponseDto extends ResponseDto{
    
    private PatchMaterialCommentResponseDto(String code, String messsage){
        super(code, code);
    }

    public static ResponseEntity<PatchMaterialCommentResponseDto> success(){
        PatchMaterialCommentResponseDto result = new PatchMaterialCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
