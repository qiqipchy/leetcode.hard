public class Solution {
	// 普通方法用的是递归；
	public boolean isMatch(String str, String pattern) {
		if (str.length() == 0 && pattern.length() == 0)
			return true;
		if (str.length() == 0 || pattern.length() == 0)
			return false;
		int s = 0, p = 0, ss = 0, pp = -1;
		// 不能小于p < pattern.length()，万一前面是aaa，后面是aa；
		while (s < str.length()) {
			// p还没结束呢，如果两个字母相等，或者pattern中的字母为？
			if (p < pattern.length()
					&& (pattern.charAt(p) == '?' || pattern.charAt(p) == str
							.charAt(s))) {
				s++;
				p++;

			}
			// p没结束，如果pattern中的字母为*，那么就有很多种可能；
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				ss = s;
				pp = p++;
			}
			// 如果pattern字母和str中的不相同或者p结束了；
			else if (pp != -1) {
				s = ++ss;
				p = pp + 1;
			} else
				return false;
		}
		while (p < pattern.length())
			if (pattern.charAt(p++) != '*')
				return false;
		return true;
	}

	public static void main(String[] args) {
		String str = "hi";
		String pattern = "*?";
		System.out.println(new Solution().isMatch(str, pattern));

	}
}
