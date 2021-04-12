import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1817FindingtheUsersActiveMinutes {
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] log: logs) {
			if (!map.containsKey(log[0])) map.put(log[0], new HashSet<>());
			map.get(log[0]).add(log[1]);
		}
		int[] res = new int[k];
		for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
			res[e.getValue().size() - 1]++;
		}
		return res;
	}
}
