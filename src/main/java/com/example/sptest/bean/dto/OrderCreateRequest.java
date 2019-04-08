package com.example.sptest.bean.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Data
@Builder
public class OrderCreateRequest extends Pojo{
    private String appId;

    @NotNull
    @Size(min = 1, max = 32)
    private String outOrderNo;

    @NotNull
    @Pattern(regexp = "^\\+0086[0-9]{11}$")
    private String mobile;

    @Pattern(regexp = "^(INSTABOOK)$")
    private String vipType = "INSTABOOK";

    @NotNull
    @Min(1)
    @Max(1095)
    private Integer buyDays;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")
    private String openTime;
    private String contractId;
    private String orderFee;
}
