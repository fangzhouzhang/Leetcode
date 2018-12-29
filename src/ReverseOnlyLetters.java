public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] arr = s.toCharArray();

		int slow = 0;
		int fast = arr.length - 1;

		while (slow <= fast) {
			if (isValid(arr, slow) && isValid(arr, fast)) {
				swap(arr, slow, fast);
				fast--;
				slow++;
			} else if (isValid(arr, slow) == true && isValid(arr, fast) == false) {
				fast--;
			} else if (isValid(arr, slow) == false && isValid(arr, fast) == true) {
				slow++;
			} else {
				fast--;
				slow++;
			}
		}

		return new String(arr);
	}
	private boolean isValid(char[] arr, int i) {
		if (i < 0 || i >= arr.length) {
			return false;
		}
		if ((arr[i] >= 'a' && arr[i] <='z') || (arr[i] >= 'A' && arr[i] <='Z')) {
			return true;
		}
		return false;
	}
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
