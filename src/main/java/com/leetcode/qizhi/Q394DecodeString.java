package com.leetcode.qizhi;

import java.util.Stack;

/**
 * Created by qizhi on 2017/4/18.
 */
public class Q394DecodeString {
	public static void main(String[] args) {
		String s="3[a2[c]]";
		String output=method1(s);
		System.out.println(output);
	}

	private static String method1(String s) {
		String res="";
		Stack<Integer> countStack=new Stack<Integer>();
		Stack<String> resStatck=new Stack<String>();
		int time=0;
		String temp="";
		int idx=0;
		while(idx<s.length()){
			if(Character.isDigit(s.charAt(idx))){
				countStack.push(Integer.parseInt(""+s.charAt(idx)));
			}else if('['==s.charAt(idx)){
				resStatck.push(res);
				res="";
			}else if(']'==s.charAt(idx)){
				temp=resStatck.pop();
				time=countStack.pop();
				for (int i = 0; i < time; i++) {
					temp+=res;
				}
				res=temp;
				resStatck.push(res);
			}else{
				res+=s.charAt(idx);
			}
			idx++;
		}
		res=resStatck.pop();
		return res;
	}
}
