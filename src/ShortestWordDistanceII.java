import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	private Map<String, List<Integer>> map;
	public ShortestWordDistanceII(String[] words) {
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

	private int shortest(String word1, String word2) {
		int global = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int i1 = 0;
		int i2 = 0;
		while (i1 < list1.size() && i2 < list2.size()) {
			global = Math.min(global, Math.abs(list1.get(i1) - list2.get(i2)));
			if (list1.get(i1) < list2.get(i2)) {
				i1++;
			} else {
				i2++;
			}
		}
		return global;
	}
}
