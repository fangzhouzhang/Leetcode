public class CountingBits {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i < res.length; i++) {
			res[i] = res[i & (i - 1)] + 1;
		}
		return res;
	}
}