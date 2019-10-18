public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		int[] cnt = new int[32];
		int len = nums.length;
		int res = 0;
		for (int num1 : nums) {
			int num = num1;
			int idx = 0;
			while (num > 0) {
				if ((num & 1) == 1) {
					cnt[idx] += 1;
				}
				num >>= 1;
				idx++;
			}
		}
		for (int n : cnt) {
			res += n * (len - n);
		}
		return res;
	}
}
