public class _307RangeSumQueryMutable {
	class NumArray {
		int[] trees;
		int[] nums;
		public NumArray(int[] nums) {
			trees = new int[nums.length + 1];
			this.nums = new int[nums.length];
			// for (int i = 0; i < nums.length; i++) this.nums[i] = nums[i];
			for (int i = 1; i < trees.length; i++) update(i - 1, nums[i - 1]);
		}

		public void update(int i, int val) {
			int diff = val - nums[i];
			for (int k = i + 1; k < trees.length; k += (k & -k)) trees[k] += diff;
			nums[i] = val;
		}

		public int sumRange(int i, int j) {
			return getSum(j + 1) - getSum(i);
		}

		private int getSum(int i) {
			int sum = 0;
			while (i > 0) {
				sum += trees[i];
				i -= (i & -i);
			}
			return sum;
		}
	}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

