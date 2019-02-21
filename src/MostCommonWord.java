import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.replaceAll ("\\pP", " ").toLowerCase().split ("\\s+");
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
			// System.out.println(key + " " + map.get(key));
			if (map.get(key) > max) {
				max = map.get(key);
				res[0] = key;
			}
		}
		return res[0];
	}
}
