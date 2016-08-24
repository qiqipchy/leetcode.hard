import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Interval {
	public int start;
	public int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}


// 哈哈哈哈一次AC！！！
public class SummaryRanges {

	TreeSet<Integer> nums;
	List<Interval> list;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		nums = new TreeSet<Integer>();
		list = new ArrayList<Interval>();
	}

	public void addNum(int val) {
		if (!nums.add(val))
			return;
		int left = 0, right = list.size() - 1, mid = (left + right) / 2;
		while (left <= right) {
			mid = (left + right) / 2;
			int num = list.get(mid).start;
			if (num == val)
				return;
			if (num > val)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		if (list.size() == 0) {
			list.add(new Interval(val, val));
			return;
		}
		
		// left就是num需要插入的地方；
		// 如果val比最小的begin还要小；
		if (left == 0) {

			if (list.get(0).start == val + 1)
				list.get(0).start = val;
			else if (list.get(0).start > val + 1)
				list.add(0, new Interval(val, val));

		} else if (left == list.size()) {

			if (list.get(list.size() - 1).end == val - 1)
				list.get(list.size() - 1).end = val;
			else if (list.get(0).start < val - 1)
				list.add(new Interval(val, val));

		} else {
			
			// 注意这里比较的是next是left，而不是left+1；
			int pre = left - 1, next = left;
			int s1 = list.get(pre).start, s2 = list.get(next).start;
			int e1 = list.get(pre).end, e2 = list.get(next).end;

			// 其中的关系，s1<val<s2;
			if (e1 >= val)
				return;
			else {
				if (e1 + 1 == val) {
					list.get(pre).end = val;
					e1 = val;
				}
			}

			if (val + 1 == s2) {
				list.get(next).start = val;
				s2 = val;
			}

			if (e1 == s2) {
				list.get(pre).end = e2;
				list.remove(next);
			} else if (e1 != val && s2 != val)
				list.add(left, new Interval(val, val));
		}

	}

	public List<Interval> getIntervals() {
		return list;
	}

	public void print(List<Interval> param_2) {
		for (Interval iter : param_2)
			System.out.println("[" + iter.start + "," + iter.end + "]");
		System.out.println("---------------------------------------");
	}

	public static void main(String[] args) {

		SummaryRanges obj = new SummaryRanges();
		obj.addNum(48);
		obj.print(obj.getIntervals());

		obj.addNum(47);
		obj.print(obj.getIntervals());

		obj.addNum(46);
		obj.print(obj.getIntervals());

		obj.addNum(45);
		obj.print(obj.getIntervals());

		obj.addNum(44);
		obj.print(obj.getIntervals());

		obj.addNum(43);
		obj.print(obj.getIntervals());

		obj.addNum(42);
		obj.print(obj.getIntervals());

	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); List<Interval>
 * param_2 = obj.getIntervals();
 */
