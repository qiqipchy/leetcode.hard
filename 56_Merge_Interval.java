package com.leetcode.twentyone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new ArrayList<Interval>();
		if (intervals.size() == 0)
			return list;
		Collections.sort(intervals);

		Interval interval = new Interval(intervals.get(0).start,
				intervals.get(0).end);
		for (int i = 1; i < intervals.size(); i++) {
			// 注意这里的比较对象和start和end的更新；
			if (intervals.get(i).start <= interval.end) {
				interval.start = Math.min(intervals.get(i).start,
						interval.start);
				interval.end = Math.max(intervals.get(i).end, interval.end);
			} else {
				list.add(interval);
				interval = new Interval(intervals.get(i).start,
						intervals.get(i).end);
			}
		}
		list.add(interval);
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 1, 10 };
		List<Interval> intervals = new ArrayList<Interval>();
		for (int i = 0; i < nums.length; i += 2) {
			intervals.add(new Interval(nums[i], nums[i + 1]));
		}
		Solution solution = new Solution();
		List<Interval> res = solution.merge(intervals);
		for (int i = 0; i < res.size(); i++) {
			System.out.print("[" + res.get(i).start + "," + res.get(i).end
					+ "],");
		}
	}
}

class Interval implements Comparable<Interval> {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Interval o) {
		// TODO Auto-generated method stub
		return this.start - o.start;
	}

}
