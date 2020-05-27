public class _186ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		int start = 0, end = s.length - 1;
		reverse(s, start, end);
		end = 0;
		start = 0;
		while (end < s.length) {
			while (end < s.length && s[end] != ' ') end++;
			reverse(s, start, end - 1);
			end++;
			start = end;
		}
		reverse(s, start, end - 1);
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}
}
