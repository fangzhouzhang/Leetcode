import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>(wordDict);
		StringBuilder sb = new StringBuilder();

		Boolean[] success = new Boolean[s.length()];//success[i] means from i to len - 1, whether we can find solution
		dfs(res, s, set, "", success, 0);
		return res;
	}
	private void dfs(List<String> res, String s, Set<String> set, String sb, Boolean[] success, int idx) {
		if (idx == s.length()) {
			res.add(new String(sb));
			return;
		}
		// idx < len
		if (success[idx] != null && !success[idx]) {
			return; //fail
		}

		int size = sb.length();
		int prev = res.size();

		for (int i = idx; i < s.length(); i++) {
			String cut = s.substring(idx, i + 1);
			if (set.contains(cut)) {
				if (size == 0) {
					dfs(res, s, set, sb + cut, success, i + 1);
				} else {
					dfs(res, s, set, sb + " " + cut, success, i + 1);
				}
			}
		}

		if (res.size() != prev) {
			success[idx] = true;
		} else {
			success[idx] = false;
		}
		//set back
		//sb.setLength(size);
	}
}
