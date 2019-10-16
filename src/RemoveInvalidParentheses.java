import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	private Set<String> set = new HashSet<>();
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		int[] arr = getUnpaired(s);
		dfs(s, new StringBuilder(), 0, res, arr[1], arr[2]);
		return res;
	}

	private int[] getUnpaired(String s) {
		int[] arr = new int[3];
		for (char c : s.toCharArray()) {
			if (c == '(') {
				arr[0]++;
			} else if (c == ')' && arr[0] > 0) {
				arr[0]--;
			} else if (c == ')' && arr[0] == 0) {
				arr[2]++;
			}
		}
		arr[1] = arr[0];
		return arr;
	}

	private void dfs(String s, StringBuilder sb, int idx, List<String> res, int l, int r) {
		if (l == 0 && r == 0 && isValid(sb) && idx == s.length()) {
			set.add(new String(sb));
			res.add(new String(sb));
			return;
		}

		if (idx == s.length()) return;
		int prev = sb.length();
		char c = s.charAt(idx);
		if (Character.isLetter(c)) {
			sb.append(c);
			dfs(s, sb, idx + 1, res, l, r);
			sb.setLength(prev);
			return;
		}

		if (c == '(' && l > 0) {
			//add '('
			sb.append(c);
			dfs(s, sb, idx + 1, res, l, r);
			sb.setLength(prev);

			//do not add '('
			dfs(s, sb, idx + 1, res, l - 1, r);
			return;
		} else if (c == '(' && l == 0) {
			//add '('
			sb.append(c);
			dfs(s, sb, idx + 1, res, l, r);
			sb.setLength(prev);
		}

		if (c == ')' && r > 0) {
			//add ')'
			sb.append(c);
			dfs(s, sb, idx + 1, res, l, r);
			sb.setLength(prev);

			//do not add ')'
			dfs(s, sb, idx + 1, res, l, r - 1);
			return;
		} else if (c == ')' && r == 0) {
			//add '('
			sb.append(c);
			dfs(s, sb, idx + 1, res, l, r);
			sb.setLength(prev);
		}


	}

	private boolean isValid(StringBuilder sb) {
		if (set.contains(new String(sb))) return false;
		int l = 0;
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '(') l++;
			else if (c == ')' && l > 0) l--;
			else if (c == ')' && l == 0) return false;
		}
		return l == 0;
	}

}
