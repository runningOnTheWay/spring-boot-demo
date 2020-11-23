package cn.newbie.algorithm;

import java.util.List;


public class LinkedListCreator {
    //构建函数
    public ListNode createLinkedList(List<Integer> list){
        if (list.isEmpty()){
            return null;
        }
        ListNode headNode = new ListNode(list.get(0));
        ListNode tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.setNext(tempNode);
        return headNode;
    }

    //测试方便的打印函数
    public void printList(ListNode node){
        while (node != null){
            System.out.print(node.getVal());
            System.out.print(" ");
            node = node.getNext();
        }
        System.out.println();
    }
}
