import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
	/**
	 * time: o(n^2) space: o(n)
	 */
	private Map<String, List<Integer>> map;
	public WordDistance(String[] words) {
		map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				List<Integer> list = map.get(words[i]);
				list.add(i);
				map.put(words[i], list);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(words[i], list);
			}
		}
	}

	public int shortest(String word1, String word2) {
		int global = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		for (Integer num1 : list1) {
			for (Integer num2 : list2) {
				global = Math.min(global, Math.abs(num1 - num2));
			}
		}
		return global;
	}
}
