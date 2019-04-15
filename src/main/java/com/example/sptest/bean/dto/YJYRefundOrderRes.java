package com.example.sptest.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Author: linjx
 * Date: 2019/4/3
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class YJYRefundOrderRes {
    @JsonProperty("orderNo")
    private String orderNo;
    @JsonProperty("outOrderNo")
    private String outOrderNo;
    @JsonProperty("refundBuyDays")
    private Integer refundBuyDays;
    @JsonProperty("refundTime")
    private Long refundTime;
    @JsonProperty("refundPresentDays")
    private Integer refundPresentDays;
}
