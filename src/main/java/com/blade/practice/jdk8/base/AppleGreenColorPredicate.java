package com.blade.practice.jdk8.base;

/**
 * Created by Administrator on 2019/5/20.
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
