public class _774MinimizeMaxDistancetoGasStation {
	private static final double ERROR = 1e-6;
	public double minmaxGasDist(int[] stations, int K) {
		if (stations == null || stations.length == 0) return 0;
		int n = stations.length;
		double l = 0, r = stations[n - 1] - stations[0];
		while (l + ERROR <= r) {
			double mid = (r + l) / 2;
			if (isOk(mid, stations, K)) r = mid;
			else l = mid + ERROR;
		}
		return r;
	}

	private boolean isOk(double mid, int[] s, int k) {
		int count = 0;
		for (int i = 1; i < s.length; i++) {
			int cur = s[i] - s[i - 1];
			count += Math.ceil(cur * 1.0 / mid) - 1;
		}
		return count <= k;
	}
}
