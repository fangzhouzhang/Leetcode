public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] count = new int[128];
		for (char c : s.toCharArray()) {
			count[c]++;
		}

		int sum = 0;
		for (int c : count) {
			sum += c / 2 * 2;
			if (sum % 2 == 0 && c % 2 == 1) {
				sum++;
			}
		}
		return sum;
	}
}
