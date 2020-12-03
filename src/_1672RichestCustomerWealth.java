public class _1672RichestCustomerWealth {
	public int maximumWealth(int[][] accounts) {
		int max = Integer.MIN_VALUE;
		for (int[] a : accounts) {
			int sum = 0;
			for (int n : a) {
				sum += n;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
