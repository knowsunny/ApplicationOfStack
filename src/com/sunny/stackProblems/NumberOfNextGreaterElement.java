package com.sunny.stackProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NumberOfNextGreaterElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = in.nextInt();
			arr[i] = temp;
		}
		int next[] = new int[n];
		Stack<Integer> nextStck = new Stack<>();
		nextStck.push(0);
		for (int i = 1; i < n; i++) {
			int flag = 1;
			while (!nextStck.isEmpty() && flag == 1) {
				int curr = nextStck.peek();
				if (arr[curr] <= arr[i]) {
					next[curr] = i;
					nextStck.pop();
				} else {
					flag = 0;
				}
			}
			nextStck.push(i);
		}
		while(!nextStck.isEmpty()) {
			next[nextStck.pop()]=-1;
		}
		

		System.out.println(Arrays.toString(next));

		// function to count the number of next greater number to the right
		
		int dp[]=new int[n];
		dp[n-1]=0;
		for(int i=n-2;i>=0;i--) {
			if(next[i]==-1) {
				dp[i]=0;
			}else {
				dp[i]=1+dp[next[i]];
			}
			
		}
		System.out.println(Arrays.toString(dp));
		System.out.println("Enter of queries:");
		int q=in.nextInt();
		for(int i=0;i<q;i++) {
			int temp=in.nextInt();
			System.out.println(dp[temp]);
		}
	}

}
