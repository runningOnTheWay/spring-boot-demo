package cn.newbie.algorithm;

import java.util.Arrays;

public class TestListNode {

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return null;
        }
        ListNode newListNode= new ListNode(0);
        newListNode.next = head;
        ListNode p= newListNode;
        while(newListNode.next!=null){
            if(newListNode.next.val==val){
                newListNode.next = newListNode.next.next;
            }else{
                newListNode= newListNode.next;
            }
        }
        return p.next;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        ListNode node = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        removeElements(node, 3);
    }
}
