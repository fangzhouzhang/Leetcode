public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;
		for (int num : nums) {
			if (small >= num) {
				small = num;
			} else if (big >= num) {
				big = num;
			} else {
				return true;
			}
		}
		return false;
	}
}
