package com.godlife.godlifeback.dto.request.studyService.materialComment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchMaterialCommentReqeuestDto {
    
    @NotBlank @Size(min = 2)
    private String studyMaterialCommentContent;
}
