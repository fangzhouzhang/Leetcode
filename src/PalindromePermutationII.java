import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		Character middle = null;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 != 0) {
				if (middle != null) {
					return res;
				}
				middle = e.getKey();
			}
		}

		String tmp = middle == null ? "" : "" + middle;
		generate(map, tmp, s.length(), res);
		return res;
	}

	private void generate(Map<Character, Integer> map, String tmp, int len, List<String> res) {
		if (len == tmp.length()) {
			res.add(tmp);
			return;
		}
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			Character c = e.getKey();
			int count = e.getValue();
			if (count < 2) {
				continue;
			}
			map.put(c, count - 2);
			generate(map, c + tmp + c, len, res);
			map.put(c, count);
		}
	}
}
