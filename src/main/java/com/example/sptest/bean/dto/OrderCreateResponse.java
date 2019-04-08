package com.example.sptest.bean.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Data
@Builder
public class OrderCreateResponse extends Pojo {
    private String orderNo;
    private String outOrderNo;
    private String mobile;
    private String vipType;
    private Integer buyDays;
    private String contractId;
    private String openTime;
    private String orderFee;
    private String status;
}
