package com.blade.practice.jvm;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/20 11:15
 */
public class Stack {

    public static void main(String[] args) {
        digui();
    }

    private static void digui() {
        System.out.println("1");
        // 会报 StackOverflowError
        // 递归没有跳出操作，栈深度不够
        digui();
    }
}
