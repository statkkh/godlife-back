package com.godlife.godlifeback.dto.request.studyService.material;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostMaterialNameReqeuestDto {
    
    @NotBlank @Size(min = 2)
    private String studyMaterialName;

    @NotNull @Size(min = 2)
    private String studyMaterialWriter;

    private String studyMaterialImageUrl;
}