public class _1541MinimumInsertionstoBalanceaParenthesesString {
	public int minInsertions(String s) {
		if (s == null || s.length() == 0) return 0;
		int left = 0;
		int res = 0;
		int idx = 0;
		while (idx < s.length()) {
			if (s.charAt(idx) == '(') {
				left++;
				idx++;
			} else {
				if (idx + 1 < s.length() && s.charAt(idx + 1) == ')') {
					left--;
					idx += 2;
				} else {
					res++;
					left--;
					idx += 1;
				}
				if (left < 0) {
					res++;
					left = 0;
				}
			}
		}
		res += left * 2;
		return res;
	}
}
