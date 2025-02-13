package com.dsa.linked_list;

public class LinkedListUtils {

    public static ListNode build(int[] nodes){
        if(nodes.length<=0) return null;

        ListNode head = new ListNode(nodes[0]);
        ListNode temp = head;
        int n = nodes.length;
        int k = 1;

        while(k<n){
            temp.next = new ListNode(nodes[k]);
            temp = temp.next;
            k++;
        }

        return head;
    }

    public static void print(ListNode head){
        ListNode temp = head;

        while(temp!=null){
            System.out.print(temp.val+"-->");
            temp = temp.next;
            if(temp == null){
                System.out.print("NULL");
            }
        }

        System.out.println();

    }

}
