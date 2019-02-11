import java.util.Arrays;

public class SlidingWindowMedian {
	public double[] medianSlidingWindow(int[] nums, int k) {
		double[] res = new double[nums.length - k + 1];
		int[] temp = new int[k];
		for (int i = 0; i < nums.length - k + 1; i++) {
			findMedian(res, nums, i, k, temp);
		}
		return res;
	}
	private void findMedian(double[] res, int[] nums, int start, int k, int[] temp) {
		// System.out.println(start + "....." + k);
		for (int i = start; i < start + k; i++) {
			temp[i - start] = nums[i];
		}
		Arrays.sort(temp);
		if (k % 2 == 0) {
			long num1 = temp[k / 2];
			long num2 = temp[(k / 2) - 1];

			double mid = (num1 - num2) * 1.0 / 2 + num2;
			res[start] = mid;
		} else {
			res[start] = temp[k / 2] * 1.0;
		}
	}
}
