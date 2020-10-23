public class _1624LargestSubstringBetweenTwoEqualCharacters {
	public int maxLengthBetweenEqualCharacters(String s) {
		int n = s.length();
		int res = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					res = Math.max(res, j - i - 1);
					break;
				}
			}
		}
		return res;
	}
}
