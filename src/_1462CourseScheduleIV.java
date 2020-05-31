import java.util.*;

public class _1462CourseScheduleIV {
	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		List<Boolean> res = new ArrayList<>();
		if (queries == null || queries.length == 0) return res;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Map<Integer, Set<Integer>> pre = new HashMap<>();
		int[] indegree = new int[n];
		for (int[] p : prerequisites) {
			if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
			map.get(p[0]).add(p[1]);
			indegree[p[1]]++;
		}

		Boolean[][] dp = new Boolean[n][n];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) q.add(i);
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				Set<Integer> set = map.get(cur);
				if (set == null) continue;
				for (int nei : set) {
					if (!pre.containsKey(nei)) pre.put(nei, new HashSet<>());
					pre.get(nei).add(cur);
					if (pre.get(cur) != null) pre.get(nei).addAll(pre.get(cur));
					indegree[nei]--;
					if (indegree[nei] == 0) q.add(nei);
				}
			}
		}

		for (int[] q1 : queries) {
			Set<Integer> set = pre.get(q1[1]);
			if (set != null && set.contains(q1[0])) res.add(true);
			else res.add(false);
		}

		return res;
	}
}
