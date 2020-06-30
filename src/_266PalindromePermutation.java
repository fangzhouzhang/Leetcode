public class _266PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int[] map = new int[256];
		for (char c : s.toCharArray()) {
			map[c]++;
		}
		int res = 0;
		for (int n : map) {
			if (n % 2 == 1) {
				res++;
			}
			if (res > 1) return false;
		}
		return true;
	}
}
