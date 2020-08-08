import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _336PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if (words == null || words.length == 0) return res;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(new StringBuilder(words[i]).reverse().toString(), i);
		}
		for (int k = 0; k < words.length; k++) {
			String word = words[k];
			String pre = null;
			String suf = null;
			int n = word.length();
			for (int i = 0; i < n; i++) {
				if (isPalindrome(word, 0, i)) {
					suf = word.substring(i + 1);
					if (map.containsKey(suf) && map.get(suf) != k) {
						addRes(res, map.get(suf), k);
					}
				}
			}

			for (int i = n - 1; i >= 0; i--) {
				if (isPalindrome(word, i, n - 1)) {
					pre = word.substring(0, i);
					if (map.containsKey(pre) && map.get(pre) != k) {
						addRes(res, k, map.get(pre));
					}
				}
			}
			if (map.containsKey(word) && map.get(word) != k) {
				addRes(res, k, map.get(word));
			}
		}
		return res;
	}

	public boolean isPalindrome(String s, int start, int end) {
		int i = start;
		int j = end;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	private void addRes(List<List<Integer>> res, int i, int j) {
		List<Integer> r = new ArrayList<>(Arrays.asList(i, j));
		res.add(r);
	}
}
