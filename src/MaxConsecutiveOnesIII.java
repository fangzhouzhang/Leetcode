public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] A, int K) {
		int max = 0;
		int l = 0;
		int h = 0;
		int num = 0;
		while (h < A.length) {
			if (A[h] == 0) {
				num++;
			}
			while (num > K && l < h) {
				if (A[l] == 0) {
					num--;
				}
				l++;
			}
			if (l < h) {
				max = Math.max(max, h - l + 1);

			}
			h++;
		}
		return max;
	}
}
