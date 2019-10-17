public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		char[] arr = s.toCharArray();
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			if (arr[start] != arr[end]) {
				return isPalindrome(arr, start + 1, end) || isPalindrome(arr, start, end - 1);
			} else {
				start++; end--;
			}
		}
		return true;
	}

	private boolean isPalindrome(char[] arr, int i, int j) {
		while (i <= j) {
			if (arr[i] != arr[j]) return false;
			i++;
			j--;
		}
		return true;
	}
}
