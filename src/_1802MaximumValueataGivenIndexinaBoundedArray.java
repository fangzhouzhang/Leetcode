public class _1802MaximumValueataGivenIndexinaBoundedArray {
	public int maxValue(int n, int index, int maxSum) {
		maxSum -= n;
		int l = 0, r = maxSum;

		while (l < r) {
			int mid = (l + r + 1) / 2;
			int ll = Math.max(0, mid - index);
			int rr = Math.max(0, mid - (n - 1 - index));
			long sum = (long)(ll + mid) * (mid - ll + 1) / 2 + (long)(mid + rr) * (mid - rr + 1) / 2;
			if (sum - mid <= maxSum) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return (l + 1);
	}
}
