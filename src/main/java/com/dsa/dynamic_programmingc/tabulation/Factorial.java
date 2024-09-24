/**
 * 
 */
package com.dsa.dynamic_programmingc.tabulation;

/**
 * @author 2322310
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		System.out.println(factorial(n));
	}
	
	public static long factorial(int n) {
		
		long[] dp = new long[n+1];
		dp[0] = 1;
		
		for(int i = 1; i<=n; i++ ) {
			dp[i] = dp[i-1]*i;
		}
		
		return dp[n];
		
	}

}
