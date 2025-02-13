package com.dsa.string_problems;

import java.util.Arrays;

public class NextGreaterElementIII {

    public static void main(String[] args) {
        int n = 101;
        int res = nextGreaterElement(n);
        System.out.println(res);
    }

    public static int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length-2;

        while(i>=0 && digits[i] >= digits[i+1]){
            i--;
        }

        //already had largest permutation
        if(i<0) return -1;

        int j = digits.length-1;

        while(digits[j] <= digits[i]){
            j--;
        }

        //swap the i with j
        char temp = digits[j];
        digits[j] = digits[i];
        digits[i] = temp;

        //now reverse the remaining portion from i+1
        reverse(digits, i+1, digits.length-1);

        long result = Long.parseLong(new String(digits));

        // Step 5: Check for 32-bit integer overflow
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private static void reverse(char[] digits, int left, int right){
        while(left<right){
            char temp = digits[left];
            digits[left++] = digits[right];
            digits[right--] = temp;
        }
    }

}
