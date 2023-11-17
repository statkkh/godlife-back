package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostMaterialRequestDto {
    @NotBlank
    private String studyMaterialName;

    @NotBlank
    private String studyMaterialWriter;
}
