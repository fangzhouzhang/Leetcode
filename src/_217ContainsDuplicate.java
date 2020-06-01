import java.util.HashSet;
import java.util.Set;

public class _217ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) return false;
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (!set.add(n)) return true;
		}
		return false;
	}
}
