package com.dsa.arrays_problems;

import java.util.Arrays;

/*
 
*Rotate Image*

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

 
 */

public class RotateImage {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		//rotating
		rotate(matrix);
		
		for(int[] row : matrix) {
			System.out.print(Arrays.toString(row)+" ");
			
		}
		
	}
	
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        //taking transpose of matrix 
        transpose(matrix);

        //making each row reverse
        for(int row =0; row<n; row++){

            int i =0; 
            int j = matrix[row].length-1;
            while(i<j){
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                i++;
                j--;
            }


        }

    }
	
	private static void transpose(int matrix[][]) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // Swmatrixp element at matrix[i][j] matrixnd matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
	
}
