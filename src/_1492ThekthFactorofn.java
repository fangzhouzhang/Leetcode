import java.util.TreeSet;

public class _1492ThekthFactorofn {
	public int kthFactor(int n, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				set.add(i);
				set.add((n / i));
			}
		}
		int t = 1;
		for (int num : set) {
			if (t == k) return num;
			t++;
		}
		return -1;
	}
}
