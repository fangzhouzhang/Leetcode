import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1289MaximumCandiesYouCanGetfromBoxes {
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		Set<Integer> key = new HashSet<>();
		for (int b : initialBoxes) {
			for (int k : keys[b]) {
				key.add(k);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int b : initialBoxes) {
			q.add(b);
		}
		int res = 0;
		boolean open = q.size() > 0;
		while (!q.isEmpty() && open) {
			int size = q.size();
			for (int m = 0; m < size; m++) {
				int cur = q.poll();
				if (status[cur] == 1 || key.contains(cur)) {
					open = true;
					res += candies[cur];
					for (int cb : containedBoxes[cur]) {
						q.add(cb);
						for (int k : keys[cb]) {
							key.add(k);
						}
					}
				} else {
					open = false;
				}
			}
		}
		return res;
	}
}
