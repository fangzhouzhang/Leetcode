import java.util.HashSet;
import java.util.Set;

public class _1461CheckIfaStringContainsAllBinaryCodesofSizeK {
	private int M = 1000000007;
	public boolean hasAllCodes(String s, int k) {
		if (s == null || s.length() == 0) return true;
		if (k == 0) return true;
		int n = s.length();
		if (k >= n) return false;
		int max = (1 << k) - 1;
		Set<Integer> set = new HashSet<>();
		int val = 0;
		int aL = 1;
		for (int i = 0; i < k; i++) {
			int cur = s.charAt(i) - '0';
			val = (val * 2 + cur) % M;
			aL = aL * 2 % M;
		}
		set.add(val);

		for (int i = k; i < n; i++) {
			int del = s.charAt(i - k) - '0';
			int cur = s.charAt(i) - '0';
			val = (val * 2 - del * aL % M + M) % M;
			val = (val + cur) % M;
			if (val > max) continue;
			set.add(val);
		}
		return set.size() == (1 << k);
	}
}
