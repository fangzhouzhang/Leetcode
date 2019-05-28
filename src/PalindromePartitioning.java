import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add(new ArrayList<String>());
			return res;
		}
		dfs(res, s, 0, new ArrayList<String>());
		return res;
	}
	private void dfs(List<List<String>> res, String s, int idx, List<String> temp) {
		if (idx == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = idx; i < s.length(); i++) {

			if (isPalin(s, idx, i)) {
				String cut = s.substring(idx, i + 1);
				temp.add(cut);
				dfs(res, s, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	private boolean isPalin(String s, int l, int r) {
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
