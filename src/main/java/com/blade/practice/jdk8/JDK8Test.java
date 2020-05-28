package com.blade.practice.jdk8;

import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/24 23:54
 */
public class JDK8Test {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        testStream();
    }

    private static void testStream() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        List<Integer> list1 = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 3;
            }
        }).collect(Collectors.toList());

        List<Integer> list2 = list.stream().filter((x) ->
                x > 3
        ).collect(Collectors.toList());

        System.out.println(list2);
    }
}
