import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _245ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null) return -1;
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}
		if (word1.equals(word2)) {
			return sameWord(word1, word2, map);
		} else return diffWord(word1, word2, map);
	}

	private int sameWord(String a, String b, Map<String, List<Integer>> map) {
		List<Integer> idxs = map.get(a);
		if (idxs.size() <= 1) return -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < idxs.size() - 1; i++) {
			res = Math.min(res, idxs.get(i + 1) - idxs.get(i));
		}
		return res;
	}

	private int diffWord(String a, String b, Map<String, List<Integer>> map) {
		List<Integer> l1 = map.get(a);
		List<Integer> l2 = map.get(b);
		int i = 0, j = 0;
		int res = Integer.MAX_VALUE;
		while (i < l1.size() && j < l2.size()) {
			int idx1 = l1.get(i), idx2 = l2.get(j);
			if (idx1 < idx2) {
				res = Math.min(res, idx2 - idx1);
				i++;
			} else {
				res = Math.min(res, idx1 - idx2);
				j++;
			}
		}
		return res;
	}
}
