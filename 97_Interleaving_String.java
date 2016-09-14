import java.util.Arrays;

public class Solution {
	String s1, s2, s3;
	int n1, n2;

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		n1 = s1.length();
		n2 = s2.length();

		boolean[][] path = new boolean[s1.length() + 1][s2.length() + 1];
		path[0][0] = true;
		dp(path);
		for (int i = 0; i <= s1.length(); i++) {
			System.out.println(Arrays.toString(path[i]));
		}
		return path[n1][n2];
	}

	private void dp(boolean[][] path) {
		for (int i = 1; i <= n1; i++)
			path[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && path[i - 1][0];
		for (int i = 1; i <= n2; i++)
			path[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && path[0][i - 1];

		for (int i = 1; i <= n1; i++)
			for (int j = 1; j <= n2; j++) {
				// the last char come from s1 or s2
				path[i][j] = (path[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i
						+ j - 1))
						|| (path[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i
								+ j - 1));
			}
	}

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "";
		String s3 = "a";
		System.out.print(new Solution().isInterleave(s1, s2, s3));
	}
}
