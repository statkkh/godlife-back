package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteMaterialResponseDto extends ResponseDto{
    
    private DeleteMaterialResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteMaterialResponseDto> success(){
        DeleteMaterialResponseDto result = new DeleteMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result); 
    }

    public static ResponseEntity<ResponseDto> notExistMaterial(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_MATERIAL, ResponseMessage.NOT_EXIST_STUDY_MATERIAL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
    }
}
