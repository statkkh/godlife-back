package com.godlife.godlifeback.dto.request.study;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostMaterialRequestDto {

    @NotNull
    private String writer;
}
