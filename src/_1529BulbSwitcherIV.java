public class _1529BulbSwitcherIV {
	public int minFlips(String target) {
		if (target == null || target.length() == 0) return 0;
		int status = 0, res = 0, n = target.length();
		for (int i = 0; i < n; i++) {
			if (target.charAt(i) - '0' != status) {
				status = status == 1 ? 0 : 1;
				res++;
			}
		}
		return res;
	}
}
