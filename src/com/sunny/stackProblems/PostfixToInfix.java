package com.sunny.stackProblems;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String expression=in.nextLine();
		Stack<String> expStck=new Stack<>();
		for(int i=0;i<expression.length();i++) {
			Character temp=expression.charAt(i);
			if(temp.isLetterOrDigit(temp)) {
				expStck.push(String.valueOf(temp));
			}else {
				String operand2=expStck.pop();
				String operand1=expStck.pop();
				String pushExp=operand1+String.valueOf(temp)+operand2;
				expStck.push(pushExp);
			}
		}

		System.out.println(expStck.pop());
	}

}
