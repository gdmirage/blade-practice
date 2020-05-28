package com.blade.practice.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Blade
 * @date 2019-06-27 14:02:17
 **/
public class HashSetDemo {

    public static void main(String[] args) {
        testSet();
    }

    private static void testSet() {

        Set<Boolean> set = new HashSet<>();
        set.add(null);
        for (int i =0; i < 10; i++) {
            Boolean a = false;
            if (i % 2 == 0) {
                a = true;
            }
            set.add(a);

            System.out.println(set);
        }

        System.out.println(set.contains(true));
        System.out.println(set.contains(false));
    }
}
