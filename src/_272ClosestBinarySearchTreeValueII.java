import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _272ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		if (root == null) return new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MyComparator(target));
		dfs(root, pq, target, k);
		List<Integer> res = new ArrayList<>(k);
		for (int i = 0; i < k; i++) res.add(0);
		for (int i = k - 1; i >= 0; i--) {
			res.set(i, pq.poll());
		}
		return res;
	}

	private void dfs(TreeNode root, PriorityQueue<Integer> pq, double target, int k) {
		if (root == null) return;
		if (pq.size() >= k) {
			if (Math.abs(root.val - target) < Math.abs(pq.peek() - target)) {
				pq.poll();
				pq.add(root.val);
			}
		} else {
			pq.add(root.val);
		}

		dfs(root.left, pq, target, k);
		dfs(root.right, pq, target, k);

	}

	private class MyComparator implements Comparator<Integer> {
		private double target = 0;
		public MyComparator(double target) {
			this.target = target;
		}
		public int compare(Integer a, Integer b) {
			double diff = Math.abs(b - target) - Math.abs(a - target);
			return (diff < 0) ? -1 : 1;
		}
	}
}
