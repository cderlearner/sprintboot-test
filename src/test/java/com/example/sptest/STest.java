package com.example.sptest;

import com.google.common.base.Joiner;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;

public class STest {

//    public static void main(String[] args) throws Exception{
//        Options options = new OptionsBuilder().include(StringBuilderTest.class.getSimpleName())
//                .output("/Users/linjiaxing/Downloads/Benchmark.log").forks(2).build();
//        new Runner(options).run();
//    }


//    public static void main(String[] args) {
//        String str = Joiner.on(",").join(Arrays.asList("a", "b", "c")); 
//        String[] ary = str.split(",");
//         System.out.println(ary.length);
//    }

    public static void main(String[] args) {
//        String sql = "select access_token,refresh_token,client_id,created,updated,userid,auths,expires_in,type,id from oauth_token where access_token = ?";
//
//        String[] strs = sql.split(",");
//        System.out.println(strs.length);

        String[] str2 = "a,b,c,,1,2".split(",");
        System.out.println(str2.length);

//        String str = "a,b,c,,"; 
//        String[] ary = str.split(",");
//         System.out.println(ary.length);



    }
}
