package com.dsa.hash_set_or_map;
import java.util.*;

public class EqualRowAndColumnPairs {
      public static void main(String[] args) {
        int[][] grid = {
                {3,1,2,2},
          {1,4,4,5},
              {2,4,2,2},
                  {2,4,2,2}

        };
        //testing
        int result = equalPairs(grid);
        System.out.println(result);
    }

    public static int equalPairs(int[][] grid) {
        Map<String,Integer> rowData = new HashMap<>();
        Map<String,Integer> colData = new HashMap<>();
        int result = 0;
        for(int row = 0; row< grid.length; row++){
            StringBuilder seq = new StringBuilder();
            for (int col = 0; col<grid[row].length; col++){
                seq.append(grid[row][col]);
            }
            rowData.put(seq.toString(), rowData.getOrDefault(seq.toString(),0)+1);
        }

        for(int col = 0; col< grid[0].length; col++){
            StringBuilder seq = new StringBuilder();
            for (int row = 0; row<grid.length; row++){
                seq.append(grid[row][col]);
            }
            colData.put(seq.toString(), colData.getOrDefault(seq.toString(),0)+1);
        }

        for(Map.Entry<String,Integer> e : rowData.entrySet()){
            if(colData.containsKey(e.getKey())){
                result+=e.getValue();
            }
        }

        return result;

    }

}
