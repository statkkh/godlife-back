package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchToDoListRequestDto {
    
    @NotBlank @Size(min = 2)
    private String studyListContent;

    @NotNull @AssertTrue
    private Boolean studyListCheck;    
}
