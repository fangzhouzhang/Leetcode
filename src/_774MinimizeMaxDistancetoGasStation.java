public class _774MinimizeMaxDistancetoGasStation {
	public double minmaxGasDist(int[] stations, int K) {
		if (stations == null || stations.length == 0) return 0;
		double start = 0;
		double end = stations[stations.length - 1] - stations[0];
		while (end - start > 1e-6) {
			double mid = start + (end - start) / 2;
			if (isValid(mid, stations, K)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return start;
	}

	private boolean isValid(double mid, int[] stations, int K) {
		int sum = 0, n = stations.length;
		for (int i = 1; i < n; i++) {
			double dist = stations[i] - stations[i - 1];
			sum += Math.ceil(dist / mid) - 1;
			if (sum > K) return false;
		}
		return sum <= K;
	}
}
