package com.godlife.godlifeback.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;

public class PostMaterialCommentResponseDto extends ResponseDto{

    private PostMaterialCommentResponseDto(String code, String messsage){
        super(code, messsage);
    }

    public static ResponseEntity<PostMaterialCommentResponseDto> success(){
        PostMaterialCommentResponseDto result = new PostMaterialCommentResponseDto(ResponseCode.SUCCESS,  ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
    
}
