package com.dsa.linked_list;



public class DoubleLinkedList{
    private class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }

        Node (int data, Node prev,Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    private long size;

    public DoubleLinkedList(){
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public long getSize() {
        return size;
    }

    public Node getTail() {
        return tail;
    }

    public void addFirst(int data){
        //creating new node
        Node node = new Node(data);
       
       node.next = head;

       head = node;

       if(tail==null){
        tail = head;
       }

        size++;
    }

    public void addLast(int data){
        //creating new node
        Node node = new Node(data);

        tail.next = node;
        tail = node;

        if(head==null){
            head = tail;
        }

        size++;
    }

    public void print(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    public static void main(String[] args) {
        //creating instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        //displaying list
        list.print();

        //now adding from last
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);

        list.print();

        //printing size of list
        System.out.println(list.getSize());

        //printing tail
        System.out.println("Tail: "+list.getTail().data);

    }

}