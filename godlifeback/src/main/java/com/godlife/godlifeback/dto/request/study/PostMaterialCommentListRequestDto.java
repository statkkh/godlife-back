package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostMaterialCommentListRequestDto {
    @NotBlank @Size(min = 2)
    private String studyMaterialCommentContent;
}
