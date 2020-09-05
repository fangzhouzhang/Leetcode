import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1573NumberofWaystoSplitaString {
	private int M = 1000000007;
	public int numWays(String s) {
		List<Integer> ones = new ArrayList<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == '1') {
				ones.add(i);
			}
		}
		long[][] fac = new long[n + 1][3];
		for (int i = 1; i < fac.length; i++) {
			Arrays.fill(fac[i], 1);
			fac[i][1] = i;
		}
		for (int i = 1; i < fac.length; i++) {
			for (int j = 2; j < i && j < fac[i].length; j++) {
				fac[i][j] = (fac[i - 1][j - 1] + fac[i - 1][j]) % M;
			}
		}
		if (ones.size() == 0) {
			//comb
			return (int)fac[n - 1][2] % M;
		}
		if (ones.size() % 3 != 0) {
			return 0;
		}
		long res = 1l;
		int single = ones.size() / 3;
		for (int k = 0; k < 2; k++) {
			int diff = ones.get(single * (k + 1)) - ones.get(single * (k + 1) - 1);
			res = res * fac[diff][1] % M;
		}
		return (int)res;
	}
}
