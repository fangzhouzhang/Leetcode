import java.util.*;

public class ConcatenatedWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> res = new ArrayList<>();
		if (words.length == 0) return res;
		Set<String> dict = new HashSet<>();
		Collections.addAll(dict, words);
		for (String w : words) {
			//dp means from idx to w.length - 1, whether the word is in dict or not
			Boolean[] dp = new Boolean[w.length()];
			if (wordBreak(w, dict, 0, dp, 0)) {
				res.add(w);
			}
		}
		return res;
	}

	private boolean wordBreak(String word, Set<String> dict, int start, Boolean[] dp, int num) {
		if (start == word.length() && num >= 2) {
			return true;
		}
		if (start >= word.length()) {
			return false;
		}
		if (dp[start] != null) {
			return dp[start];
		}
		for (int i = start; i < word.length(); i++) {
			String cut = word.substring(start, i + 1);
			if (dict.contains(cut) && wordBreak(word, dict, i + 1, dp, num + 1)) {
				dp[start] = true;
				return true;
			}
		}
		dp[start] = false;
		return false;
	}
}
