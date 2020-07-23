public class _647PalindromicSubstrings {
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length();
		int res = 0;
		char[] a = s.toCharArray();
		for (int k = 0; k < 2 * n - 1; k++) {
			for (int i = 0; i < 2; i++) {
				int left = k;
				int right = left + i % 2;
				while (left >= 0 && right < n) {
					if (a[left] != a[right]) break;
					left--;
					right++;
					res++;
				}
			}
		}
		return res;
	}
}
