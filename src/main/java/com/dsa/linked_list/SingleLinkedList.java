package com.dsa.linked_list;



public class SingleLinkedList implements  LinkedList {
    //node for singly linked list
    private class Node{
       int data;
       Node next;

       public Node(int data){
            this.data = data;
            this.next = null;
       }

       public Node(int data, Node next){
            this.data = data;
            this.next = next;
       }
        
    }

    private Node head;
    private Node tail;
    private int size;
    


    public SingleLinkedList(){
        this.size = 0;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new SingleLinkedList();

        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.insertFirst(50);

        //displaying the linked list
        linkedList.print();
        System.out.println("Size : "+linkedList.size());

        //inserting elements from last
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);

        //displaying linked list
        linkedList.print();

        //inserting element at index 1
        linkedList.insertAt(100, 1);

        linkedList.print();

        //getting element of specified index
        int idx = 1;
        int ele = linkedList.getElement(idx);
        System.err.println("Got "+ele+" at index of "+idx);

        //finding element and returning index of that element in the linked list 
        int found = linkedList.findElement(10);
        System.out.println(10+ " found at index "+found);

        //replacing element present at index 3 
        linkedList.replace(98, 3);
        //printing new linked list
        linkedList.print();   

        //deleting first element
        int deleted = linkedList.deleteFirst();     
        System.out.println(deleted+ " deleted successfully.");
        linkedList.print();

    }

    

     @Override
    public int getHead() {
        return head!=null?head.data:Integer.MIN_VALUE;
    }

    @Override
    public int getTail() {
        return tail!=null?tail.data:Integer.MIN_VALUE;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void insertFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;

        if(tail==null){
            tail = head;
        }

        //incrementing size 
        size++;
    }

    @Override
    public void insertLast(int element) {
       if(tail==null){
            insertFirst(element);
            return;
       }

       Node newNode = new Node(element);
       tail.next = newNode;
       tail = newNode;

        //incrementing size 
        size++;
    }

    @Override
    public void insertAt(int element, int index) {
        
        //incase if index is 0
        if(index == 0){
            insertFirst(element);
            return;
        }

        //incase if index is equal to size then inserting it to last
        if(index==size-1){
            insertLast(element);
            return;
        }

        Node temp = head;

        for(int i=0;i<index-1; i++){
            temp = temp.next;
        }

        //creating new node 
        Node newNode = new Node(element,temp.next);
        temp.next = newNode;
        

        size++;
    }

    @Override
    public int getElement(int index) {
       Node temp = head;
       for (int i = 0; i < index; i++) {
           temp = temp.next;
       }
       return temp.data;
    }

    @Override
    public int findElement(int element) {
        
        Node temp = head;
        int idx = 0;
        while(temp!=null){
            if(temp.data == element){
                return idx;
            }

            temp = temp.next;
            idx++;
        }


        //incase if not found
        return -1;
    }

    @Override
    public void replace(int newElement, int index) {
       Node temp = head;
       for(int i=0; i<index; i++){
            temp = temp.next;
       }

       
       temp.data = newElement;
    }

    @Override
    public int deleteFirst() {
        Node temp = head;
        head = temp.next;
        return temp.data;
    }



    @Override
    public int deleteAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void print() {
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.err.println();
    }

    @Override
    public int deleteLast() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}

interface  LinkedList{

    public int getHead();

    public int getTail();

    public int size();

    public void insertFirst(int element);

    public void insertLast(int element);

    public void insertAt(int element, int index);

    public int getElement(int index);

    public int findElement(int element);

    public void replace(int newElement,int index);

    public int deleteFirst();

    public int deleteLast();

    public int deleteAt(int index);

    public void print();

}