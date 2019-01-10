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
		if (s == null || s.length() == 0) {
			return res;
		}
		Map<Character, Integer> dict = buildDict(p);
		Map<Character, Integer> letters = new HashMap<>();
		boolean valid = true;
		for (int i = 0; i + p.length() - 1 < s.length(); i++) {
			letters.clear();
			valid = true;
			for (int offset = 0; offset < p.length(); offset++) {
				char ch = s.charAt(i + offset);
				if (!isValid(dict, letters, ch)) {
					valid = false;
					break;
				} else {

				}
			}
			if (valid == true) {
				res.add(i);
			}
		}
		return res;
	}
	private Map<Character, Integer> buildDict(String p) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		return map;
	}
	private boolean isValid(Map<Character, Integer> dict,
							Map<Character, Integer> letters,
							Character ch) {
		if (!dict.containsKey(ch)) {
			return false;
		}
		if (!letters.containsKey(ch)) {
			letters.put(ch, 1);
		} else {
			letters.put(ch, letters.get(ch) + 1);
		}
		if (letters.get(ch) > dict.get(ch)) {
			return false;
		}
		return true;
	}
}
