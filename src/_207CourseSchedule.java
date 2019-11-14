import java.util.LinkedList;
import java.util.Queue;

public class _207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		for (int[] prerequisite : prerequisites) {
			indegree[prerequisite[0]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int took = q.poll();
			for (int[] prerequisite : prerequisites) {
				if (took == prerequisite[1]) {
					if (--indegree[prerequisite[0]] == 0) {
						q.add(prerequisite[0]);
					}
				}
			}
		}
		for (int anIndegree : indegree) {
			if (anIndegree != 0) {
				return false;
			}
		}
		return true;
	}
}
