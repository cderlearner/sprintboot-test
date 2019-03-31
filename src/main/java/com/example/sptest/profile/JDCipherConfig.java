package com.example.sptest.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jd-cipher")
public class JDCipherConfig {
    private String aesKey;
    private String aesIv;
}
