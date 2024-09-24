package com.dsa.dynamic_programmingc.tabulation;

public class FibonacciOptimizedSpace {

		public static void main(String[] args) {
			System.out.println(fib(50));
		}
		
		public static long fib(int n) {
			
			long prev0 = 0;
			long prev = 1;
			
			Long curr = null ;
			
			for(int i=2; i<=n; i++) {
				curr = prev0 + prev;
				prev0 = prev;
				prev = curr;
			}
			
			return curr;
			
		}
}
