public class _367ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int start = 1, end = num;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == num / mid && num % mid == 0) return true;
			else if (mid < num / mid) start = mid + 1;
			else end = mid - 1;
		}
		return false;
	}
}
