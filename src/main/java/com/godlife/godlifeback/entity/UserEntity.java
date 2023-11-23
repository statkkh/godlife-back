package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife.godlifeback.dto.request.auth.SignUpRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
 
    @Id
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userFavorite1;
    private String userFavorite2;
    private String userFavorite3;
    private String userProfileImageUrl;
    private Integer userExperience;

    public UserEntity(SignUpRequestDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userFavorite1 = dto.getUserFavorite1();
        this.userExperience = 0;
    }   
    
    
 
}
