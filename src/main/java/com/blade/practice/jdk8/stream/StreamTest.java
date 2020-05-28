package com.blade.practice.jdk8.stream;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Blade
 * @date 2019-08-13 17:03:48
 **/
public class StreamTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        sortDish();
        sortInteger();
    }

    private static void test1() {
        List<Dish> menu = Dish.getMenu();

        List<String> list = menu.stream().filter(dish -> dish.getCalories() > 300) // 筛选高热量的菜单
                .map(Dish::getName) // 获取菜名
                .limit(3)// 获取前3条
                .collect(Collectors.toList());

        System.out.println(list);
    }

    private static void sortDish() {
        List<Dish> dishes = Dish.getMenu();
        System.out.println("1:" + JSON.toJSONString(dishes));

        dishes.forEach(dish -> {
            System.out.println("1->" + dish.getCalories());
        });

        dishes.sort((d1, d2) -> {
            return d1.getCalories() > d2.getCalories() ? 0 : 1;
        });

        Collections.sort(dishes, (d1, d2) -> {
            return d1.getCalories() > d2.getCalories() ? 1 : (d1.getCalories() == d2.getCalories() ? 0 : -1);
        });

        dishes.forEach(dish -> {
            System.out.println("2->" + dish.getCalories());
        });
    }

    private static void sortInteger() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random(i);
            list.add(i * random.nextInt(10));
        }

        System.out.println(list);

//        Collections.sort(list);

        list.sort((i1, i2) -> {
            return i1 > i2 ? 8 : -8;
        });

        System.out.println(list);
    }
}
