public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] arr = new char[26];
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			arr[idx]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int idx = t.charAt(i) - 'a';
			if (arr[idx] == 0) {
				return false;
			} else {
				arr[idx]--;
			}
		}
		for (int num : arr) {
			if (num != 0) {
				return false;
			}
		}
		return true;
	}
}
