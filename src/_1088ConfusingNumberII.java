import java.util.HashMap;
import java.util.Map;

public class _1088ConfusingNumberII {
	private Map<Integer, Integer> map = new HashMap<>();
	private int res = 0;
	private int N = 0;
	public int confusingNumberII(int N) {
		this.N = N;
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		dfs(1, 1, 10);
		dfs(6, 9, 10);
		dfs(8, 8, 10);
		dfs(9, 6, 10);
		return res;
	}

	private void dfs(long cur, long revert, long multi) {
		if (cur > N) return;
		if (cur != revert) {
			res++;
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			dfs(cur * 10 + e.getKey(), revert + e.getValue() * multi, multi * 10);
		}
	}
}
