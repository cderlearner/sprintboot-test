package com.example.sptest.bean.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Data
@Builder
public class OrderCreateRequest extends Pojo{
    private String appId;

    @NotNull
    @Size(min = 1, max = 32)
    private String outOrderNo;

    @NotNull
    @Pattern(regexp = "^\\+0086[0-9]{11}$")
    private String mobile;

    @Pattern(regexp = "^(SVIP|INSTABOOK)$")
    private String vipType = "INSTABOOK";

    @NotNull
    @Min(1)
    @Max(1095)
    private Integer buyDays;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")
    private String openTime;
    private String contractId;
    private String orderFee;

//    @Data
//    public static class ORequest {
//        private String appId;
//        private String outOrderNo;
//        private String mobile;
//        private String vipType = "INSTABOOK";
//        private Integer buyDays;
//        private String openTime;
//        private String contractId;
//        private String orderFee;
//    }

//    public static void main(String[] args) throws IOException {
//        String param = "[{\"app_id\":\"100041236812531729838455\",\"out_order_no\":\"134343470191611494222\",\"mobile\":\"+008615608036305\",\"vip_type\":\"INSTABOOK\",\"buy_days\":365,\"open_time\":\"2019-04-13 12:29:26\",\"contract_id\":\"0\",\"order_fee\":\"zhihu123\"}]";
//        ObjectMapper mapper = new ObjectMapper()
//                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
//                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
//                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        ArrayNode arrayNode = (ArrayNode) mapper.readTree(param);
//        ORequest req = mapper.convertValue(arrayNode.get(0), ORequest.class);
//        System.out.println(req);
//    }
}
