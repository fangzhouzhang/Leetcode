import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		int[] arr = getUnpairNum(s);
		dfs(s, 0, arr[1], arr[2], res);
		return res;
	}

	private int[] getUnpairNum(String s) {
		int[] arr = new int[3];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') arr[0]++;
			else if (s.charAt(i) == ')' && arr[0] > 0) arr[0]--;
			else if (s.charAt(i) == ')' && arr[0] == 0) arr[2]++;
		}
		arr[1] = arr[0];
		return arr;
	}

	private void dfs(String s, int idx, int l, int r, List<String> res) {
		if (l == 0 && r == 0 && isValid(s)) {
			res.add(new String(s));
			return;
		}
		for (int i = idx; i < s.length(); i++) {
			if (i > idx && s.charAt(i) == s.charAt(i - 1)) continue;
			if (s.charAt(i) == '(' && l > 0) {
				String tmp = s.substring(0, i) + s.substring(i + 1);
				dfs(tmp, i, l - 1, r, res);
			}
			if (s.charAt(i) == ')' && r > 0) {
				String tmp = s.substring(0, i) + s.substring(i + 1);
				dfs(tmp, i, l, r - 1, res);
			}
		}
	}

	private boolean isValid(String tmp) {
		int l = 0;
		for (char c : tmp.toCharArray()) {
			if (c >= 'a' && c <= 'z') continue;
			if (c == '(') l++;
			else if (c == ')' && l > 0) l--;
			else return false;
		}
		return l == 0;
	}

}
