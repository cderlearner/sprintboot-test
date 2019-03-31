package com.example.sptest.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RefundMinorMemberRequest extends Pojo{
    private String appId;

    @NotNull
    @Size(min = 1, max = 32)
    private String outOrderNo;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")
    private String refundTime;
}
