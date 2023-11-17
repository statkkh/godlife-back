package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PostMaterialResponseDto extends ResponseDto{
    
    private PostMaterialResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PostMaterialResponseDto> success(){
        PostMaterialResponseDto result = new PostMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    

    public static ResponseEntity<ResponseDto> notExistMaterial(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY_MATERIAL, ResponseMessage.NOT_EXIST_STUDY_MATERIAL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
    }

}
