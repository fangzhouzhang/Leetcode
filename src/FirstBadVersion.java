public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (isBadVersion(n)) {
			int start = 1;
			int end = n;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (isBadVersion(mid)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			return start;
		}
		return -1;
	}
	private boolean isBadVersion(int n) {
		return false;
	}
}
