package com.dsa.queue;

public class Queue{

    //declaring an array for storing element 
    private int[] arr;

    //size of the queue
    private int size;

    private int front;

    private int rear;
    
    public Queue(int size){
        this.size = size;
        this.front = 0;
        this.rear = 0;

        //intializing an array of provided size
        this.arr = new int[this.size];

    }

    //operating related to queue

    //enqueue (Insert): Adds an element to the rear of the queue.
    public void enqueue(int x) throws Exception{
        if(isFull()){
            throw new Exception("Queue is overflow.");
        }

        //inserting element in the queue
        arr[rear] = x;
        //incrementing rear by 1
        rear++;
    }

    //dequeue (Delete): Removes and returns the element from the front of the queue.
    public int dequeue() throws  Exception {
        if(isEmpty()){
            throw new Exception("Queue is underflow");
        }

        int element = arr[front];
        
        //shifting all element of array to right by 1 position 
        //as current front element is going to delete
        for(int i = 0; i<rear-1; i++){
            arr[i] = arr[i+1];
        }

        //decrementing rear by 1
        rear--;

        return element;
        
    }

    //Peek: Returns the element at the front of the queue without removing it.
    public int peek() throws Exception{

        if(isEmpty()){
            throw  new Exception("No element is inserted yet.");
        }

        //returning element front 
        return arr[front];
    }

    //isEmpty: Checks if the queue is empty.
    public boolean isEmpty(){
        return rear == front;
    }

    //method printing queue
    public void print(){
        System.out.print("[");
        for(int i = 0; i<rear;i++){
            if(i==rear-1){
                System.out.print(arr[i]);
                continue;
            }
            System.err.print(arr[i]+", ");
        }
        System.err.print("]\n");
    }

    //isFull: Checks if the queue is full.
    public boolean isFull(){
        return rear == size;
    }

    public static void main(String[] args) throws  Exception {
        

        //creating instance of queue
        Queue queue = new Queue(5);

        //inserting element in queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        //printing queue now
        queue.print();

        //dequeuing element 
        int ele1 = queue.dequeue();

        System.out.println("Dequeued element: "+ele1);

        System.out.println("After dequeuing element from the queue");
        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.print();

        queue.dequeue();
        queue.print();

        //trying to dequeue again
        //should throw exception that is underflow
        // queue.dequeue();
        /*
         * OUTPUT:
         *  Exception in thread "main" java.lang.Exception: Queue is underflow
            at com.dsa.queue.Queue.dequeue(Queue.java:42)
            at com.dsa.queue.Queue.main(Queue.java:129)
         */

        //getting peek element from the queue
        int peek = queue.peek();
        System.out.println("Peek element: "+peek);

    }
}
