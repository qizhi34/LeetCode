package com.leetcode.qizhi;

/**
 * Created by qizhi on 2017/5/28.
 */
public class Q8StringToInteger {
	public static void main(String[] args) {
		String str="123";
		int result=method2(str);
		System.out.println(result);
	}

	private static int method2(String str) {
		int index = 0, sign = 1, total = 0;
		//1. Empty string
		if(str.length() == 0) return 0;

		//2. Remove Spaces
		while(str.charAt(index) == ' ' && index < str.length())
			index ++;

		//3. Handle signs
		if(str.charAt(index) == '+' || str.charAt(index) == '-'){
			sign = str.charAt(index) == '+' ? 1 : -1;
			index ++;
		}

		//4. Convert number and avoid overflow
		while(index < str.length()){
			int digit = str.charAt(index) - '0';
			if(digit < 0 || digit > 9) break;

			//check if total will be overflow after 10 times and add digit
			if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			index ++;
		}
		return total * sign;
	}

	private static int method1(String str) {
		int ans=0;
		int sign=1;
		int expect=0;
		for (int i = 0; i < str.length(); i++) {
			char curChar=str.charAt(i);
			if(curChar=='-'){
				if(ans==0&&expect==0){
					sign=-1;
					expect++;
				}else
					break;
			}else if(curChar=='+'){
				if(ans==0&&expect==0){
					sign=1;
					expect++;
				}else
					break;
			}
			else if(curChar>='0'&&curChar<='9'){
				int flag=curChar-'0';
				int beforeans=sign*ans;
				ans=ans*10+flag;
				if(sign*ans/10!=beforeans){
					if(sign==1)
						return Integer.MAX_VALUE;
					else
						return Integer.MIN_VALUE;
				}
			}else if(curChar==' '&&expect==0&&ans==0){

			}else{
				break;
			}
		}
		ans=sign*ans;
		return ans;
	}
}
