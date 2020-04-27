package com.example.sptest;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class STest {

    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder().include(StringBuilderTest.class.getSimpleName())
                .output("/Users/linjiaxing/Downloads/Benchmark.log").forks(2).build();
        new Runner(options).run();
    }
}
