import java.util.Arrays;
import java.util.Comparator;

public class _1135ConnectingCitiesWithMinimumCost {
	public int minimumCost(int N, int[][] connections) {
		Arrays.sort(connections, new MyComparator());
		int res = 0;
		UnionFind uf = new UnionFind(N);
		for (int[] c: connections) {
			if (uf.union(c[0], c[1])) {
				res += c[2];
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
			height = new int[size + 1];
			n = size;
			for (int i = 0; i < size + 1; i++) parent[i] = i;

		}

		private int getParent(int x) {
			if (x == parent[x]) return x;
			return parent[x] = getParent(parent[x]);
		}

		private boolean union(int a, int b) {
			int ra = getParent(a);
			int rb = getParent(b);
			if (ra == rb) return false;
			if (height[ra] > height[rb]) {
				parent[rb] = ra;
			} else if (height[ra] < height[rb]) {
				parent[ra] = rb;
			} else {
				parent[ra] = rb;
				height[rb]++;
			}
			n--;
			return true;
		}
	}
}
