import java.util.*;

public class _734SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
		if (words1.length != words2.length) return false;
		Map<String, Set<String>> map = new HashMap<>();
		for (List<String> pair : pairs) {
			if (!map.containsKey(pair.get(0))) map.put(pair.get(0), new HashSet<>());
			map.get(pair.get(0)).add(pair.get(1));
			if (!map.containsKey(pair.get(1))) map.put(pair.get(1), new HashSet<>());
			map.get(pair.get(1)).add(pair.get(0));
		}

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i])) continue;
			if (map.get(words1[i]) == null || !map.get(words1[i]).contains(words2[i])) return false;
		}
		return true;
	}
}
