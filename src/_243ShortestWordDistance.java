import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _243ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null || word1.equals(word2)) return -1;
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}
		int res = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		for (int n1 : list1) {
			for (int n2 : list2) {
				res = Math.min(res, Math.abs(n1 - n2));
			}
		}
		return res;
	}
}
