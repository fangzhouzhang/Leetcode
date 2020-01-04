import java.util.*;

public class _210CourseScheduleII {
	/**
	 * time: o(v + e) e [v, v^2]
	 * 
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null) return new int[0];
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] indegrees = new int[numCourses];
		for (int[] p : prerequisites) {
			indegrees[p[0]]++;
			if (!map.containsKey(p[1])) map.put(p[1], new ArrayList<Integer>());
			map.get(p[1]).add(p[0]);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) q.add(i);
		}
		int[] res = new int[numCourses];
		int idx = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			res[idx++] = cur;
			if (!map.containsKey(cur) || map.get(cur).size() == 0) continue;
			for (int n : map.get(cur)) {
				indegrees[n]--;
				if (indegrees[n] == 0) q.add(n);
			}
		}
		if (idx == numCourses) return res;
		return new int[0];
	}
}
