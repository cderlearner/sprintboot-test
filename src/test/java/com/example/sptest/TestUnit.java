package com.example.sptest;

import com.example.sptest.bean.dto.YJYRefundOrderRes;
import com.example.sptest.okhttp.OkHttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Request;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Author: linjx
 * Date: 2018/10/26
 */
public class TestUnit {

    @Test
    public void test1() throws Exception {
        Lock lock = new ReentrantLock();
        lock.lock();
        Condition condition = lock.newCondition();
        condition.awaitNanos(0);
        lock.unlock();
        System.err.println("-------------");
    }

    @Test
    public void test2() {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.getServletConfig();
    }

    @Test
    public void test3() {
        YJYRefundOrderRes res = null;
        System.out.println(res instanceof YJYRefundOrderRes);
        res = null;
        System.err.println(res instanceof YJYRefundOrderRes);
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test4() throws IOException {
        String json = "<{\"data\":true,\"status\":true}";

        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toString());
    }

    @Test
    public void test5() {
        Request req = new Request
                .Builder()
                .url("http://localhost:8080/j")
                .get()
                .build();
        JsonNode jsonNode = OkHttpUtil.doRequest(req);
        System.out.println(jsonNode);
    }

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
        System.out.println(!CollectionUtils.isEmpty(Collections.emptyList()));
        System.out.println(!CollectionUtils.isEmpty(Arrays.asList(1)));
    }

    @Test
    public void test7() {
        System.out.println(TimeUnit.MILLISECONDS.toNanos(1000));
    }

    @Test
    public void test8() {
        List<String> strs = Arrays.asList("1", "2", "3");
        List strs2 = strs.stream().filter(s -> {
            if (s.equals("1")) {
                System.out.println(s + ":1");
                return true;
            }
            return false;
        }).filter(s -> {
            if (s.equals("2")) {
                System.out.println(s + ":2");
                return true;
            }
            return false;
        })
                .collect(Collectors.toList());

//        System.out.println(strs.stream().filter(s -> {
//            if (s.equals("1")) {
//                System.out.println(s + ":1");
//                return true;
//            }
//            return false;
//        }).collect(Collectors.toList()));

        System.out.println(strs.stream().filter(s -> {
            if (s.equals("1") || s.equals("2")) {
                System.out.println(s + ":1");
                return true;
            }
            return false;
        }).collect(Collectors.toList()));
    }

    Runnable r1 = () -> {
        System.out.println(this);
    };
    Runnable r2 = () -> {
        System.out.println(toString());
    };

    @Override
    public String toString() {
        return "Hello World!";
    }

    @Test
    public void test9() {
        new TestUnit().r1.run();
        new TestUnit().r2.run();
    }

    public static void main(String[] args) {
        //Bar.INS.f1();
        //System.out.println(Bar.INS);
//        System.out.println(Bar.tmp);
//        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
//        System.out.println("2:" + Bar.tmp);
//        System.out.println("2:" + Bar.tmp);
//        System.out.println("2:" + Bar.tmp);
//        System.out.println("2:" + Bar.tmp);
//        System.out.println("2:" + Bar.tmp);
//        System.out.println("2:" + Bar.tmp);

        //System.out.println(Bar.tmp2);
//        Bar.f2();
//        Bar.f2();
//        Bar.f2();
//        Bar.f3();
//        Bar.f3();
//        Bar.f3();


        //new Bar();
        //new Bar();

        RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(2000).setReadTimeout(2000).build();
        ResponseEntity<ObjectNode> res = restTemplate.exchange("http://localhost:8080/tt/{id}/sss/{name}", HttpMethod.GET, null,
                ObjectNode.class,
                1, "hhh");

        ObjectNode node = res.getBody();
        System.out.println(res);
        System.out.println(node.findValue("id"));
    }

    @Setter
    @Getter
    static class CachedRandomPageDto {
        private Long userId;            // 官方账号userId
        private Integer pageNo;         // 如果pageNo页随机过，缓存

        private int size;
        private String accessToken;

        @Override
        public boolean equals(Object obj) {
            Integer theHashCode = this.hashCode();
            Integer thatHanCode = obj.hashCode();
            return Objects.equals(thatHanCode, thatHanCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, pageNo);
        }
    }

    @Test
    public void test10() {
        Map<CachedRandomPageDto, String> map = Maps.newHashMap();

        CachedRandomPageDto dto1 = new CachedRandomPageDto();
        dto1.setUserId(1L);
        dto1.setPageNo(1);
        dto1.setSize(1);
        dto1.setAccessToken("1");

        CachedRandomPageDto dto2 = new CachedRandomPageDto();
        dto2.setUserId(1L);
        dto2.setPageNo(1);
        dto2.setSize(2);
        dto2.setAccessToken("2");

        CachedRandomPageDto dto3 = new CachedRandomPageDto();
        dto3.setUserId(2L);
        dto3.setPageNo(1);
        dto3.setSize(3);
        dto3.setAccessToken("23");

        map.put(dto1, "1");

        String value = map.get(dto2);
        System.out.println(value);

        System.out.println(Test2.MAX_CACHE_SIZE);
    }

    @Test
    public void test11() {
        System.out.println(ExceptionUtils.getStackTrace(new Throwable()));
    }

    @Test
    public void test12() {
        List<Integer> ids = Lists.newArrayList(1, 2);

        Iterator<?> itr = ids.iterator();
        for (Iterator<?> it = itr; it.hasNext(); ) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }

    @Test
    public void test13() {
        String userId = "1";
        String clientId = "2";
        String time = "345";
        String redisKey = Joiner.on(":").join(Arrays.asList(userId, clientId, time));
        System.out.println(redisKey);
    }

    @Test
    public void test14() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "2");
        m.put("2", "1");


        Map<String, Boolean> m2 = m
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, t -> Objects.equals(t.getValue(), "1")));

        System.out.println(m2);
    }

    /**
     * 泛型测试
     */
    @Test
    public void test15() {
        //List<String>[] ls = new ArrayList<String>[10];
        List<String>[] ls = new ArrayList[10];
    }

    /**
     * see https://blog.csdn.net/qq_37960603/article/details/82682104
     */
    @Test
    public void test16() {
        List<String>[] lsa = new List[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        String s = lsa[1].get(0);
    }

    @Test
    public void test17() {
        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.

        // 由于通配符的原因 最后取出的数据要做显式的转换的
        String s = (String) lsa[1].get(0); // Run time error, but cast is explicit.
        System.out.println(s);
    }

    @Test
    public void test18() {
        List<Long> list = Arrays.asList(1l, 2l, 3l);
        System.out.println(list.stream().anyMatch(u -> u == 1l));
    }

    @Test
    public void test19() {
        List<String> list = new ArrayList();
        list.add("abc");
        list.add("abcd");
        list.add("abcde");
        list.add("ABC");
        list.add("ABCD");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            //System.out.println(iterator.next());
            if (item.equals("ABCD")) {
                list.remove(item);
                System.out.println("remove");

            } else {
                System.out.println(item);
            }
        }
        System.out.println(list.toString());
    }

    @Test
    public void test20() {
        List<String> list = new ArrayList();
        list.add("abc");
        list.add("abcd");
        list.add("abcde");
        list.add("ABC");
        list.add("ABCD");

//        Iterator<String> iterator = Iterators.cycle(list);
//
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            //System.out.println(iterator.next());
//            if (item.equals("ABCD")) {
//                iterator.remove();
//                System.out.println("remove");
//
//            } else {
//                System.out.println(item);
//            }
//        }
//        System.out.println(list.toString());

    }

    private static long ip2Long(String ip) {
        String[] segs = StringUtils.split(ip, '.');
        long result = 0L;
        result |= Integer.parseInt(segs[0]) << 24;
        result |= Integer.parseInt(segs[1]) << 16;
        result |= Integer.parseInt(segs[2]) << 8;
        result |= Integer.parseInt(segs[3]);
        return result;
    }

    @Test
    public void test21() {
        System.out.println(ip2Long("127.0.0.1"));
        System.out.println(ip2Long("127.0.0.2"));

    }

    @Test
    public void test22() {

        LocalDateTime tdt = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0));

        long mtime = tdt.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(mtime/1000);

        LocalDateTime ndt = LocalDateTime.now();
        long mtime2 = ndt.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(mtime2/1000);

        System.out.println(ndt.isAfter(tdt));
    }

}

