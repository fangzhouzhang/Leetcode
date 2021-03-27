import java.util.HashSet;
import java.util.Set;

public class _718MaximumLengthofRepeatedSubarray {
	int P = 131;
	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length;
		long[] ha = new long[n + 1];
		for (int i = 0 ; i < n; i++) {
			ha[i + 1] = ha[i] * P + A[i];
		}
		long[] hb = new long[m + 1];
		for (int i = 0 ; i < m; i++) {
			hb[i + 1] = hb[i] * P + B[i];
		}
		long[] p = new long[Math.max(n, m) + 1];
		p[0] = 1;
		for (int i = 1; i < p.length; i++) {
			p[i] = p[i - 1] * P;
		}
		int l = 0, r = Math.min(n, m);
		while (l < r) {
			int mid = l + r + 1 >> 1;
			boolean found = false;
			Set<Long> s1 = new HashSet<>();
			for (int i = mid; i <= n; i++) {
				s1.add(getValue(ha, i - mid + 1, i, p));
			}
			for (int i = mid; i <= m; i++) {
				if (s1.contains(getValue(hb, i - mid + 1, i, p))) {
					found = true;
					break;
				}
			}
			if (found) {
				l = mid;
			} else r = mid - 1;
		}
		return l;
	}

	private long getValue(long[] h, int l, int r, long[] p) {
		return h[r] - h[l - 1] * p[r - l + 1];
	}
}
