import java.util.Arrays;
import java.util.Comparator;

public class _1584MinCosttoConnectAllPoints {
	public int minCostConnectPoints(int[][] points) {
		int res = 0;
		int n = points.length;
		UnionFind uf = new UnionFind(n);
		int[][] g = new int[n * (n - 1) / 2][3];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				g[idx][0] = i;
				g[idx][1] = j;
				g[idx][2] = dis;
				idx++;
			}
		}
		Arrays.sort(g, new MyComparator());
		for (int[] a: g) {
			if (uf.union(a[0], a[1])) {
				res += a[2];
			}
		}
		return uf.n == 1 ? res : -1;
	}

	class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[2] - b[2];
		}
	}

	class UnionFind {
		int[] parent;
		int[] height;
		int n;
		public UnionFind(int size) {
			parent = new int[size + 1];
			for (int i = 1; i <= size; i++) {
				parent[i] = i;
			}
			height = new int[size + 1];
			Arrays.fill(height, 1);
			this.n = size;
		}

		public int getParent(int x) {
			if (parent[x] == x) return x;
			return parent[x] = getParent(parent[x]);
		}

		public boolean union(int a, int b) {
			int pa = getParent(a);
			int pb = getParent(b);
			if (pa == pb) return false;
			if (height[pa] > height[pb]) {
				parent[pb] = pa;
			} else if (height[pa] < height[pb]) {
				parent[pa] = pb;
			} else {
				parent[pa] = pb;
				height[pb]++;
			}
			this.n--;
			return true;
		}
	}
}
