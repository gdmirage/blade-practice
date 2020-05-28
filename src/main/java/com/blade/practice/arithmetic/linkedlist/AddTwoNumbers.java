package com.blade.practice.arithmetic.linkedlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author blade
 * 2019/10/21 16:42
 */
public class AddTwoNumbers {

    private static ListNode listNode1 = new ListNode(0);
    private static ListNode listNode2 = new ListNode(0);

    /**
     * 分析：
     * 数字342 对应着 链表list，的位置: 0, 1, 2 分别的对应着 2, 4, 3
     *
     * @param args 参数
     */
    public static void main(String[] args) throws IOException {
        init();
        methodOne();
//        System.in.read();
    }


    private static void methodOne() {
        Integer p1 = 0;
        Integer p2 = 0;
        // 进位
        Integer jinWei = 0;

        ListNode listNodeTemp1 = listNode1;
        ListNode listNodeTemp2 = listNode2;

        ListNode result = new ListNode(0);
        ListNode tempLink = result;

        while (listNodeTemp1 != null || listNodeTemp2 != null || jinWei != 0) {
            // 重新初始化，清到上一次循环的数据
            p1 = 0;
            p2 = 0;

            if (null != listNodeTemp1) {
                p1 = listNodeTemp1.val;
                listNodeTemp1 = listNodeTemp1.next;
            }

            if (null != listNodeTemp2) {
                p2 = listNodeTemp2.val;
                listNodeTemp2 = listNodeTemp2.next;
            }
            int num = p1 + p2 + jinWei;
            System.out.println("===========");
            System.out.println(num);
            System.out.println(num%10);
            System.out.println(num/10);
            System.out.println("===========");

            tempLink.next = new ListNode(num%10);
            // 进位的数像下一位加1
            jinWei = num/10;

            tempLink = tempLink.next;
        }

        System.out.println("result===========");
        printListNode(result.next);
    }

    private static void init() {
        System.out.println("list1=============");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

        list2Link(list1, listNode1);
        printListNode(listNode1);

        System.out.println("list2=============");
        List<Integer> list2 = new ArrayList<>();

        list2.add(9);

        list2Link(list2, listNode2);
        printListNode(listNode2);
    }

    private static void list2Link(List<Integer> list, ListNode topNode) {
        for (int i = 0; i < list.size(); i++) {
            topNode.next = new ListNode(list.get(i));
            topNode = topNode.next;
        }
    }

    private static void printListNode(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
