import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		int[] d = new int[1];
		findMaxDepth(nestedList, d);
		int depth = d[0];

		Queue<NestedInteger> q = new LinkedList<>();
		for (NestedInteger ni : nestedList) {
			q.add(ni);
		}
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				NestedInteger ni = q.poll();
				if (ni.isInteger() == true) {
					res += ni.getInteger() * depth;
				} else {
					List<NestedInteger> list = ni.getList();
					if (list != null) {
						for (NestedInteger n : list) {
							q.add(n);
						}
					}
				}
			}
			depth--;
		}
		return res;
	}
	private void findMaxDepth(List<NestedInteger> nestedList, int[] depth) {
		for (NestedInteger ni : nestedList) {
			// int temp = 0;
			getDepth(1, ni, depth);
		}
	}
	private void getDepth(int level, NestedInteger ni, int[] depth) {
		if (ni.isInteger()) {
			depth[0] = Math.max(depth[0], level);
			return;
		}
		List<NestedInteger> list = ni.getList();
		for (NestedInteger n : list) {
			// int temp = 0;
			getDepth(level + 1, n, depth);
		}
	}
	private class NestedInteger {

		public boolean isInteger() {
			return false;
		}

		public int getInteger() {
			return 0;
		}

		public List<NestedInteger> getList() {
			return null;
		}
	}
}
