public class _685RedundantConnectionII {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		if (edges == null || edges.length == 0) return new int[0];
		int n = edges.length;
		Integer[] parent = new Integer[n + 1];
		UnionFind uf = new UnionFind(n + 1);
		int[] e1 = new int[2];
		int[] e2 = new int[2];
		for (int[] e : edges) {
			int u = e[0];
			int v = e[1];
			if (parent[v] != null) {
				//it means v has two parents
				e1[0] = parent[v];
				e1[1] = v;
				e2[0] = u;
				e2[1] = v;
				e[0] = -1;
				e[1] = -1;
			} else {
				parent[v] = u;
			}
		}
		for (int[] e : edges) {
			int u = e[0];
			int v = e[1];
			if (u == -1 && v == -1) continue;
			int rootU = uf.getParent(u);
			int rootV = uf.getParent(v);
			if (rootU != 0 && rootU == rootV) {
				return e1[0] == 0 ? e : e1;
			}
			uf.init(u);
			uf.init(v);
			uf.union(u, v);
		}
		return e2;
	}

	private class UnionFind {
		int[] parent;
		int[] rank;
		public UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
		}

		public void init(int x) {
			if (parent[x] == 0) {
				parent[x] = x;
				rank[x] = 1;
			}
		}

		public int getParent(int x) {
			if (parent[x] == x) return x;
			return parent[x] = getParent(parent[x]);
		}

		public void union(int a, int b) {
			int rootA = getParent(a);
			int rootB = getParent(b);
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
