import java.util.HashMap;
import java.util.Map;

public class _1839LongestSubstringOfAllVowelsinOrder {
	public int longestBeautifulSubstring(String word) {
		int n = word.length();
		int l = 0, r = 0, res = 0, cnt = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (r < n) {
			char cur = word.charAt(r);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			if (map.get(cur) == 1) cnt++;
			while (l < r && word.charAt(r) < word.charAt(r - 1)) {
				char del = word.charAt(l++);
				map.put(del, map.getOrDefault(del, 0) - 1);
				if (map.get(del) == 0) cnt--;
			}
			if (cnt == 5) {
				res = Math.max(res, r - l + 1);
			}
			r++;
		}
		return res;
	}
}
