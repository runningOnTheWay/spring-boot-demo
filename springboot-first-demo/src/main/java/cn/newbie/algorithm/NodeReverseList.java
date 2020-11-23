package cn.newbie.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description :
 *
 * <p>
 * 修改历史:                                  <br>
 * 修改日期           修改人员         版本       修改内容<br>
 * -------------------------------------------------<br>
 * 2020/9/18 0018  19:23  tianpei       1.0      初始化创建<br>
 * </p >
 *
 * @author tianpei
 * @version 1.0
 * @since JDK1.8
 */
public class NodeReverseList {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
            continue;
        }
        return print;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultPre = new ListNode(-1);
        ListNode result = resultPre;
        Integer compareVal = null;
        while (head != null) {
            if (compareVal == null) {
                compareVal = head.val;
                result.next = head;
                result = result.next;
                head = head.next;
                continue;
            }
            if (compareVal == head.val) {
                result.next = null;
                head = head.next;
                continue;
            }
            if (compareVal.intValue() != head.val) {
                compareVal = head.val;
                result.next = head;
                result = result.next;
            }
            head = head.next;
        }
        return resultPre.next;
    }
    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
//        ListNode node = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
//
//        ListNode res = reverseList(node);
//        linkedListCreator.printList(res);

//        ListNode node1 = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
//        ListNode node2 = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4));
//        ListNode node1 = null;
//        ListNode node2 = null;
//        ListNode listNode = mergeTwoLists(node1, node2);
//        ListNode node2 =  linkedListCreator.createLinkedList(Arrays.asList(1, 2,2,2, 3,3, 4, 4,4));
//        ListNode listNode = deleteDuplicates(node2);
//        linkedListCreator.printList(listNode);
        System.out.println(8 % 6);
        System.out.println(8/3);
    }
}
