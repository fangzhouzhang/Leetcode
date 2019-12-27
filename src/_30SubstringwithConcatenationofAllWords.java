import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null) return res;
		if (words == null || words.length == 0) return res;
		int n = words.length;
		int m = words[0].length();
		Map<String, Integer> map = new HashMap<>();
		for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
		for (int i = 0; i + m * n - 1 < s.length(); i++) {
			if (containAll(s, i, i + m * n - 1, new HashMap<String, Integer>(map), m, map.size())) res.add(i);
		}
		return res;
	}

	private boolean containAll(String s, int start, int end, Map<String, Integer> map, int m, int n) {
		int count = n;
		int cur = start;
		while (cur + m - 1 <= end) {
			String tmp = s.substring(cur, cur + m);
			if (!map.containsKey(tmp)) return false;
			map.put(tmp, map.get(tmp) - 1);
			if (map.get(tmp) == 0) count--;
			cur += m;
		}
		return count == 0;
	}
}
