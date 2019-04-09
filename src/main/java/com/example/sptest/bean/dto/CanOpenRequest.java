package com.example.sptest.bean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Data
public class CanOpenRequest extends Pojo {
    @JsonProperty("appId")
    private String appId;
    @NotNull
    @Pattern(regexp = "^\\+0086[0-9]{11}$")
    private String mobile;
}
