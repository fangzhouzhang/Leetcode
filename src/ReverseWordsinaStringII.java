public class ReverseWordsinaStringII {
	public void reverseWords(char[] str) {
		if (str == null || str.length == 0) {
			return;
		}
		int start = 0;
		int end = str.length - 1;
		reverse(str, start, end);
		start = 0;
		end = start;
		while (end < str.length) {
			if (str[start] == ' ') {
				start++;
				end++;
			} else {
				while (end < str.length && str[end] != ' ') {
					end++;
				}
				reverse(str, start, end - 1);
				start = end;
			}
		}
	}
	private void reverse(char[] arr, int start, int end) {
		while (start <= end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	private void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}
