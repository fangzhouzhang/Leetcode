public class H_Index {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int[] b = new int[citations.length + 1];
		for (int c : citations) {
			if (c >= n) {
				b[n]++;
			} else {
				b[c]++;
			}
		}
		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += b[i];
			if (count >= i) {
				return i;
			}
		}
		return -1;
	}
}
