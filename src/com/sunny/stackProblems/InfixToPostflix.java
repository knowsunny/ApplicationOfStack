package com.sunny.stackProblems;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostflix {

	public static void main(String arg[]) {
		Scanner in=new Scanner(System.in);
		String exp=in.nextLine();
		String result="";
		Stack<Character> operands=new Stack<>();
		for(int i=0;i<exp.length();i++) {
			Character currChar=exp.charAt(i);
			if(Character.isLetterOrDigit(currChar)) {
				result+=currChar;
			}else if(currChar=='(') {
				operands.push(currChar);
			}else if(currChar==')') {
				while(!operands.isEmpty() && operands.peek()!='(') {
					result+=operands.pop();
				}
				if(!operands.isEmpty() && operands.peek()!='('){
					System.out.println("invalid expression");
				}else {
					operands.pop();
				}
			}else {
				while(!operands.isEmpty() && precedence(currChar)<=precedence(operands.peek())) {
					result+=operands.pop();
				}
				operands.push(currChar);
				
			}
		}
		while(!operands.isEmpty()) {
			result+=operands.pop();
		}
		System.out.println(result);
	}
	static int precedence(Character operand) {
		switch(operand){
			case '+':
			case '-':{
				return 1;
			}
			case '*':
			case '/':{
			return 2;
			}
			case '^':{
				return 3;
			}
		}
		return 0;
	}
}

