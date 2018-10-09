import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		int[] arr = new int[3];
		getUnbalancedNumber(s, arr);
		dfs(arr[1], arr[2], s, 0, res);
		return res;
	}
	private void getUnbalancedNumber(String s, int[] arr) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				arr[0]++;
			} else if (arr[0] > 0 && ch == ')') {
				arr[0]--;
			} else if (arr[0] == 0 && ch == ')') {
				arr[2]++;
			}
		}
		arr[1] = arr[0];
	}
	private void dfs(int l, int r, String s, int start, List<String> res) {
		if (l == 0 && r == 0 && isValid(s)) {
			res.add(new String(s));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i > start && ch == s.charAt(i - 1)) {
				continue;
			}
			if (l > 0 && ch == '(') {
				dfs(l - 1, r, s.substring(0, i) + s.substring(i + 1), i, res);
			} else if (r > 0 && ch == ')') {
				dfs(l, r - 1, s.substring(0, i) + s.substring(i + 1), i, res);
			}
		}
	}
	private boolean isValid(String s) {
		int l = 0;//left parenthesis needed to be matched
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				l++;
			} else if (l > 0 && ch == ')') {
				l--;
			} else if (l == 0 && ch == ')') {
				return false;
			}
		}
		return l == 0;
	}
}
