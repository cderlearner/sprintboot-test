package com.example.sptest.bean.dto;

import lombok.Data;

@Data
public class RefundMemberResponse extends Pojo {
    private String orderNo;
    private String outOrderNo;
    private Integer refundBuyDays;
    private String refundTime;
}
