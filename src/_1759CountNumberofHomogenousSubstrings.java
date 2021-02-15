import java.util.ArrayList;
import java.util.List;

public class _1759CountNumberofHomogenousSubstrings {
	int M = 1000000007;
	public int countHomogenous(String s) {
		if (s == null || s.length() == 0) return 0;
		int l = 0, r = 0, n = s.length();
		List<Integer> pairs = new ArrayList<>();
		while (r < n) {
			if (s.charAt(r) == s.charAt(l)) r++;
			else {
				pairs.add((r - l));
				l = r;
			}
		}
		pairs.add((r - l));
		long res = 0;
		for (int len : pairs) {
			long sum = (1 + (long)len) * (long)len / 2;
			res = (res + sum) % M;
		}
		return (int)res;
	}
}
