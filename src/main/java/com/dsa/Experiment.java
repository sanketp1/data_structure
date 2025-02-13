package com.dsa;

import java.util.stream.IntStream;
import java.util.*;

class Worker implements Comparable<Worker> {
    int cost;
    int index;

    public  Worker(){}

    public Worker(int cost, int index){
        this.cost = cost;
        this.index = index;
    }

    @Override
    public int compareTo(Worker o) {
        return o.cost;
    }
}

public class Experiment {

    public static void main(String[] args) {
//        String encryptedMessage = "seaside the to sent be to ne2ds army ten of team a";
//        String ans = decryptMessage(encryptedMessage);
//        System.out.println(ans);
//        Set<Integer> set = new TreeSet<>();
//        set.add(5);
//        set.add(3);
//        set.add(10);
//        set.add(-1);
//        set.add(2);
//
//        System.out.println(set);
//        ((TreeSet<Integer>) set).pollFirst();
//
//        System.out.println(set);

//        int[] costs = {17,12,10,2,7,2,11,20,8};
//        int k = 3;
//        int candidates = 4;
//
//        List<Integer> temp = Arrays.asList(17,12,10,2,7,2,11,20,8);
//        int[] arr = temp.stream().mapToInt(Integer::intValue).toArray();

//        int[] spells = {1,2,3,4,5,6,7};
//        int[] potions = {1,2,3,4,5,6,7};
//        int success = 25;
//        System.out.println(Arrays.toString(successfulPairs(spells,potions,success)));

//        Map<Integer,Integer> map = new HashMap<>();
//
//        map.put(1,5);
//        map.put(4,2);
//        map.put(3,5);
//        map.put(2,4);
//        map.put(5,5);
//        List<Integer> r  = new ArrayList<>();
//        r.add(1);
//        r.add(3);
//        r.clear();
//        System.out.println(r);

        int[] nums = {1};
        permute(nums,0, new ArrayList<>());

    }

    public  static  void permute(int[] nums, int i, List<Integer> res){
        if(i >= nums.length){
            System.out.println(res);
            return;
        }

        //include
        res.add(nums[i]);
        permute(nums,i+1,res);
        //exclude
        res.remove(res.size()-1);
        permute(nums,i+1, res);
    }


    public static int random(int low, int high){
        if(low>high){
            return 0;
        }

        LinkedList<Integer> lst = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();


        Random rnd = new Random();

        return rnd.nextInt(high - low + 1)+low;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(potions);
        int m = potions.length;
        int s = 0;
        int e = m-1;
        int fMid = s + (e-s)/2;
        int mid = fMid;

        for(int i : spells){

            while( mid >= 0 && potions[mid]*i >= success){
                mid--;
            }

            if(mid == fMid){
                while (mid<m && potions[mid]*i >= success) mid++;
            }

            if(mid == fMid){

                temp.add(0);
            }
            else{
                int tPairs = m - (mid+1);
                temp.add(tPairs);
            }

            mid = fMid;

        }

        return temp.stream().mapToInt(Integer::intValue).toArray();

    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Worker> queue = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            queue.add(new Worker(costs[i],i));
        }

        long totalCost = 0;

        for(int i = 0; i<k; i++){
            totalCost+=queue.poll().cost;
        }

        return totalCost;
    }

    public static String decryptMessage(String encryptedMessage) {
        String[] temp = reverseSentence(encryptedMessage);

        for (int i = 0; i < temp.length; i++) {
            temp[i] = resolve(temp[i]);
        }

        return String.join(" ", temp);
    }

    private static String resolve(String word) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < word.length(); ) {
            char curr = word.charAt(i);
            if (i + 1 < word.length() && Character.isDigit(word.charAt(i + 1))) {
                int repeatCount = Character.getNumericValue(word.charAt(i + 1));
                ans.append(String.valueOf(curr).repeat(repeatCount)); // Simplified with repeat()
                i += 2; // Move to the next character after the digit
            } else {
                ans.append(curr);
                i++;
            }
        }
        return ans.toString();
    }

    private static String[] reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        return IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length - i - 1]) // Reverse index mapping
                .toArray(String[]::new); // Convert the stream to an array
    }
}
