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
public class YJYRefundMajorMemberResponse extends Pojo {
    private YJYRefundOrderRes data;
    @JsonProperty("ss")
    private Boolean status;

    public static void main(String[] args) {
        YJYRefundMajorMemberResponse res = new YJYRefundMajorMemberResponse();
        YJYRefundOrderRes orderRes = new YJYRefundOrderRes();
        res.setData(orderRes);
        res.setStatus(true);

        orderRes.setOrderNo("1");
        orderRes.setOutOrderNo("2");
        orderRes.setRefundBuyDays(1);
        orderRes.setRefundTime(System.currentTimeMillis());

        System.out.println(res.toJson());
    }
}
