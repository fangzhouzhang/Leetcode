public class _727MinimumWindowSubsequence {
	public String minWindow(String S, String T) {
		int res = Integer.MAX_VALUE, left = -1;
		int i = 0, j = 0, tmp_end = -1;
		while (i < S.length()) {
			if (S.charAt(i) == T.charAt(j)) {
				j++;
				if (j == T.length()) {
					j -= 1;
					tmp_end = i;
					while (j >= 0) {
						if (S.charAt(i) == T.charAt(j)) {
							j--;
						}
						i--;
					}
					j = 0;
					i += 1;
					if (tmp_end - i + 1 < res) {
						left = i;
						res = tmp_end - i + 1;
					}
				}
			}
			i++;
		}
		return res == Integer.MAX_VALUE ? "" : S.substring(left, left + res);
	}
}
