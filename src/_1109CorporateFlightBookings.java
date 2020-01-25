public class _1109CorporateFlightBookings {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		if (bookings == null || bookings.length == 0) return new int[0];
		int[] res = new int[n];
		for (int[] b : bookings) {
			int start = b[0];
			int end = b[1];
			int num = b[2];
			for (int i = start; i <= end; i++) {
				res[i - 1] += num;
			}
		}
		return res;
	}
}
