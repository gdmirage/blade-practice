package com.blade.practice.jdk8.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 针对选苹果进行代码演进，为后面理解lambda表达式进行铺垫
 * Created by Administrator on 2019/5/20.
 */
public class FilterApple {

    /**
     * 选绿色的苹果
     *
     * @param inventory
     * @return List<Apple>
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 选指定颜色的苹果
     *
     * @param inventory
     * @param color
     * @return List<Apple>
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 增加重苹果与轻苹果的判断，大于150为重
     * 因为增加重量的条件，需要增加一个选择条件
     * 深思：如果筛选的条件很多，这绝对不是一个很好的方式
     *
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return List<Apple>
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeigth() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 把筛选条件进行封装
     *
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 使用匿名类
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterApplesByClass(List<Apple> inventory) {
        List<Apple> result = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        return result;
    }

    /**
     * 使用Lambda表达式
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterApplesByLambda(List<Apple> inventory) {
        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        return result;
    }

    /**
     * lambda 各种比较
     * @param inventory
     */
    public static void sortApples(List<Apple> inventory) {
        // 比较方式1
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeigth().compareTo(o2.getWeigth());
            }
        });

        // 比较方式2
        inventory.sort((Apple a1, Apple a2) -> a1.getWeigth().compareTo(a2.getWeigth()));

        // 比较方式3
        inventory.sort((a1, a2) -> a1.getWeigth().compareTo(a2.getWeigth()));

        // 比较方式4
        inventory.sort(Comparator.comparing(apple -> apple.getWeigth()));

        // 比较方式5
        inventory.sort(Comparator.comparing(Apple::getWeigth));

        inventory.sort(Comparator.comparing(Apple::getWeigth)
                .reversed() // 倒序
                .thenComparing(Apple::getColor)); // 如果重量一样，增加颜色比较
    }
}
