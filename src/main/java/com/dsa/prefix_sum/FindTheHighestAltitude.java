package com.dsa.prefix_sum;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length+1];

        prefix[0] = 0;
        prefix[1] = gain[0];

        for(int i=1; i<gain.length; i++){
            prefix[i+1] = prefix[i]+gain[i];
        }

        int max =0;

        for(int j=1; j<prefix.length; j++){
            if(max<prefix[j]){
                max = prefix[j];
            }
        }

        return max;

    }

}
