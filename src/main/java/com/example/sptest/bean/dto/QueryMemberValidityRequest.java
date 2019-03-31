package com.example.sptest.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class QueryMemberValidityRequest extends Pojo {
    private String appId;
    @NotNull
    @Pattern(regexp = "^\\+0086[0-9]{11}$")
    private String mobile;
}
