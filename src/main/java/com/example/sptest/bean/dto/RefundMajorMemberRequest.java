package com.example.sptest.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class RefundMajorMemberRequest{
    private String appId;

    @NotNull
    @Size(min = 1, max = 32)
    private String orderNo;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")
    private String refundTime;

    @NotNull
    @Positive
    private Integer buyDays;
}
