package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchMaterialResponseDto extends ResponseDto{
    
    private PatchMaterialResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<PatchMaterialResponseDto> success(){
        PatchMaterialResponseDto result = new PatchMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
