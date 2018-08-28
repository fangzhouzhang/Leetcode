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
		// write your code here
		List<Integer> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			if (map.containsKey(p.charAt(i))) {
				map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
			} else {
				map.put(p.charAt(i), 1);
			}
		}
		int remainWords = map.size();
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					remainWords--;
				}
			}
			right++;

			while (remainWords == 0) {
				char temp = s.charAt(left);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0) {
						remainWords++;
					}
				}
				if (right - left == p.length()) {
					res.add(left);
				}
				left++;
			}
		}
		return res;
	}
}
