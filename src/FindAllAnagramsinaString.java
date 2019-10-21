import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
	/**
	 * @param s: a string
	 * @param p: a string
	 * @return: a list of index
	 * time: o(n) space: o(n)
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s.length() < p.length()) return res;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
		int cnt = map.size();
		int end = 0, left = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) cnt--;
			}
			end++;
			while (cnt == 0) {
				if (end - left == p.length()) res.add(left);
				char tmp = s.charAt(left);
				if (map.containsKey(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
					if (map.get(tmp) > 0) cnt++;
				}
				left++;
			}
		}
		return res;
	}
}
