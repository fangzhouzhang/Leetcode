public class _169MajorityElement {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     * time: o(n) space: o(1)
     */
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int candidate = nums[0], f1 = 1;
		for (int i = 1; i < nums.length; i++) {
			if (f1 == 0) {
				candidate = nums[i];
				f1 = 1;
			} else {
				if (nums[i] != candidate) {
					f1--;
				} else f1++;
			}
		}
		return candidate;
	}
}

