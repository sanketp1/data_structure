package com.dsa.dynamic_programmingc.tabulation;

import java.util.Arrays;

public class GridTraveller {
	
	public static void main(String[] args) {
		System.out.println(gridTraveller(100, 100 ));
	}
	
	public static long gridTraveller(int m, int n) {
		
		long[][] table = new long[m+1][n+1];
		
		table[1][1] = 1;
		
		for(int i=0; i<=m; i++) {
			for(int j = 0; j<=n; j++) {
				long current = table[i][j];
				if(j+1 <=n) {
					table[i][j+1] +=current;
				}
				if(i+1 <=m) {
					table[i+1][j] +=current;
				}
			}
		}
		
		return table[m][n];
		
		
	}
	
}
