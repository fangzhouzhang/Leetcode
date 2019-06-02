import java.util.Random;

public class ShuffleanArray {
	private class Solution {
		private int[] copy;
		private int[] u;
		private Random r;
		public Solution(int[] nums) {
			r = new Random();
			copy = nums;
			u = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				u[i] = nums[i];
			}
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			int[] res = new int[copy.length];
			for (int i = 0; i < copy.length; i++) {
				res[i] = copy[i];
			}
			return res;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			for (int i = 0; i < u.length; i++) {
				int idx = r.nextInt(i + 1);
				int temp = u[i];
				u[i] = u[idx];
				u[idx] = temp;
			}
			return u;
		}
	}

}
