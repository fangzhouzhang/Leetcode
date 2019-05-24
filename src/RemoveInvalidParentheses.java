import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		int[] arr = new int[3];
		getUnbalancedNumber(s, arr);
		// dfs(arr[1], arr[2], s, 0, res);
		// System.out.println("l " + arr[1] + " r " + arr[2]);
		dfs1(arr[1], arr[2], s, 0, res, new StringBuilder(), 0, new HashSet<String>());
		return res;
	}
	private void getUnbalancedNumber(String s, int[] arr) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				arr[0]++;
			} else if (ch ==')' && arr[0] > 0) {
				arr[0]--;
			} else if (ch ==')' && arr[0] == 0) {
				arr[2]++;
			}
		}
		arr[1] = arr[0];
	}
	/**

	 (()))
	 (()))   (( ))
	 **/
	private void dfs1(int l, int r, String s, int idx, List<String> res, StringBuilder sb, int delta, Set<String> set) {
		if (idx == s.length() && l == 0 && r == 0 && delta == 0) {

			String ans = new String(sb);
			if (set.add(ans)) {
				res.add(ans);
			}

			return;
		}
		if (idx >= s.length() || l < 0 || r < 0 || delta < 0) {
			return;
		}
		char ch = s.charAt(idx);
		int prevLen = sb.length();
		if (ch == '(') {
			//keep
			sb.append('(');
			dfs1(l, r, s, idx + 1, res, sb, delta + 1, set);
			sb.setLength(prevLen);

			//delete
			// int nextIdx = idx + 1;
			dfs1(l - 1, r, s, idx + 1, res, sb, delta, set);
		} else if (ch == ')') {
			//keep
			sb.append(')');
			dfs1(l, r, s, idx + 1, res, sb, delta - 1, set);
			sb.setLength(prevLen);

			//delete
			// int nextIdx = idx + 1;
			dfs1(l, r - 1, s, idx + 1, res, sb, delta, set);
		} else {
			//keep
			sb.append(ch);
			dfs1(l, r, s, idx + 1, res, sb, delta, set);
			sb.setLength(prevLen);
		}
	}
}
