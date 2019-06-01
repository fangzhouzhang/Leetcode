public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		if (nums.length == 0) {
			return res;
		}
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}
		int mask = 1;
		while ((xor & mask) == 0) {
			mask <<= 1;
		}
		int ans = 0;
		for (int num : nums) {
			if ((num & mask) == 0) {
				ans ^= num;
			}
		}
		res[0] = ans;
		res[1] = ans ^ xor;
		return res;
	}
}
