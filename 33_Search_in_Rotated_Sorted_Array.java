public class Solution {
	public int search(int[] nums, int target) {

		int left = 0, right = 0, mid = 0;
		int i = 0, j = nums.length - 1;
		// 注意没有考虑i==j的情况；
		while (i < j) {
			if (nums[i] == target)
				return i;
			if (nums[j] == target)
				return j;
			// 这要写在i++改变之前；
			if (nums[i] > nums[i + 1]) {
				left = i + 1;
				right = j;
				break;
			}
			if (nums[j] < nums[j - 1]) {
				left = i;
				right = j - 1;
				break;
			}
			if (nums[i] < nums[i + 1])
				i++;
			if (nums[j] > nums[j - 1])
				j--;
		}
		// 主要是找顺序的最中间的那个；要是没有经过break出来，就会漏掉最中间的一个；
		if (i == j && nums[i] == target)
			return i;
		System.out.println(left + " " + right);
		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		if (nums[left] != target)
			left = -1;
		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 6, 7, 8, 9 };
		int target = 7;
		System.out.println(new Solution().search(nums, target));
	}
}
