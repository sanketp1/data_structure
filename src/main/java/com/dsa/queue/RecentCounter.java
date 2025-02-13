package com.dsa.queue;

import java.util.PriorityQueue;

public class RecentCounter {

    private PriorityQueue<Integer> queue;

    public RecentCounter(){
        queue = new PriorityQueue();
    }

    public int ping(int t){
        queue.add(t);
        while(!queue.isEmpty() && (t-3000) > queue.peek()){
            queue.poll();
        }
        return queue.size();
    }
}
