import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		char[] chars = paragraph.toCharArray();
		List<String> words = new ArrayList<>();
		int start = 0;int end = 0;
		while (end < chars.length) {
			char ch = chars[end];
			if (Character.isLetter(ch)) {
				while (end < chars.length && Character.isLetter(chars[end])) {
					chars[end] = Character.toLowerCase(chars[end]);
					end++;
				}
				words.add(new String(chars, start, end - start));
				start = end;
			} else {
				start++;
				end++;
			}
		}
		Map<String, Integer> map = new HashMap<>();
		for (String ban: banned) {
			map.put(ban, Integer.MIN_VALUE);
		}
		for (String word: words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		int max = 0;
		String[] res = new String[1];
		for (String key: map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				res[0] = key;
			}
		}
		return res[0];
	}
}
