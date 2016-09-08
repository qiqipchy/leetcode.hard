import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int[] c;
	int len;
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
	    if(nums.length==0)
	        return list;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min)
				min = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] - min + 1;
			if (nums[i] > max)
				max = nums[i];
		}
		c = new int[max + 1];
		len = max + 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			// 添加的不是c[i],是c[i]的和；
			list.add(0, sum(nums[i] - 1));
			update(nums[i], 1);
			//System.out.println(Arrays.toString(c));
		}
		// for (int i = 0; i < nums.length; i++) {
		// update(nums[i], 1);
		// list.add(nums[i] - sum(nums[i]));
		// System.out.println(Arrays.toString(c));
		//
		// }
		return list;
	}
	int sum(int index) {
		int s = 0;
		while (index > 0) {
			s += c[index];
			index -= index & -index;
		}
		return s;
	}
	void update(int index, int value) {
		while (index < len) {
			c[index] += value;
			index += index & -index;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(new Solution().countSmaller(nums));
	}
}
