package com.blade.practice.arithmetic.sort;

import java.util.Arrays;
import java.util.List;

/**
 * TODO:
 * 冒泡排序法
 * 冒泡排序算法的原理如下：
 * <p>
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <p>
 * 2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * <p>
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @author Blade
 * @date 2019/4/27 19:07
 */
public class BubbleSort {

    public static List<Integer> bubbleSort(List<Integer> integerList) {
        System.out.println(String.format("before sort list: %s", integerList));

        int length = integerList.size();

        int before, after, temp;
        for (int i = 0; i < length; i++) {

            for (int j = 1; j < length - i; j++) {
                before = integerList.get(j - 1);
                after = integerList.get(j);
                if (before > after) {
                    System.out.println(String.format("compare before : %s  and after : %s", before, after));
                    temp = after;
                    integerList.set(j, before);
                    integerList.set(j - 1, temp);
                    System.out.println(String.format("sorting list : %s ", integerList));
                }
            }
        }

        System.out.println(String.format("after sort list: %s", integerList));

        return integerList;
    }

    public static void bubbleSort(Integer[] nums) {
        System.out.println(String.format("before sort nums: %s", Arrays.asList(nums)));
        int length = nums.length;

        int before, after, temp;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                before = nums[j - 1];
                after = nums[j];
                if (before > after) {
                    temp = before;

                    nums[j - 1] = after;
                    nums[j] = temp;

                }
            }
        }

        System.out.println(String.format("after sort nums: %s", Arrays.asList(nums)));
    }

    public static void answer(Integer[] nums) {
        System.out.println(String.format("before sort nums: %s", Arrays.asList(nums)));
        int i, j;

        int time = nums.length;
        int temp;

        for (i = 0; i < time; i++) {
            for (j = 1; j < time - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(String.format("after sort nums: %s", Arrays.asList(nums)));
    }
}
