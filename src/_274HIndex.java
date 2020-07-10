public class _274HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) return 0;
		int n = citations.length;
		int[] arr = new int[n + 1];
		for (int c : citations) {
			if (c >= n) {
				arr[n]++;
			} else {
				arr[c]++;
			}
		}
		int total = 0;
		for (int i = n; i >= 0; i--) {
			total += arr[i];
			if (total >= i) return i;
		}
		return 0;
	}
}
