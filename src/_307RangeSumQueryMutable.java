public class _307RangeSumQueryMutable {
	class NumArray {
		private int[] trees;
		private int[] nums;
		public NumArray(int[] nums) {
			trees = new int[nums.length + 1];
			this.nums = nums;
			for (int i = 0; i < nums.length; i++) {
				updateVal(i + 1, nums[i]);
			}
		}

		private void updateVal(int idx, int delta) {
			for (int i = idx; i < trees.length; i += lowbit(i)) {
				trees[i] += delta;
			}
		}

		public void update(int i, int val) {
			updateVal(i + 1, val - nums[i]);
			nums[i] = val;
		}

		public int sumRange(int i, int j) {
			return query(j + 1) - query(i);
		}

		private int query(int i) {
			int sum = 0;
			for (int k = i; k > 0; k -= lowbit(k)) {
				sum += trees[k];
			}
			return sum;
		}

		private int lowbit(int x) {
			return x & (-x);
		}
	}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

