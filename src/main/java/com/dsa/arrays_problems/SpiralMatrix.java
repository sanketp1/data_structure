package com.dsa.arrays_problems;

import java.util.ArrayList;
import java.util.List;

/*

*Spiral Matrix*

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/

public class SpiralMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix));

	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        	
		//rows
		int m = matrix.length;
		
		//columns
		int n = matrix[0].length;
		
		List<Integer> order = new ArrayList<>();
		
		int top = 0;
		int down = m-1;
		
		int left = 0;
		int right = n-1;
		
		//Initializing the direction
		/*
		 * 0 = towards right →
		 * 1 = towards down ↓
		 * 2 = towards left ←
		 * 3 = towards top ↑
		 */
		
		//keeping it initially 0 means toward right
		int direction = 0;
		
		while(top<=down && left<=right) {
			
			if(direction==0) {
				for(int i=left; i<=right; i++) {
					order.add(matrix[top][i]);
				}
				//incrementing top pointer
				top++;
			}else {
				if(direction == 1) {
					for(int i = top; i<=down; i++) {
						order.add(matrix[i][right]);
					}
					//decrementing right pointer
					right--;
				}
				if(direction==2) {
					for(int i = right; i>=left; i--) {
						order.add(matrix[down][i]);
					}
					//decrementing down pointer
					down--;
				}
				if(direction==3) {
					for(int i = down; i>=top; i--) {
						order.add(matrix[i][left]);
					}
					//incrementing left pointer
					left++;
				}
			}
			
			direction = (direction+1)%4;
			
		}
		
		return order;
		
    }
}
