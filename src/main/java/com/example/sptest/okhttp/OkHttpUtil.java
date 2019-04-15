package com.example.sptest.okhttp;

import com.example.sptest.bean.dto.CanOpenRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

public class OkHttpUtil {

    private final static Logger logger = LoggerFactory.getLogger(OkHttpUtil.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final OkHttpClient CLIENT = new OkHttpClient();

    @Nullable
    public static <T> T doGetRequest(String url, Map<String, String> params, Class<T> responseClass) {
        HttpUrl.Builder httpUrlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        params.forEach(httpUrlBuilder::addQueryParameter);

        Request request = new Request.Builder()
                .url(httpUrlBuilder.build())
                .build();
        return doRequest(request, responseClass);
    }

    @Nullable
    public static <T> T doRequest(Request request, Class<T> respClass) {
        try (Response response = CLIENT.newCall(request).execute()) {
            InputStream inputStream = Objects.requireNonNull(response.body()).byteStream();
            return objectMapper.readValue(inputStream, respClass);
        } catch (Exception e) {
            logger.error("request: " + request.toString() + " error:", e);
        }
        return null;
    }

    @Nullable
    public static JsonNode doGetRequest(String url, Map<String, String> params) {
        HttpUrl.Builder httpUrlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        params.forEach(httpUrlBuilder::addQueryParameter);

        Request request = new Request.Builder()
                .url(httpUrlBuilder.build())
                .build();
        return doRequest(request);
    }

    @Nullable
    public static JsonNode doRequest(Request request){
        try (Response response = CLIENT.newCall(request).execute()) {
            InputStream inputStream = Objects.requireNonNull(response.body()).byteStream();
            return objectMapper.readTree(inputStream);
        } catch (Exception e) {
            logger.error("request: " + request.toString() + " error:", e);
        }
        return null;
    }

    public static String post(String url, String jsonData) {
        Request req = new Request
                .Builder()
                .url(url)
                .post(okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonData))
                .build();
        JsonNode res = OkHttpUtil.doRequest(req);
        return res.toString();
    }


    public static void main(String[] args) {
        CanOpenRequest req = new CanOpenRequest();
        req.setAppId("aaaa");
        req.setMobile("13810");

        System.out.println(DateTimeUtil.epochMillisToDefaultZoneTime(System.currentTimeMillis()));
        System.out.println(post("http://localhost:8080/pp", req.toJson()));
        System.out.println(DateTimeUtil.epochMillisToDefaultZoneTime(System.currentTimeMillis()));
    }
}
