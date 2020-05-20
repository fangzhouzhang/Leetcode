public class _151ReverseWordsinaString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) return "";
		s = s.trim();
		if (s.length() == 0) return "";
		boolean meetChar = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!meetChar && c == ' ') {

			} else {
				meetChar = true;
				sb.append(c);
			}
		}
		sb = sb.reverse();
		char[] arr = new char[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			arr[i] = sb.charAt(i);
		}
		int slow = 0, fast = 0;
		while (fast < arr.length) {
			while (fast < arr.length && arr[fast] != ' ') fast++;
			if (fast == arr.length || arr[fast] == ' ') {
				int m = slow, n = fast - 1;
				while (m < n) {
					char tmp = arr[m];
					arr[m] = arr[n];
					arr[n] = tmp;
					m++;
					n--;
				}
			}
			while (fast < arr.length && arr[fast] == ' ') fast++;
			slow = fast;
		}

		StringBuilder sb1 = new StringBuilder();
		slow = 0;fast = 0;
		while (fast < arr.length) {
			while (fast < arr.length && arr[fast] != ' ') fast++;
			if (fast == arr.length || arr[fast] == ' ') {
				for (int i = slow; i < fast; i++) {
					sb1.append(arr[i]);
				}
				sb1.append(' ');
			}
			while (fast < arr.length && arr[fast] == ' ') fast++;
			slow = fast;
		}
		sb1.deleteCharAt(sb1.length() - 1);
		return new String(sb1);
	}
}
