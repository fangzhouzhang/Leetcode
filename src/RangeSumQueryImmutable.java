public class RangeSumQueryImmutable {
	private int[] prefix;
	public RangeSumQueryImmutable(int[] nums) {
		this.prefix = new int[nums.length + 1];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return prefix[j + 1] - prefix[i];
	}
}
