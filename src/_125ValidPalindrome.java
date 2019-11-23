public class _125ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}

		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			if (!isWord(s.charAt(i))) {
				i++;
			} else if (!isWord(s.charAt(j))) {
				j--;
			} else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			} else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
				i++;
				j--;
			}
		}
		return true;
	}
	private boolean isWord(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		if (c >= 'A' && c <= 'Z') {
			return true;
		}
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
}
