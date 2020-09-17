package cn.newbie.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 时间复杂度O(n^2)
    // 空间复杂度O(1)
    public int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            int i_num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int j_num = nums[j];
                if (j_num == target - i_num) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }


    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && numsMap.get(target - nums[i]) != i) {
                return new int[] {i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    public int[] twoSum3(int[] nums, int target){
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(target - nums[i])) {
                numsMap.put(nums[i], i);
            }
            return new int[] {i, numsMap.get(target - nums[i])};
        }

        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1 != null ) {
            l1Stack.push(l1.val);

            l1 = l1.next;
        }
        while (l2 != null ) {
            l2Stack.push(l2.val);

            l2 = l2.next;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (l1Stack.size() != 0 || l2Stack.size() != 0) {
            int sum = 0;
            if (l1Stack.size() != 0 && l2Stack.size() != 0) {
                sum = l1Stack.pop() + l2Stack.pop() + carry;

                carry = sum / 10;
                sum = sum % 10;

                cur.next = new ListNode(sum);
                cur = cur.next;
                continue;
            }

            if (l1Stack.size() != 0 && l2Stack.size() == 0) {
                sum = l1Stack.pop() + carry;

                carry = sum / 10;
                sum = sum % 10;

                cur.next = new ListNode(sum);
                cur = cur.next;
                continue;
            }
            if (l1Stack.size() == 0 && l2Stack.size() != 0) {
                sum = l2Stack.pop() + carry;

                carry = sum / 10;
                sum = sum % 10;

                cur.next = new ListNode(sum);
                cur = cur.next;
                continue;
            }



        }
        return pre.next;
    }

    public ListNode addTwoNumbersStack1(ListNode l1, ListNode l2) {

        // 定义一个新链表 用来存储计算结果，默认创建的是带头节点所以默认是0
        ListNode temp = new ListNode(0);
        // 记住第一个节点
        ListNode node = temp;
        // 进位 也就是 如果相加的是大于10 我们在下一位的时候加1，默认是0
        int carry = 0;
        // 使用栈 接收l1链表的数据
        Stack<Integer> stackL1 = new Stack<>();
        // 使用栈 接收l2链表的数据
        Stack<Integer> stackL2 = new Stack<>();
        // 对两个两个链表进行遍历,并且加入栈中
        while (l1 != null || l2 != null) {
            // 判断l1链表是否为空 如果不为空则指向下一个节点
            if (l1 != null) {
                stackL1.push(l1.val);
                l1 = l1.next;
            }
            // 判断l2链表是否为空 如果不为空则指向下一个节点
            if (l2 != null) {
                stackL2.push(l2.val);
                l2 = l2.next;
            }
        }
        // 遍历两个栈
        while (!stackL1.empty() || !stackL2.empty()) {
            // 如果stackL1栈不为null 就弹栈，否则为0
            int x = (!stackL1.empty()) ? stackL1.pop() : 0;
            // 如果stackL2栈不为null 就弹栈，否则为0
            int y = (!stackL2.empty()) ? stackL2.pop() : 0;
            // 因为都是个位数相加 所以最大指是等于19的 ，得把进位加上
            int sum = x + y + carry;
            // 把得出的结果存入链表中，但是必须跟10取余 只要不管是否大于等于10 都会取得个位数的
            temp.next = new ListNode(sum % 10);
            // 指向下一个节点
            temp = temp.next;
            // 求进位 如果大于10 即可以求出进位为1 否则就是0
            carry = sum / 10;
        }
        // 有可能存在一种情况 但两个链表最后的值计算 大于等于10 的情况且两个链表都为空了 ，得把进位放入最后一个节点
        if (carry > 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
        // 因为默认创建的是带头节点 所以我们要从temp链表的下一个开始
        return node.next;
    }

    public static void main(String[] args) {
        Test t = new Test();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
//        ListNode r3 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        r1.next = r2;
//        r2.next = r3;

        ListNode listNode = t.addTwoNumbersStack1(l1, r1);
        while (listNode != null){
            System.out.printf(listNode != null ? String.valueOf(listNode.val) : "");
            listNode = listNode.next;
        }
        System.out.println();
        ListNode listNode1 = t.addTwoNumbersStack(l1, r1);
        while (listNode1 != null){
            System.out.printf(listNode1 != null ? String.valueOf(listNode1.val) : "");

            listNode1 = listNode1.next;
        }
        System.out.println();
        ListNode listNode2 = t.addTwoNumbers(l1, r1);
        while (listNode2 != null){
            System.out.printf(listNode2 != null ? String.valueOf(listNode2.val) : "");
            listNode2 = listNode2.next;
        }
    }
}
