package com.example.CarBlog_2.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

    @Size(min=3, max=25, message = "아이디는 최소3자 최대 25자까지 입력가능합니다")
    @NotEmpty(message = "사용자 ID는 필수 항목입니다")
    public String username;

    @Size(min=4 , message = "비밀번호는 최소 4자이상입니다")
    @NotEmpty(message = "비밀번호는 필수항목입니다")
    public String password;

    @NotEmpty(message = "이메일은 필수항목입니다")
    public String email;


}
