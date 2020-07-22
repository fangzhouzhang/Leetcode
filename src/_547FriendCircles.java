public class _547FriendCircles {
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) return 0;
		int n = M.length;
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		return uf.circle;
	}

	private class UnionFind {
		int[] parent;
		int[] height;
		int circle;
		public UnionFind(int n) {
			this.parent = new int[n];
			this.height = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				height[i] = 1;
			}
			circle = n;
		}

		private int getParent(int x) {
			if (parent[x] == x) return x;
			parent[x] = getParent(parent[x]);
			return parent[x];
		}

		public void union(int a, int b) {
			int rootA = getParent(a);
			int rootB = getParent(b);
			if (rootA == rootB) return;
			if (height[rootA] > height[rootB]) {
				parent[rootB] = rootA;

			} else if (height[rootA] < height[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootA] = rootB;
				height[rootB]++;
			}
			circle--;
		}
	}
}
