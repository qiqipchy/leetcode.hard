public class Solution {
    public int findDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (map.containsKey(key))
				return key;
			else
				map.put(nums[i], 1);

		}
		return 0;
	}
}
