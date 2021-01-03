import java.util.HashSet;
import java.util.Set;

public class _526BeautifulArrangement {
	int res = 0;
	Set<Integer> visit;
	int n = 0;
	public int countArrangement(int n) {
		this.n = n;
		visit = new HashSet<>();
		dfs(1);
		return res;
	}

	private void dfs(int idx) {
		if (idx == n + 1) {
			res++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit.contains(i) || (i % idx != 0 && idx % i != 0)) continue;
			visit.add(i);
			dfs(idx + 1);
			visit.remove(i);
		}
	}
}
