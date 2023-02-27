package com.sshsys.springbootsecurity.user;

import lombok.*;

/**
 * 회원가입 Dto
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserRegisterDto {
    private String username;
    private String password;

}
