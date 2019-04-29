package com.sunny.stackProblems;

import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		String prefixExp=in.nextLine();
		Stack<String> expStack=new Stack<>();
		for(int i=prefixExp.length()-1;i>=0;i--) {
			Character temp=prefixExp.charAt(i);
			if(temp.isLetterOrDigit(temp)) {
				expStack.push(String.valueOf(temp));
			}else {
				String operand1=expStack.pop();
				String operand2=expStack.pop();
				String pushExp=operand1+String.valueOf(temp)+operand2;
				expStack.push(pushExp);
			}
		}
		System.out.println(expStack.pop());

	}

}
