package com.dsa.heaps;

public class MinHeap{

    //To store array of element in heap
    private final int[] heapArray;

    //max size of the heap
    private final int capacity;

    //current number of element in the heap
    private int current_heap_size;

    //constructor
    public MinHeap(int n){
        this.capacity = n;
        this.heapArray = new int[this.capacity];
        this.current_heap_size = 0;
    }

    //swapping using reference
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Get the parent index of the given index
    private int parent(int key){
        return (key-1)/2;
    }

    //Get the left child index for the given index
    private int left(int key){
        return (2*key)+1;
    }

    //Get the right child index for the given index
    private int right(int key){
        return (2*key) - 1;
    }

    //Insert a new key
    public boolean insertKey(int key){
        if(this.current_heap_size == capacity){
            return false;
        }

        int i = this.current_heap_size;
        heapArray[i] = key;
        this.current_heap_size++;

        //Fix the min heap property if it is violated
        while(i != 0 && heapArray[i] < heapArray[parent(i)]){
            swap(heapArray,i, parent(i));
        }

        return true;
    }

    //Decrease value of given key to new value
    //it is assumed that new value is smaller 
    //than heapArray[key]

    public void decreaseKey(int key, int newValue){
        heapArray[key] = newValue;

        while( key != 0 && heapArray[key] < heapArray[parent(key)]){
            swap(heapArray, newValue, newValue);
            key = parent(key);
        }
    }

    //Returns the minimum key (key at root) from the min heap
    public int getMin(){
        return heapArray[0];
    }

    //Method to remove minimum element 
    //(or root) from min heap
    public int extractMin(){
        if(current_heap_size <= 0){
            return Integer.MAX_VALUE;
        }

        if(current_heap_size == 1){
            current_heap_size--;
            return heapArray[0];
        }

        //store the minimum value,
        //add remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size-1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }

    //This method deletes key at the
    //given index. It first reduced value
    //to minus infinite, then calls extractMin()
    public void deleteKey(int key){
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    //A recursive method to heapify a subtree
    //with the root at given index
    //This method assumes that subtrees
    //are already heapified
    private void MinHeapify(int key){
        int l = left(key);
        int r = right(key);

        int smallest = key;

        if(l < current_heap_size && heapArray[l] < heapArray[smallest]){
            smallest = l;
        }

        if(r < current_heap_size && heapArray[r] < heapArray[smallest]){
            smallest = r;
        }

        if(smallest != key){
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }

    }

    //increase value of given key to new value
    //It is assumed that new value is greater
    //than heapArray[key]
    //Heapify from the given key
    public void increaseKey(int key, int newValue){
        heapArray[key] = newValue;
        MinHeapify(key);
    }

    //changes value on a key
    public void changeValueOnAKey(int key, int newValue){
        if(heapArray[key] == newValue) return;

        if(heapArray[key] < newValue) {
            increaseKey(key, newValue);
        }else{
            decreaseKey(key, newValue);
        }
    }


    public static void main(String[] args){

        //testing min heap
        MinHeap h = new MinHeap(11);
        h.insertKey(3); 
        h.insertKey(2); 
        h.deleteKey(1); 
        h.insertKey(15); 
        // h.insertKey(5); 
        // h.insertKey(4); 
        // h.insertKey(45); 
        // System.out.print(h.extractMin() + " "); 
        // System.out.print(h.getMin() + " "); 
          
        // h.decreaseKey(2, 1); 
        // System.out.print(h.getMin()); 
    }

}