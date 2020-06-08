package com.example.sptest.validator;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class Teacher {
    @NotNull(message = "名字不能为空")
    private String name;

    @Min(value = 100, message = "uid过小")
    @Max(value = 200, message = "uid过大")
    private Long userId;
}
