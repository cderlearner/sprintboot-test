package com.example.sptest.listener.event;

import com.example.sptest.bean.dto.Pojo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberCreateByPhoneNoMessage extends Pojo {
    @JsonProperty("Uid")
    private Long uid;
    @JsonProperty("OperatorId")
    private Long operatorId;
    @JsonProperty("PhoneNo")
    private String phoneNo;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("ClientIp")
    private String clientIp;
    @JsonProperty("ClientId")
    private Long clientId;
    @JsonProperty("DeviceId")
    private Long deviceId;
    @JsonProperty("UserAgent")
    private String userAgent;
    @JsonProperty("RuntimeId")
    private Long runtimeId;
}
