package com.dsa.queue;

import java.util.Arrays;

public class Queue<T> {

    // Declaring an array for storing elements
    private Object[] arr;

    // Size of the queue (number of elements currently stored)
    private int size;

    private int front;

    private int rear;

    // Default constructor for a growable queue
    public Queue() {
        this.arr = new Object[10]; // Initial capacity
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // Enqueue (Insert): Adds an element to the rear of the queue
    public void enqueue(T x) {
        if (isFull()) {
            grow(); // Increase the capacity if the array is full
        }

        arr[rear] = x;
        rear++;
        size++;
    }

    // Dequeue (Delete): Removes and returns the element from the front of the queue
    public T dequeue()  {


        @SuppressWarnings("unchecked")
        T element = (T) arr[front];

        // Shifting all elements of the array to the left by 1 position
        for (int i = 0; i < rear - 1; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        size--;

        return element;
    }

    // Peek: Returns the element at the front of the queue without removing it
    public T peek() {
        @SuppressWarnings("unchecked")
        T element = (T) arr[front];
        return element;
    }

    // size: returns the size of queue
    public int size() {
        return this.size;
    }

    // isEmpty: Checks if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull: Checks if the internal array is full
    private boolean isFull() {
        return rear == arr.length;
    }

    // Grow: Doubles the capacity of the internal array
    private void grow() {
        int newCapacity = arr.length * 2;
        arr = Arrays.copyOf(arr, newCapacity);
    }
}
