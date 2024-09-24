package com.dsa.stack_problems;

public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		
		//TESTCASE 1
		String[] tokens1 = {"2","1","+","3","*"};
		
		//TESTCASE 2
		String[] tokens2 = {"4","13","5","/","+"};
		
		//TESTCASE 3
		String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		
		int result1 = evalRPN(tokens1);
		System.out.println("RESULT 1: "+result1);
		
		int result2 = evalRPN(tokens2);
		System.out.println("RESULT 2: "+result2);
		
		int result3 = evalRPN(tokens3);
		System.out.println("RESULT 3: "+result3);
		
		
	}
	
	public static int evalRPN(String[] tokens) {
		
		int result = 0;
		
		for(String t : tokens) {
			
		}
		
		return result;
		
	}
	
}
