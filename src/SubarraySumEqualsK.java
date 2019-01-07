public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1 && nums[0] == k) {
			return 1;
		} else if (nums.length == 1 && nums[0] != k) {
			return 0;
		}
		int[] prefix = new int[nums.length + 1];
		int temp = 0;
		for (int i = 1; i < prefix.length; i++) {
			temp += nums[i - 1];
			prefix[i] = temp;
		}
		int res = 0;
		for (int i = 0; i < prefix.length - 1; i++) {
			for (int j = i + 1; j < prefix.length; j++) {
				if (prefix[j] - prefix[i] == k) {
					res++;
				}
			}
		}
		return res;
	}

}
