package com.godlife.godlifeback.dto.response.study;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.MaterialCommentListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyMaterialCommentEntity;

import lombok.Getter;

@Getter
public class GetMaterialCommentResponseDto extends ResponseDto{

    
    private List<MaterialCommentListItem> materialCommentList; 

    private GetMaterialCommentResponseDto(String code, String message, List<StudyMaterialCommentEntity> studyMaterialCommentEntities){
        super(code, message);
        this.materialCommentList = MaterialCommentListItem.getMaterialCommentList(studyMaterialCommentEntities);
    }

    public static ResponseEntity<ResponseDto> success(List<StudyMaterialCommentEntity> studyMaterialCommentEntities){
        GetMaterialCommentResponseDto result = new GetMaterialCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, studyMaterialCommentEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
