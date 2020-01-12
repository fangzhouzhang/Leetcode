import java.util.HashSet;
import java.util.Set;

public class _1319NumberofOperationstoMakeNetworkConnected {
	public int makeConnected(int n, int[][] connections) {
		if (connections == null || n - 1 > connections.length) return -1;
		UnionFind uf = new UnionFind(n);
		for (int[] c : connections) {
			uf.union(c[0], c[1]);
		}
		for (int i = 0; i < n; i++) uf.parent[i] = uf.findRoot(i);
		Set<Integer> set = new HashSet<>();
		for (int num : uf.parent) set.add(num);
		return set.size() - 1;
	}

	private class UnionFind {
		int[] parent;
		int[] rank;

		public UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}

		private int findRoot(int idx) {
			if (parent[idx] == idx) return idx;
			int root = findRoot(parent[idx]);
			parent[idx] = root;
			return root;
		}

		private void union(int a, int b) {
			int rootA = findRoot(a);
			int rootB = findRoot(b);
			if (rootA == rootB) return;
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootA] = rootB;
				rank[rootB]++;
			}
		}
	}
}
