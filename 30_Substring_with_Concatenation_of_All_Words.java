import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//这么简单的一道题，为什么想的步骤这么多。。。。。。。。
public class Solution {
	HashMap<String, Integer> target = new HashMap<String, Integer>();
	HashMap<String, Integer> source = new HashMap<String, Integer>();
	List<Integer> res = new ArrayList<Integer>();
	String[] storage;

	public List<Integer> findSubstring(String s, String[] words) {
		if (words.length == 0)
			return res;
		if (s.length() < words.length * words[0].length())
			return res;
		int length = words[0].length();
		String key = "";
		int j;
		for (int i = 0; i < words.length; i++) {
			key = words[i];
			if (!target.containsKey(key))
				target.put(key, 1);
			else
				target.put(key, target.get(key) + 1);
		}

		// 这里需要加1
		for (int i = 0; i < s.length() - length * words.length + 1; i++) {
			source.clear();
			for (j = 0; j < words.length; j++) {
				key = s.substring(i + j * length, i + (j + 1) * length);
				if (target.containsKey(key)) {
					if (!source.containsKey(key))
						source.put(key, 1);
					else
						source.put(key, source.get(key) + 1);
					if (source.get(key) > target.get(key))
						break;
				} else
					break;
			}
			if (j == words.length)
				res.add(i);
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "barfoothe";
		String words[] = { "bar", "foo", "the" };

		System.out.println(new Solution().findSubstring(s, words) + "+++++");
	}
}
