package com.example.sptest.aspect;

import com.example.sptest.aspect.mapper.PartnerEventDao;
import com.example.sptest.bean.dto.Pojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
@Component
class LogEventAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ObjectMapper objectMapper = new ObjectMapper();
    private PartnerEventDao eventDao;

    public LogEventAspect(PartnerEventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Around("@annotation(com.example.sptest.aspect.LogEvent) && execution(* com.example.sptest.aspect.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ArrayNode nodes = objectMapper.createArrayNode();
        Stream.of(joinPoint.getArgs())
                .map(x -> x instanceof Pojo ? ((Pojo) x).toObjectNode() : objectMapper.createObjectNode())
                .collect(Collectors.toList())
                .forEach(nodes::add);
        PartnerEventModel model = new PartnerEventModel();
        model.setUuid(UUID.randomUUID().toString());
        model.setMethod(joinPoint.getSignature().getName());
        model.setArguments(nodes.toString());
        try {
            Object result = joinPoint.proceed();
            Stream.of(result)
                    .map(x -> x instanceof Pojo ? ((Pojo) x).toObjectNode() : objectMapper.createObjectNode())
                    .map(ObjectNode::toString)
                    .forEach(model::setResult);
            return result;
        } catch (Throwable e) {
            Stream.of(e)
                    .map(ExceptionUtils::getStackTrace)
                    .forEach(model::setError);
            throw e;
        } finally {
            eventDao.create(model);
            System.out.println("created");
        }
    }
}
