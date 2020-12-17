public class _1649CreateSortedArraythroughInstructions {
	private int M = 1000000007;
	public int createSortedArray(int[] instructions) {
		NumArray num = new NumArray();
		int cost = 0;
		for (int ins: instructions) {
			int c1 = num.sumRange(0, ins - 1);
			int c2 = num.sumRange(ins + 1, 100000);
			// System.out.println(c1 + "...." + c2);
			cost = (cost + Math.min(c1, c2)) % M;
			num.update(ins, 1);

		}
		return cost;
	}

	class NumArray {
		private int[] trees;
		public NumArray() {
			trees = new int[100000 + 2];
		}

		private void updateVal(int idx, int delta) {
			for (int i = idx; i < trees.length; i += lowbit(i)) {
				trees[i] += delta;
			}
		}

		public void update(int i, int val) {
			updateVal(i + 1, val);
		}

		public int sumRange(int i, int j) {
			return query(j + 1) - query(i);
		}

		private int query(int i) {
			int sum = 0;
			for (int k = i; k > 0; k -= lowbit(k)) {
				sum = (sum + trees[k]) % M;
			}
			return sum;
		}

		private int lowbit(int x) {
			return x & (-x);
		}
	}
}
