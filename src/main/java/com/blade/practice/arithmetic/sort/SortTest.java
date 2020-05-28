package com.blade.practice.arithmetic.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/27 20:36
 */
public class SortTest {

    public static void main(String[] args) {
        List<Integer> list = getRandomList(10);
//        System.out.println(list);
//        sort(list);
//        bubbleSort(list);
        quickSort(list);
    }

    private static List<Integer> getRandomList(int length) {

        List<Integer> randomList = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            randomList.add((int)(Math.random() * 100));
        }

        return randomList;
    }

    /**
     * jdk排序
     * @param integerList
     */
    private static void sort(List<Integer> integerList) {
        integerList.sort(null);
//        Collections.sort(integerList);
        System.out.println(integerList);
    }

    /**
     * 冒泡排序法
     * @param integerList
     */
    private static void bubbleSort(List<Integer> integerList) {
        BubbleSort.bubbleSort(integerList);

//        Integer[] nums = new Integer[integerList.size()];
//        integerList.toArray(nums);
//        BubbleSort.bubbleSort(nums);
//        BubbleSort.answer(nums);

    }

    private static void quickSort(List<Integer> integerList) {
        Integer[] nums = new Integer[integerList.size()];
        integerList.toArray(nums);
        int length = nums.length;
        int start = 0, end = length - 1;
        QuickSort.quickSort(nums, start, end);
    }

}
