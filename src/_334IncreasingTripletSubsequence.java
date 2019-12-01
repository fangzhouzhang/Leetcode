public class _334IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length <= 2) return false;
		int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n > mid) return true;
			else if (n < small) small = n;
			else if (small < n && n < mid) mid = n;
		}
		return false;
	}
}
