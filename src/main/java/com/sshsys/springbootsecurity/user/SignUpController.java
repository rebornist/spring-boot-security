package com.sshsys.springbootsecurity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 회원가입 Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;

    @GetMapping
    public String signUp() {
        return "signup";
    }

    @PostMapping
    public String signUp(
            @ModelAttribute UserRegisterDto userDto
    ) {
        userService.signUp(userDto.getUsername(), userDto.getPassword());
        return "redirect:/login";
    }


}
