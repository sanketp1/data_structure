package com.dsa.linked_list;

public class ReverseNodesInKGroup {



    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5};
        ListNode head = LinkedListUtils.build(nodes);
       ListNode reverse = reverse(head, 2);
       LinkedListUtils.print(reverse);
    }

    public static  ListNode reverse(ListNode head, int k){
        if(head == null) return null;

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(k>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        ListNode prevTail = prev;

        while(prevTail.next!=null){
            prevTail = prevTail.next;
        }

        prevTail.next = next;

        return prev;
    }



}
