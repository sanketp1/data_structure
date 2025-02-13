package com.dsa.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {

    public static void main(String[] args) {
        String s = "100[leetcode]";
        String result = decodeString(s);
        System.out.println(result);
    }

    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the complete number (multi-digit support)
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto the stacks
                numStack.push(num);
                strStack.push(currString.toString());
                currString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // Decode the string inside the brackets
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeatCount = numStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currString);
                }
                currString = temp;
            } else {
                // Append characters to the current string
                currString.append(c);
            }
        }

        return currString.toString();

    }

}
