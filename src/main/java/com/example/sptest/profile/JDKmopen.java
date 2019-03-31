package com.example.sptest.profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Data
@Component
@ConfigurationProperties(prefix = "kmopen")
public class JDKmopen {
    private String jdAppId;
}
