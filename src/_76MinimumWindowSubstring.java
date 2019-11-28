import java.util.HashMap;
import java.util.Map;

public class _76MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null) return "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = map.size();
		int min = Integer.MAX_VALUE;
		int i = 0, j = 0;
		int left = 0, right = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) count--;
			}
			while (count == 0) {
				if (min > j - i + 1) {
					min = j - i + 1;
					left = i;
					right = j;
				}
				char tmp = s.charAt(i);
				if (map.containsKey(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
					if (map.get(tmp) == 1) count++;
				}
				i++;
			}
			j++;
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
	}
}
