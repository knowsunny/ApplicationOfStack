package com.sunny.stackProblems;

import java.util.Scanner;
import java.util.Stack;
//ram ram ram ram
public class StockSpanProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int temp=in.nextInt();
			arr[i]=temp;
		}
		int s[]=new int[n];
		s[0]=1;
		Stack<Integer> spanStck=new Stack<>();
		spanStck.push(0);
		for(int i=1;i<n;i++) {
			while(!spanStck.isEmpty() && arr[i]>=arr[spanStck.peek()]) {
				spanStck.pop();
			}
			s[i]=spanStck.isEmpty()?(i+10):(i-spanStck.peek());
			spanStck.push(i);
		}
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]+" : "+s[i]);
		}
	}

}
