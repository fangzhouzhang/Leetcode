import java.util.*;

public class _210CourseScheduleII {
	/**
	 * time: o(v + e) e [v, v^2]
	 * 
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return new int[0];
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] p : prerequisites) {
			indegree[p[0]]++;
			if (!map.containsKey(p[1])) map.put(p[1], new ArrayList<>());
			map.get(p[1]).add(p[0]);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> ans = new ArrayList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				ans.add(cur);
				if (map.get(cur) == null) continue;
				for (int nei : map.get(cur)) {
					indegree[nei]--;
					if (indegree[nei] == 0) {
						q.add(nei);
					}
				}
			}
		}
		if (ans.size() != numCourses) {
			return new int[0];
		}
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++) res[i] = ans.get(i);
		return res;
	}
}
