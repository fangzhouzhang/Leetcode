import java.util.ArrayList;
import java.util.List;

public class _247StrobogrammaticNumberII {
	private char[][] map = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
	public List<String> findStrobogrammatic(int n) {
		try {
			if (n < 0) throw new Exception();
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
		List<String> res = new ArrayList<>();
		if (n == 0) return res;
		char[] chs = new char[n];
		dfs(chs, 0, n - 1, res);
		return res;
	}

	private void dfs(char[] chs, int lo, int hi, List<String> res) {
		if (lo > hi) {
			if (chs.length == 1 || chs[0] != '0') res.add(String.valueOf(chs));
			return;
		}

		for (char[] m : map) {
			if (lo == hi && m[0] != m[1]) continue;
			chs[lo] = m[0];
			chs[hi] = m[1];
			dfs(chs, lo + 1, hi - 1, res);
		}
	}
}
