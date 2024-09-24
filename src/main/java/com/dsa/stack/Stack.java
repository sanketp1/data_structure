package com.dsa.stack;

public class Stack {

    private int[] arr;
    private int size;
    private int top;

    public Stack(int size) {
        this.size = size;
        this.arr = new int[this.size];
        //initially pointing at index -1
        this.top = -1;
    }

    //getting size of stack
    public int getSize() {
        return size;
    }

    //operations
    
    //Method 1: push
    public void push(int x) throws  Exception{
        if(top==size-1){
            throw  new Exception("[Stackoverflow] Stack is full");
        }
        //incrementing top by 1
        top++;
        arr[top] = x;
    }

    //Method 2: pop
    public int pop() throws  Exception{
        if(top==-1){
            throw  new Exception("Stack is already empty.");
        }

        //reducing top by one and before that making that index of array as 0
        int element = arr[top];

        arr[top] = 0;

        top--;

        return element;


    }

    //Method 3: peek
    public int peek(int index) throws Exception{
        if(index>size-1){
            throw new Exception("Index is out of bound");
        }
        return arr[index];
    }

    //Method 4: stackTop
    public int stackTop(){
        return arr[this.top];
    }

    //Method 5: isEmpty
    public boolean isEmpty(){
        return this.top == -1;
    }

    //Method 6: isFull
    public boolean isFull(){
        return (this.top + 1) == size;
    }

    //Method 7: print
    public void print(){
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]+" ");
        }
        System.err.println("");
    }


    public static void main(String[] args) throws  Exception {
        //creating instance of Stack
        Stack stack = new Stack(5);

        //checking stack is empty
        System.out.println("Is stack empty: "+(stack.isEmpty()?"YES":"NO"));

        //pushing 5 elements
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //checking is stack full or not?
        System.out.println("After insertion of 5 elements");
        System.out.println("Is stack full: "+(stack.isFull()?"YES":"NO"));


        //printing stack
        stack.print();

        //trying push one more element 
        //expecting it will throw StackOverflow exception
        // stack.push(6);


        //poping element from stack
        int element = stack.pop();
        System.out.println("Popped Element: "+element);

        //printing stack again
        System.out.println("After popping 5 from stack");
        stack.print();

        //making stack empty by popping 4 more element from stack
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        //checking now is stack empty or not?
         System.out.println("Is stack empty: "+(stack.isEmpty()?"YES":"NO"));

        //trying to pop one more time 
        //expecting it will throw Stack is already empty
        stack.pop();

        


        



    }

    
    
}
