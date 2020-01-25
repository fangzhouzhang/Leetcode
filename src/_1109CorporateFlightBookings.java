public class _1109CorporateFlightBookings {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		if (bookings == null || bookings.length == 0) return new int[0];
		int[] res = new int[n];
		int[] diff = new int[n + 2];
		for (int[] b : bookings) {
			diff[b[0]] += b[2];
			diff[b[1] + 1] -= b[2];
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += diff[i];
			res[i - 1] = sum;
		}
		return res;
	}
}
