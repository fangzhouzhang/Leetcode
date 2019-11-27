public class _169MajorityElement {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     * time: o(n) space: o(1)
     */
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int res = 0, cnt = 0;
		for (int n : nums) {
			if (cnt == 0) {
				res = n;
				cnt++;
			} else if (cnt > 0 && res != n) cnt--;
			else if (cnt > 0 && res == n) cnt++;
		}
		return res;
	}

}

