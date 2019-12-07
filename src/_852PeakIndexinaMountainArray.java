public class _852PeakIndexinaMountainArray {
	public int peakIndexInMountainArray(int[] A) {
		if (A == null || A.length < 3) return -1;
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < A[mid + 1]) start = mid + 1;
			else end = mid - 1;
		}
		return start;
	}
}
