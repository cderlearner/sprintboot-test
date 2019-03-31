package com.example.sptest.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Data
public class QueryOrderRequest extends Pojo {
    private String appId;
    @NotNull
    @Size(min = 1, max = 32)
    private String outOrderNo;
}
