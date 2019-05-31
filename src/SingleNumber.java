public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int xor = 0;
		for (int num: nums) {
			xor ^= num;
		}


		return xor;
	}
}
