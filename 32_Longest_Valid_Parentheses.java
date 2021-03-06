package com.leetcode.twentyone;

public class Solution {
	public int longestValidParentheses(String s) {
		if (s.isEmpty())
			return 0;
		int[] t = new int[s.length()];
		for (int j = 1; j < s.length(); j++) {
			int length = maxLength(0, j, s);
			t[j] = Math.max(length, t[j - 1]);
		}
		return t[s.length() - 1];
	}

	private int maxLength(int begin, int end, String s) {
		// TODO Auto-generated method stub
		int top = -1, index = end;
		for (int k = end; k >= begin && top >= -1; k--) {
			if (s.charAt(k) == '(')
				top--;
			else if (s.charAt(k) == ')')
				top++;
			if (top == -1)
				index = k - 1;
		}
		return end - index;
	}

	public static void main(String[] args) {
		String s = "";
		System.out.println(new Solution().longestValidParentheses(s));
	}
}
