package com.sunny.stackProblems;

import java.util.Scanner;
import java.util.Stack;
\\hello ram
public class PrefixToPostfix {

	public static void main(String arg[]) {
		Scanner in=new Scanner(System.in);
		String exp=in.nextLine();
		Stack<String> expStack=new Stack<>();
		for(int i=exp.length()-1;i>=0;i--) {
			Character temp=exp.charAt(i);
			if(temp.isLetterOrDigit(temp)) {
				expStack.push(String.valueOf(temp));
			}else {
				String operand1=expStack.pop();
				String operand2=expStack.pop();
				String pushExp=operand1+operand2+String.valueOf(temp);
				expStack.push(pushExp);
			}
		}
		System.out.println(expStack.pop());
	}
}
