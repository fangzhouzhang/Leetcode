public class _268MissingNumber {
	//overflow
	public int missingNumber(int[] nums) {
		int sum = 0;
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i;
			curSum += nums[i];
		}
		sum += nums.length;
		return sum - curSum;
	}

	public int missingNumberXor(int[] nums) {
		//https://www.youtube.com/watch?v=lBk6fVhuCyw
		if (nums == null || nums.length == 0) return 0;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) res = res ^ nums[i];
		for (int i = 0; i <= nums.length; i++) res = res ^ i;
		return res;
	}
}
