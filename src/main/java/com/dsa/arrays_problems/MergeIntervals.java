package com.dsa.arrays_problems;

/*

*Merge Intervals*

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		
		//TESTCASE 1
//		int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
		int[][] intervals1 = {{1,4},{0,1}};
		int[][] merged = merge(intervals1);
		
		for(int[] x : merged) {
			System.out.println(Arrays.toString(x));
		}
		
		//TESTCASE 2
		int[][] intervals2 = {{1,4},{4,5}};
		System.out.println(Arrays.toString(merge(intervals2)));
	}
	
	public static int[][] merge(int[][] intervals){
		
		 if (intervals.length == 0) return new int[0][0];

	        // Sort intervals based on the starting time
//	        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

	        List<int[]> merged = new ArrayList<>();
	        for (int[] interval : intervals) {
	            // If the merged list is empty or there is no overlap
	            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
	                merged.add(interval);
	            } else {
	                // There is overlap, merge the intervals
	                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
	            }
	        }

	        return merged.toArray(new int[merged.size()][]);
		
	}
	
	
}
