import java.util.ArrayList;
import java.util.List;

public class _60PermutationSequence {
	public String getPermutation(int n, int k) {
		char[] str = new char[n];
		int idx = 0;
		k--;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) list.add(i);
		while (n > 0) {
			int q = k / getFactorial(n - 1);
			str[idx++] = (char)('0' + list.get(q));
			list.remove(q);
			k -= q * getFactorial(n - 1);
			n--;
		}
		return new String(str);
	}

	private int getFactorial(int n) {
		int res = 1;
		for (int i = n; i > 0; i--) res *= i;
		return res;
	}

	public String getPermutationII(int n, int k) {
		long[] a = new long[10];
		long cur = 1;
		for (int i = 1; i < 10; i++) {
			cur *= i;
			a[i] = cur;
		}
		a[0] = 1;
		StringBuilder sb = new StringBuilder();
		boolean[] use = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (use[j]) continue;
				if (a[n - i - 1] < k) k -= a[n - i - 1];
				else {
					sb.append(j);
					use[j] = true;
					break;
				}
			}
		}
		return new String(sb);
	}
}
