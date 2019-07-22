import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s.length() == 0 || words.length == 0) {
			return res;
		}
		Map<String, Integer> counts = new HashMap<>();
		for (String word: words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		for (int i = 0; i < s.length() + 1 - words[0].length() * words.length; i++) {
			String trial = s.substring(i, i + words[0].length() * words.length);
			if (isConcat(counts, words[0].length(), trial)) {
				res.add(i);
			}
		}
		return res;
	}
	private boolean isConcat(Map<String, Integer> counts, int len, String trial) {
		Map<String, Integer> trialCounts = new HashMap<>();
		for (int i = 0; i < trial.length(); i += len) {
			String s = trial.substring(i, i + len);
			trialCounts.put(s, trialCounts.getOrDefault(s, 0) + 1);
		}
		return counts.equals(trialCounts);
	}
}
