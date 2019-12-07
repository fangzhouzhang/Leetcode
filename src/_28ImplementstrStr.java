public class _28ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) return -1;
		if (needle.length() == 0) return 0;
		int m = haystack.length(), n = needle.length();
		for (int i = 0; i < m; i++) {
			if (m - 1 - i + 1 < n) return -1;
			for (int j = 0; j < n; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
				if (j == n - 1) return i;
			}
		}
		return -1;
	}
}
