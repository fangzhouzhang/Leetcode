public class SingleNumberII {
	public int singleNumber(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] a = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				if ((num & 1) == 1) {
					a[i]++;
				}
				num >>= 1;
			}
		}

		int res = 0;
		for (int i = 0; i < 32; i++) {
			if (a[i] % 3 == 1) {
				res += (1 << i);
			}
		}
		return res;
	}
}
