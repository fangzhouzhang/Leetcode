import java.util.*;

public class _380InsertDeleteGetRandom {
	private class RandomizedSet {
		private Random random;
		private List<Integer> nums;
		private Map<Integer, Integer> locs;
		/** Initialize your data structure here. */
		public RandomizedSet() {
			random = new Random();
			nums = new ArrayList<>();
			locs = new HashMap<>();
		}

		/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int val) {
			if (locs.containsKey(val)) return false;
			nums.add(val);
			locs.put(val, nums.size() - 1);
			return true;
		}

		/** Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int val) {
			if (!locs.containsKey(val)) return false;
			int loc = locs.get(val);
			if (loc != nums.size() - 1) {
				int last = nums.get(nums.size() - 1);
				locs.put(last, loc);
				nums.set(loc, last);
			}
			locs.remove(val);
			nums.remove(nums.size() - 1);
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			return nums.get(random.nextInt(nums.size()));
		}
	}
}
