public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int start = 0;
		int end = s.length() - 1;
		char[] arr = s.toCharArray();
		while (start < end) {
			while (start < end && isVowel(s.charAt(start)) == false) {
				start++;
			}
			while (start < end && isVowel(s.charAt(end)) == false) {
				end--;
			}
			if (start < end) {
				swap(arr, start, end);
				start++;
				end--;
			}

		}
		// for (char ch : arr) {
		//     System.out.print(ch);
		// }
		return String.valueOf(arr);
	}
	private void swap(char[] arr, int start, int end) {
		char temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	private boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
			return true;
		}
		return false;
	}
}
