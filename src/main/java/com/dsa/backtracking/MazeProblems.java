package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazeProblems {


    public static void main(String[] args) {
        int r = 3;
        int c = 3;

//        int result = count(r,c);
//        System.out.println(result);

//        path(3,3,"");

        int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        List<String> ans = new ArrayList<>();
//        findPath(mat,0, 0, "", ans);
        System.out.println(ans);
    }

    public static int count(int r, int c){
        if(r  == 1 || c == 1){
            return 1;
        }

        int left = count(r-1,c);
        int right = count(r,c-1);

        return left + right;
    }

    public static void path(int r, int c, String path){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }

        if(r>1){
            path(r-1,c,path+"D");
        }

        if(c>1){
            path(r,c-1,path+"R");
        }
    }

    public static void solve(ArrayList<ArrayList<Integer>> mat, int r, int c, String path, List<String> result){
            if(r == mat.size()-1 && c == mat.size()-1){
                result.add(path);
                return;
            }

            if(r < mat.size() && c < mat.size() && mat.get(r).get(c) == 1){
                solve(mat,r+1, c, path+"D", result);
            }

            if(c < mat.size() && r<mat.size() && mat.get(r).get(c) == 1){
                solve(mat, r, c+1, path+"R", result);
            }
    }



}
