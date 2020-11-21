import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _997FindtheTownJudge {
	private Set<Integer>[] trusts;
	public int findJudge(int N, int[][] trust) {
		trusts = new Set[N + 1];
		for (int i = 0; i < N + 1; i++) trusts[i] = new HashSet<>();
		for (int[] t : trust) {
			trusts[t[0]].add(t[1]);
		}
		List<Integer> idxs = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			if (trusts[i].size() == 0) idxs.add(i);
		}
		int cnt = 0, ans = 0;
		for (int idx : idxs) {
			boolean valid = true;
			for (int i = 1; i < N + 1; i++) {
				if (i == idx) continue;
				if (!trusts[i].contains(idx)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				cnt++;
				ans = idx;
			}
		}
		if (cnt == 1) return ans;
		return -1;
	}
}
