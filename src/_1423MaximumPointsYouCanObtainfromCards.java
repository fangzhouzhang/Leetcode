public class _1423MaximumPointsYouCanObtainfromCards {
	public int maxScore(int[] cardPoints, int k) {
		if (cardPoints == null || cardPoints.length == 0) return 0;
		int n = cardPoints.length;
		if (n == k) {
			int sum = 0;
			for (int p : cardPoints) sum += p;
			return sum;
		}

		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += cardPoints[i];
			prefix[i + 1] = sum;
		}
		int len = n - k;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + len < prefix.length; i++) {
			min = Math.min(prefix[i + len] - prefix[i], min);
		}
		return sum - min;
	}
}
