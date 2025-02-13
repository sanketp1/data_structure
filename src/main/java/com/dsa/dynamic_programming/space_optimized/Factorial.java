package com.dsa.dynamic_programming.space_optimized;

import java.math.BigInteger;

public class Factorial {


    public static void main(String[] args) {
        String result = factorial(6);
        System.out.println(result);
    }

    private static long fact(int n){
        if(n == 0){
            return 1;
        };

        long prev = 1;

        for(int i = 2; i<=n; i++){
            long curr = i*prev;
            prev = curr;
        }

        return prev;
    }

    private static String factorial(int n){
        if(n==0) return "1";
        BigInteger prev = new BigInteger("1");

        for(int i = 2; i<=n; i++){
            BigInteger curr = prev.multiply(new BigInteger(String.valueOf(i)));
            prev = curr;
        }

        return prev.toString();
    }

    


}
