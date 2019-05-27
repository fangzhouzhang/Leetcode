import java.util.LinkedList;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> a = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			a.add((char)('0' + i + 1));
		}
		// String[] res = new String[1];

		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++) {
			fac[i] = fac[i - 1] * i;
		}

		k--;

		for (int i = n - 1; i >= 0; i--) {
			int pos = k / fac[i];
			sb.append(a.get(pos));
			a.remove(pos);
			k %= fac[i];
		}
		return new String(sb);
	}
}
