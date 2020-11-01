import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class _381InsertDeleteGetRandomO1Duplicatesallowed {
	class RandomizedCollection {

		private List<Integer> numbers;
		private Map<Integer, Set<Integer>> locs;
		private Random random;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			numbers = new ArrayList<>();
			locs = new HashMap<>();
			random = new Random();
		}

		/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
		public boolean insert(int val) {
			if (!locs.containsKey(val)) {
				locs.put(val, new HashSet<>());
				locs.get(val).add(numbers.size());
				numbers.add(val);
				return true;
			} else {
				locs.get(val).add(numbers.size());
				numbers.add(val);
				return false;
			}
		}

		/** Removes a value from the collection. Returns true if the collection contained the specified element. */
		public boolean remove(int val) {
			if (!locs.containsKey(val) || locs.get(val).size() == 0) {
				return false;
			} else {
				int lastIdx = numbers.size() - 1;
				int lastVal = numbers.get(lastIdx);

				if (lastVal != val) {
					int delLoc = locs.get(val).iterator().next();
					numbers.set(lastIdx, val);
					numbers.set(delLoc, lastVal);
					locs.get(lastVal).remove(lastIdx);
					locs.get(val).remove(delLoc);
					locs.get(lastVal).add(delLoc);
					locs.get(val).add(lastIdx);
				}
				locs.get(val).remove(numbers.size() - 1);
				numbers.remove(numbers.size() - 1);
				return true;
			}
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return numbers.get(random.nextInt(numbers.size()));
		}
	}
}
