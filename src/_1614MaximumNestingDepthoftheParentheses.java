public class _1614MaximumNestingDepthoftheParentheses {
	public int maxDepth(String s) {
		int res = 0, n = s.length(), cur = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				cur++;
				res = Math.max(res, cur);
			} else if (c == ')') {
				cur--;
			}
		}
		return res;
	}
}
