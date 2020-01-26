public class _1328BreakaPalindrome {
	public String breakPalindrome(String palindrome) {
		if (palindrome == null || palindrome.length() <= 1) return "";
		char[] p = palindrome.toCharArray();
		for (int i = 0; i < palindrome.length() / 2; i++) {
			if (p[i] != 'a') {
				p[i] = 'a';
				return new String(p);
			}
		}
		p[palindrome.length() - 1] = 'b';
		return new String(p);
	}
}
