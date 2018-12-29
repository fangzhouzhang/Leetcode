public class MissingNumber {
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
}
