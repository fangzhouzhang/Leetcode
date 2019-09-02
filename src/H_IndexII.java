public class H_IndexII {
	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		int start = 0;
		int end = citations.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == citations.length - 1 - mid + 1) {
				return citations[mid];
			}
			else if (citations[mid] < citations.length - 1 - mid + 1) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return citations.length - start;
	}
}
