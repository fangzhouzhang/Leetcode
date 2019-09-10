import java.util.*;

public class InsertDeleteGetRandomDuplicates {
	private Random rand;
	private ArrayList<Integer> nums;
	private HashMap<Integer, Set<Integer>> locs;
	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicates() {
		rand = new Random();
		nums = new ArrayList<>();
		locs = new HashMap<>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean alreadyExist = false;
		if (locs.containsKey(val)) {
			alreadyExist = true;
		}
		if (!alreadyExist) {
			locs.put(val, new HashSet<Integer>());
		}
		Set<Integer> set = locs.get(val);
		set.add(nums.size());
		nums.add(val);
		return set.size() == 1;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if (!locs.containsKey(val) || locs.get(val).size() == 0) {
			return false;
		}
		int removeIdx = locs.get(val).iterator().next();
		int curLast = nums.get(nums.size() - 1);
		nums.set(removeIdx, curLast);
		//del
		nums.remove(nums.size() - 1);
		locs.get(val).remove(removeIdx);
		//add previous last index
		locs.get(curLast).add(removeIdx);
		locs.get(curLast).remove(nums.size());
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
