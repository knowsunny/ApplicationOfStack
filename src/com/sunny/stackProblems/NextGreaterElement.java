package com.sunny.stackProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		Stack<Integer> nextGreater = new Stack<>();
		HashMap<Integer,Integer> hshmap=new HashMap<>();
		for(int i=0;i<n;i++) {
			int temp=in.nextInt();
			arr[i]=temp;
		}
		for(int i=n-1;i>=0;i--) {
			while(!nextGreater.isEmpty() && nextGreater.peek()<arr[i]) {
				nextGreater.pop();	
			}
			hshmap.put(arr[i], nextGreater.isEmpty()?-1:nextGreater.peek());
			nextGreater.push(arr[i]);
		}
		

		for(Map.Entry<Integer, Integer> entry:hshmap.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
