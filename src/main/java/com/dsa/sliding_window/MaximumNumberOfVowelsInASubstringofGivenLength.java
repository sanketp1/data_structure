package com.dsa.sliding_window;

public class MaximumNumberOfVowelsInASubstringofGivenLength {
    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;

        System.out.println(maxVowels(s,k));
    }

    public static int maxVowels(String s, int k) {
        int maxCount = 0;
        int count  = 0;
        int i;

        int left = 0;

        for(i = 0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }

        maxCount = count;

        for(int right = k; right < s.length(); right++){
            if(isVowel(s.charAt(right))){
                count++;
            }

            if(isVowel(s.charAt(left))){
                count--;
            }

            //updating max count
            maxCount = Math.max(maxCount,count);


            left++;
        }


        return maxCount;

    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
