public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (isBadVersion(1) == true) {
			return 1;
		}
		if (isBadVersion(n) == true) {
			int start = 1;
			int end = n;
			int mid = start + (end - start) / 2;
			while (start + 1 < end) {
				mid = start + (end - start) / 2;
				if (isBadVersion(mid) == true) {
					end = mid;
				} else {
					start = mid;
				}
			}
			if (isBadVersion(start) == true) {
				return start;
			}
			if (isBadVersion(end) == true) {
				return end;
			}


		}
		return -1;
	}
	private boolean isBadVersion(int n) {
		return false;
	}
}
