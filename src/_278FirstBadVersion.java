public class _278FirstBadVersion {
	public int firstBadVersion(int n) {
		int start = 1, end = n;
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

	private boolean isBadVersion(int mid) {
		return false;
	}
}
