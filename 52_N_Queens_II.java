import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 遇到递归还是拆成各种函数比较好，使用数组比较好，快，不用封装好的集合；

	int cnt = 0;
	//这两个反了，visit[i]表示第i列的横坐标，row[i]表示第i个横坐标有没有被占用
	int[] row;
	int[] visit;
	List<Integer> list = new ArrayList<Integer>();

	// N皇后的问题不能同一行，同一列，同一条斜线上
	public int totalNQueens(int n) {
		row = new int[n];
		visit = new int[n];
		for (int i = 0; i < visit.length; i++)
			visit[i] = -1;
		backTracing(0, n, 0);
		return cnt;
	}

	private void backTracing(int depth, int n, int jBegin) {
		// TODO Auto-generated method stub
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (row[i] == 0) {
				// 没想到写一个函数会更快。。。。
				if (isVaild(i, jBegin, n)) {
					row[i] = 1;
					visit[jBegin] = i;
					backTracing(depth + 1, n, jBegin + 1);
					row[i] = 0;
					visit[jBegin] = -1;
				}
			}
		}
	}

	private boolean isVaild(int i, int j, int n) {
		// TODO Auto-generated method stub
		// k为列
		for (int k = 0; k < n; k++) {
			if (visit[k] != -1) {
				if (Math.abs(k - j) == Math.abs(i - visit[k]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(new Solution().totalNQueens(n));
	}
}
