public class _1332RemovePalindromicSubsequences {
	public int removePalindromeSub(String s) {
		if (s == null || s.length() == 0) return 0;
		if (isPalin(s, 0, s.length() - 1)) return 1;
		return 2;
	}

	private boolean isPalin(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}
