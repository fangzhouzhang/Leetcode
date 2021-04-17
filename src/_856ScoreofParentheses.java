public class _856ScoreofParentheses {
	public int scoreOfParentheses(String S) {
		int res = 0,d = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				d += 1;
			} else {
				d -= 1;
			}
			if (c == '(' && i + 1 < S.length() && S.charAt(i + 1) == ')') {
				res += 1 << (d - 1);
			}
		}
		return res;
	}
}
