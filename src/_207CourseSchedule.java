import java.util.*;

public class _207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return true;
		if (prerequisites == null || prerequisites.length == 0) return true;
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] p : prerequisites) {
			indegree[p[0]]++;
			if (!map.containsKey(p[1])) {
				map.put(p[1], new ArrayList<Integer>());
			}
			map.get(p[1]).add(p[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				set.add(i);
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (map.get(cur) == null) continue;
				for (int nei : map.get(cur)) {
					indegree[nei]--;
					if (indegree[nei] == 0) {
						q.add(nei);
						set.add(nei);
					}
				}
			}
		}
		return set.size() == numCourses;
	}
}
