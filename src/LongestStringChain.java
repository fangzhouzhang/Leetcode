import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {
	public int longestStrChain(String[] words) {
		if (words.length == 0) return 0;
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String w: words) set.add(w);
		int max = 0;
		for (String w: words) max = Math.max(max, dfs(w, map, set));
		return max;
	}

	private int dfs(String word, Map<String, Integer> map, Set<String> set) {
		if (map.get(word) != null) return map.get(word);
		int max = 0;
		boolean exist = false;
		for (int i = 0; i < word.length(); i++) {
			String tmp = word.substring(0, i) + word.substring(i + 1, word.length());
			if (set.contains(tmp)) {
				exist = true;
				max = Math.max(max, 1 + dfs(tmp, map, set));
			}
		}
		if (!exist) {
			map.put(word, 1);
			return 1;
		}
		map.put(word, max);
		return max;
	}
}
