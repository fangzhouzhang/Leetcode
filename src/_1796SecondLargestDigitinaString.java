public class _1796SecondLargestDigitinaString {
	public int secondHighest(String s) {
		Boolean[] nums = new Boolean[10];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				nums[c - '0'] = true;
			}
		}
		int cnt = 0;
		for (int i = 9; i >= 0; i--) {
			if (nums[i] != null) {
				cnt++;
				if (cnt == 2) return i;
			}
		}
		return -1;
	}
}
