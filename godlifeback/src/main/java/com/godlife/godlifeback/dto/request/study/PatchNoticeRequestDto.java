package com.godlife.godlifeback.dto.request.study;


import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NotBlank
@Setter
@NoArgsConstructor
@Getter
public class PatchNoticeRequestDto {

    @NotBlank @Size(min = 2)
    private List<String> noticeContentList;
    
    @NotBlank @Size(min = 2)
    public  String getNoticeContent() {
        return null;
    }

    
}
