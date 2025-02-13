package com.dsa.stack;
import java.util.Arrays;
import java.util.Stack;

public class RemovingStarsFromAString {

    public static void main(String[] args) {
        String s = "leet**cod*e";
        //testing
        String result = removeStars(s);
        System.out.println(result);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the last non-star character
                }
            } else {
                stack.push(c);
            }
        }

        // Convert the remaining stack into a string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();

    }

}
