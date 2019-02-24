import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
	/**
	 * time: o(n) space: o(n)
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, Integer.MAX_VALUE);
			} else {
				map.put(ch, i);
			}
		}
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			res = Math.min(e.getValue(), res);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
