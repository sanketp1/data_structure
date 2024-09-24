package com.dsa.dynamic_programmingc.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		//let's find the 6th fibonacci term
		int n = 50;
		long result = fib(n);
		
		System.out.println(result);
		
	}
	
	public static long fib(int n) {
		
		long[] table = new long[n+1];
		
		table[1] = 1;
	
		for(int i =0; i<n; i++) {
			 table[i + 1] += table[i];
	            if (i + 2 <= n) {
	                table[i + 2] += table[i];
	            }
		}
		
		return table[n];
	}

}
