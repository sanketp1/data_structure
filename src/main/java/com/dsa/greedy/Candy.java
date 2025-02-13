package com.dsa.greedy;

import java.util.HashMap;
import java.util.Map;

public class Candy {
    private static class Node{
        public int prev;
        public int next;

        Node(){}

        Node(int prev, int next){
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node("+this.prev+", "+this.next+")";
        }
    }
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];

        // Step 1: Assign 1 candy to each child
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 2: Left-to-right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }



        // Step 3: Right-to-left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Calculate the total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;

    }

}
