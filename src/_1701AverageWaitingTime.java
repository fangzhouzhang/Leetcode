public class _1701AverageWaitingTime {
	public double averageWaitingTime(int[][] customers) {
		if (customers == null || customers.length == 0) return 0;
		int n = customers.length;
		double nextAvail = customers[0][0], sum = 0;
		for (int i = 0; i < n; i++) {
			nextAvail = Math.max(nextAvail, customers[i][0]);
			nextAvail += customers[i][1];
			sum += nextAvail - customers[i][0];
		}
		return sum * 1.0 / n;
	}
}
