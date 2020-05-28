package com.blade.practice.jdk8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Administrator on 2019/5/20.
 */
public class LambdaTest {

    public static void main(String[] args) throws Exception{
//        aa();
        testLambdaInterface();
    }

    public static void testLambdaInterface() {
        TestLambdaInterface tf = (x, y) -> {
            System.out.println(x + y);
            return x+y;};
        tf.add(1, 2);

        TestLambdaInterface tf2 = (x, y) -> {
            System.out.println(x * y);
            return x * y;
        };

        tf2.add(3, 6);
    }

    public static String processFile() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader("F:\\data.txt"))){
            return br.readLine();
        }
    }

    public static void aa() throws Exception {
        System.out.println(processFile()) ;
    }
}
