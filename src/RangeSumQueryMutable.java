public class RangeSumQueryMutable {
	class NumArray {
		private FenTree tree;
		private int[] nums;
		public NumArray(int[] nums) {
			tree = new FenTree(nums);
			this.nums = nums;
		}

		public void update(int i, int val) {
			tree.update(i + 1, val - nums[i]);
			nums[i] = val;
		}

		public int sumRange(int i, int j) {
			return tree.query(j + 1) -  tree.query(i);
		}
		private class FenTree{
			private int[] sums_;
			public FenTree(int[] nums) {
				sums_ = new int[nums.length + 1];
				init(nums);
				//printInfo();
			}
			//when entering into, i should already be plus one
			public void update(int j, int delta) {
				while (j < sums_.length) {
					sums_[j] += delta;
					j += j & -j;
				}
			}
			public int query(int i) {
				int sum = 0;
				while (i > 0) {
					sum += sums_[i];
					i -= i & -i;
				}
				return sum;
			}
			public void init(int[] nums) {
				for (int i = 0; i < nums.length; i++) {
					int j = i + 1;
					int val = nums[i];
					while (j < sums_.length) {
						sums_[j] += val;
						j += j & -j;
					}
				}

			}
			public void printInfo() {
				for (int i = 0; i < sums_.length; i++) {
					System.out.println("index is " + i + " value is " + sums_[i]);
				}
			}
		}
	}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

