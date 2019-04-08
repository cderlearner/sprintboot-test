package com.example.sptest.aspect;

import com.example.sptest.bean.dto.Pojo;
import lombok.Data;

@Data
public class PartnerEventModel extends Pojo {
    private Long id;
    private String uuid;
    private String method;
    private String arguments;
    private String result;
    private String error;
}
