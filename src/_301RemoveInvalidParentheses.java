import java.util.ArrayList;
import java.util.List;

public class _301RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			res.add("");
			return res;
		}
		//arr[0] accumulated (
		//arr[1] must correct ( number
		//arr[2] must correct ) number
		int[] arr = new int[3];

		count(arr, s);
		dfs(s, 0, arr[1], arr[2], res);
		return res;
	}

	private void dfs(String s, int idx, int l, int r, List<String> res) {
		if (l == 0 && r == 0 && isValid(s)) {
			res.add(s);
			return;
		}
		int n = s.length();
		for (int i = idx; i < n; i++) {

			char c = s.charAt(i);
			if (i > idx && s.charAt(i - 1) == c) continue;
			if (c == '(' && l > 0) {
				dfs(s.substring(0, i) + s.substring(i + 1), i, l - 1, r, res);
			}
			if (c == ')' && r > 0) {
				dfs(s.substring(0, i) + s.substring(i + 1), i, l, r - 1, res);
			}
		}
	}

	private boolean isValid(String s) {
		int l = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				l++;
			} else if (c == ')' && l > 0) {
				l--;
			} else if (c == ')' && l == 0) {
				return false;
			}
		}
		return l == 0;
	}

	private void count(int[] arr, String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				arr[0]++;
			} else if (c == ')' && arr[0] > 0) {
				arr[0]--;
			} else if (c == ')' && arr[0] == 0) {
				arr[2]++;
			}
		}
		arr[1] = arr[0];
	}
}
