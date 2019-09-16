public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int res = 0;
		int exe = x ^ y;
		for (int i = 0; i < 32; i++) {
			res += (exe >> i) & 1;
		}
		return res;
	}
}
