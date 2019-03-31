package com.example.sptest.bean.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public abstract class Pojo {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static class HashMapTypeReference extends TypeReference<HashMap<String, Object>> {

    }

    static {
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    public static <T extends Pojo> T fromJson(String json, Class<T> pojoType) {
        try {
            return mapper.readValue(json, pojoType);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot convert json to pojo object: " + json, e);
        }
    }

    public ObjectNode toObjectNode() {
        return (ObjectNode) mapper.valueToTree(this);
    }

    public HashMap<String, Object> toHashMap() {
        return mapper.convertValue(this, new HashMapTypeReference());
    }

    public <T extends Pojo> T wrapTo(Class<T> type) {
        return mapper.convertValue(this, type);
    }

    public String toJson() {
        return mapper.valueToTree(this).toString();
    }

    @Override
    public int hashCode() {
        return toHashMap().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pojo)) {
            return false;
        }
        return Objects.equals(toHashMap(), ((Pojo) obj).toHashMap());
    }

    @Override
    public String toString() {
        return toJson();
    }
}
