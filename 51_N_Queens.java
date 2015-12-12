import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 计算两遍

	int cnt = 0;
	int[] visit;
	int[] row;
	char[][] path;
	List<List<String>> list = new ArrayList<List<String>>();

	private void print() {
		for (List<String> pathOne : list) {
			for (String string : pathOne)
				System.out.println(string);
			System.out.println("--------------------------");
		}
	}

	public List<List<String>> solveNQueens(int n) {
		path = new char[n][n];
		visit = new int[n];

		row = new int[n];
		for (int i = 0; i < row.length; i++) {
			row[i] = -1;
			for (int j = 0; j < n; j++)
				path[i][j] = '.';
		}
		backTracing(0, n, 0);
		return list;
	}

	private void backTracing(int depth, int n, int jBegin) {
		// TODO Auto-generated method stub
		if (depth == n) {
			list.add(buildList(n));
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] == 0) {
				// 没想到写一个函数会更快。。。。
				if (isVaild(i, jBegin, n)) {
					visit[i] = 1;
					row[jBegin] = i;
					path[i][jBegin] = 'Q';
					backTracing(depth + 1, n, jBegin + 1);
					visit[i] = 0;
					row[jBegin] = -1;
					path[i][jBegin] = '.';
				}
			}
		}
	}

	private List<String> buildList(int n) {
		// TODO Auto-generated method stub
		List<String> pathOne = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			pathOne.add(new String(path[i]));
		}
		return pathOne;
	}

	private boolean isVaild(int i, int j, int n) {
		// TODO Auto-generated method stub
		// k为列
		for (int k = 0; k < n; k++) {
			if (row[k] != -1) {
				if (Math.abs(k - j) == Math.abs(i - row[k]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;
		Solution solution = new Solution();
		solution.solveNQueens(n);
		solution.print();
	}
}
