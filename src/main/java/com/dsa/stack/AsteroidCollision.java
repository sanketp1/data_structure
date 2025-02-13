package com.dsa.stack;
import java.util.*;


public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroid = {10,2,-5 };
        int[] result = asteroidCollision(asteroid);

        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n : asteroids){
            if(n>0){
                stack.push(n);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(n)){
                    stack.pop();
                }

                if(!stack.empty() && stack.peek() == Math.abs(n)){
                    stack.pop();
                }
                else{
                    if(stack.isEmpty() || stack.peek() < 0){
                        stack.push(n);
                    }
                }

            }



        }
            int[] result = new int[stack.size()];
            int cnt  = 0;
            for(int x : stack){
                result[cnt++] = x;
            }

        return result;
    }

}
