package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStudyRequestDto {
    
    @NotBlank @Size(min=2, max=20)
    private String studyName;

    @NotBlank
    private String studyStartDate;     

    @NotBlank
    private String studyEndDate;    

    @NotBlank
    private Integer studyPersonal;

    @NotBlank
    private String studyCategory1;

    private String studyCategory2;

    private String studyCategory3;

    @NotNull
    private Boolean studyPublicCheck;

    @Size(min = 8)
    private String studyPrivatePassword;

    private String studyCoverImageUrl;
}
