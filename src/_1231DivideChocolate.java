public class _1231DivideChocolate {
	public int maximizeSweetness(int[] sweetness, int K) {
		int min = Integer.MAX_VALUE, sum = 0;
		for (int s : sweetness) {
			min = Math.min(min, s);
			sum += s;
		}
		int start = min, end = sum;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (valid(sweetness, mid, K + 1)) start = mid + 1;
			else end = mid - 1;
		}
		return end;
	}

	private boolean valid(int[] sweetness, int sum, int m) {
		int cur = 0, cnt = 0;
		for (int s : sweetness) {
			cur += s;
			if (cur >= sum) {
				cnt++;
				cur = 0;
			}
		}
		return cnt >= m;
	}
}
