public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean isPalin = true;
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				isPalin = false;
				break;
			}
		}

		if (isPalin == true) {
			return true;
		}
		boolean falseBreak = false;
		for (int skipPoint = 0; skipPoint < s.length(); skipPoint++) {
			falseBreak = false;
			int start = 0;
			int end = s.length() - 1;
			while (start <= end) {
				if (start == skipPoint) {
					start++;
				} else if (end == skipPoint) {
					end--;
				} else if (s.charAt(start) == s.charAt(end)) {
					start++;
					end--;
				} else {
					isPalin = false;
					falseBreak = true;
					break;
				}
			}
			if (falseBreak == false) {
				isPalin = true;

			}
			if (isPalin == true) {
				return true;
			}
		}
		return false;
	}
}
