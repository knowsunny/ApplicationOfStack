package com.sunny.stackProblems;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BracesChecker {

	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		String expression = in.nextLine();
		Stack<Character> braceStack = new Stack<>();
		int validExp = 1;
		for (int i = 0; i < expression.length() && validExp != 0; i++) {
			Character currChar = expression.charAt(i);
			if (currChar == '(' || currChar == '{' || currChar == '[') {
				braceStack.push(currChar);
			} else if (currChar == ')' || currChar == '}' || currChar == ']') {
				Character topStack = null;
				if (!braceStack.empty()) {
					topStack = braceStack.pop();
				}
				if (topStack==null && braceStack.empty()) {
					validExp = 0;
				} else if (topStack == '(' && currChar != ')') {
					validExp = 0;
				} else if (topStack == '{' && currChar != '}') {
					validExp = 0;
				} else if (topStack == '[' && currChar != ']') {
					validExp = 0;
				}
			}
		}
		if (validExp == 0 || !braceStack.empty()) {
			System.out.println("Not a valid expression");
		} else {
			System.out.println("Valid expression");
		}
	}

}
\\demo