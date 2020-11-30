import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _1048LongestStringChain {
	public int longestStrChain(String[] words) {
		Arrays.sort(words, new MyComparator());
		Map<String, Integer> map = new HashMap<>();
		int res = 1;
		for (String word : words) {
			int tmp = 1;
			for (int i = 0; i < word.length(); i++) {
				String cur = word.substring(0, i) + word.substring(i + 1);
				tmp = Math.max(tmp, map.getOrDefault(cur, 0) + 1);
			}
			res = Math.max(res, tmp);
			map.put(word, tmp);
		}
		return res;
	}

	private class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return a.length() - b.length();
		}
	}
}
