public class _275HIndexII {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) return 0;
		int n = citations.length;
		int l = 0, r = n;
		while (l < r) {
			int mid = l + r + 1 >> 1;
			if (mid <= citations[n - mid]) l = mid;
			else r = mid - 1;
		}
		return l;
	}
}
