package com.sshsys.springbootsecurity.user;

/**
 * 유저를 찾을 수 없을때 발생하는 Exception
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("유저를 찾을 수 없습니다.");
    }
}
