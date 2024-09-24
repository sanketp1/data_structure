package com.dsa.recursion;

public class ArithmeticSum{



    public static void main(String[] args){

        int n = 50;

        System.out.println("Sum of first "+n+" natural numbers are :"+sumOfNNaturalNumber(n));
        System.out.println(fibbo(0));
    }

    public static int sumOfNNaturalNumber(int n){
        if(n==1) {
            return 1;
        }
        return n + sumOfNNaturalNumber(n-1);
    }

    public static int fibbo(int n){
        if (n <= 1)
            return n;

        return fibbo(n-1)+fibbo(n-2);
    }

}