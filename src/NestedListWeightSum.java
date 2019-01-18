import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		Queue<NestedInteger> q = new LinkedList<>();

		for (NestedInteger ni: nestedList) {
			q.add(ni);
		}
		int res = 0;
		int depth = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				NestedInteger node = q.poll();
				if (node.isInteger()) {
					res += node.getInteger() * depth;
				} else {
					List<NestedInteger> list = node.getList();
					if (list != null) {
						for (NestedInteger num: list) {
							q.add(num);
						}
					}
				}
			}
			depth++;
		}
		return res;
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
