package com.blade.practice.jdk8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blade
 * @date 2019-08-13 16:54:07
 **/
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    public static List<Dish> getMenu() {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", false, 800, Type.MEAT));
        menu.add(new Dish("beef", false, 700, Type.MEAT));
        menu.add(new Dish("chicken", false, 400, Type.MEAT));
        menu.add(new Dish("french fries", true, 530, Type.OTHER));
        menu.add(new Dish("rice", true, 350, Type.OTHER));
        menu.add(new Dish("season fruit", true, 120, Type.OTHER));
        menu.add(new Dish("pizza", true, 550, Type.OTHER));
        menu.add(new Dish("prawns", false, 300, Type.FISH));
        menu.add(new Dish("salmon", false, 450, Type.FISH));
        return menu;
    }
}
