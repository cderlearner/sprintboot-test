package com.example.sptest.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jd")
public class JDConfig {
    private String serverUrl;
    private String appKey;
    private String appSecret;
    private String accessToken;
    private String callbackUrl;
    private String oauth2Url;
    private String tokenUrl;
    private String sku;
    private String unitPrice;
    private String rsaPubKey;
}
