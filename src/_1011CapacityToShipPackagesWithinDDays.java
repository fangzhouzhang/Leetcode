public class _1011CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int D) {
		if (weights == null || weights.length == 0) return 0;
		int l = Integer.MIN_VALUE, r = 0;
		for (int w: weights) {
			l = Math.max(l, w);
			r += w;
		}
		while (l < r) {
			int mid = l + r >> 1;
			if (check(weights, mid, D)) r = mid;
			else l = mid + 1;
		}
		return l;
	}

	private boolean check(int[] w, int load_per_day, int max_time) {
		int t = 0, cur = 0;
		for (int x : w) {
			if (cur + x <= load_per_day) {
				cur += x;
			} else {
				t++;
				cur = x;
			}
		}
		return ++t <= max_time;
	}
}
