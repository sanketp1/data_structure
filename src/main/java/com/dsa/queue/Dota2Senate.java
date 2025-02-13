package com.dsa.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Dota2Senate {

    public static void main(String[] args) {
        String senate = "RRR";
        String result = predictPartyVictory(senate);
        System.out.println(result);
    }

    public static String  predictPartyVictory(String senate) {
        ArrayDeque<Integer> radiant = new ArrayDeque<>();
        ArrayDeque<Integer> dire = new ArrayDeque<>();

        int n = senate.length();

        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                radiant.add(i);
            }else{
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() > dire.peek()) {
                dire.add(n++);
            }else{
                radiant.add(n++);
            }

            radiant.poll();
            dire.poll();
        }

        if(radiant.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
    }

}
