import java.util.*;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		if (prerequisites.length == 0) {
			for (int i = 0; i < res.length; i++) {
				res[i] = i;
			}
			return res;
		}
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> neighbors = new HashMap<>();
		buildMap(prerequisites, indegree, neighbors, numCourses);

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();

		int index = 0;
		// printMap(indegree);
		// printMap1(neighbors);

//         while (index < numCourses) {
		for (Integer key: indegree.keySet()) {
			if (indegree.get(key) == 0 && set.add(key)) {
				q.add(key);
				while (!q.isEmpty()) {
					Integer num = q.poll();
					List<Integer> list = neighbors.get(num);
					if (list != null) {
						for (Integer outdegree: neighbors.get(num)) {
							indegree.put(outdegree, indegree.get(outdegree) - 1);
							if (indegree.get(outdegree) == 0 &&
									set.add(outdegree)) {
								q.add(outdegree);

							}
						}
					}
					if (indegree.get(num) == 0) {
						res[index++] = num;
					}
				}
			}
		}
//         }

		if (index == res.length) {
			return res;

		} else {
			return new int[0];
		}
	}

	private void buildMap(int[][] prerequisites,
						  Map<Integer, Integer> indegree,
						  Map<Integer, List<Integer>> neighbors,
						  int n) {
		for (int i = 0; i < n; i++) {
			indegree.put(i, 0);
		}
		for (int[] arr : prerequisites) {
			if (indegree.containsKey(arr[0])) {
				indegree.put(arr[0], indegree.get(arr[0]) + 1);
			} else {
				indegree.put(arr[0], 1);
			}
			if (indegree.containsKey(arr[1])) {

			} else {
				indegree.put(arr[1], 0);
			}
			if (neighbors.containsKey(arr[1])) {
				List<Integer> neigh = neighbors.get(arr[1]);
				neigh.add(arr[0]);
				neighbors.put(arr[1], neigh);
			} else {
				List<Integer> neigh = new ArrayList<>();
				neigh.add(arr[0]);
				neighbors.put(arr[1], neigh);
			}
			if (neighbors.containsKey(arr[0])) {

			} else {
				List<Integer> neigh = new ArrayList<>();
				// neigh.add(arr[0]);
				neighbors.put(arr[0], neigh);
			}
		}
	}
}
