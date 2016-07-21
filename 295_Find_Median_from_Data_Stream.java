import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(-1);
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		System.out.println(mf.findMedian());
		mf.addNum(-3);
		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.findMedian());
		mf.addNum(16);
		System.out.println(mf.findMedian());
		mf.addNum(7);
		System.out.println(mf.findMedian());
		mf.addNum(75);
		System.out.println(mf.findMedian());
		mf.addNum(47);
		System.out.println(mf.findMedian());
	}
}

class MedianFinder {
	List<Integer> list = new ArrayList<Integer>();
	// 单数的index就是中间的那个坐标，双数的话是两个数中的小坐标；
	// 二分法插入的时候，如果相等，是插在index的前面；
	int medianIndex = 0;
	double median;

	// Adds a number into the data structure.
	public void addNum(int num) {
		if (list.size() == 0) {
			median = num;
			list.add(num);
			return;
		}
		// 使用二分法插入；
		int left = 0, right = list.size() - 1, mid = (left + right) / 2;
		while (left <= right) {
			mid = (left + right) / 2;
			if (list.get(mid) == num)
				break;
			else if (list.get(mid) < num)
				left = mid + 1;
			else
				right = mid - 1;
		}
		if (left <= right)
			list.add(mid, num);
		else
			list.add(left, num);
		System.out.println(list + " " + medianIndex + " " + num);
		if (list.size() % 2 == 0)
			median = (list.get(medianIndex) + list.get(medianIndex + 1)) * 1.0 / 2;
		else
			median = list.get(++medianIndex);
		// 中间要注意median的值，想象中的位置没变，但是注意median的值没变，所以需要加1；
		// if (num >= median) {
		// if (list.size() % 2 == 0)
		// median = (list.get(medianIndex) + list.get(medianIndex + 1)) * 1.0 /
		// 2;
		// else
		// median = list.get(++medianIndex);
		// } else if (num < median) {
		// if (list.size() % 2 == 0)
		// median = (list.get(medianIndex) + list.get(medianIndex + 1)) * 1.0 /
		// 2;
		// else
		// median = list.get(++medianIndex);
		// }

	}

	// Returns the median of current data stream
	public double findMedian() {
		return median;
	}
};

// Your MedianFinder object will be instantiated and called as such:
