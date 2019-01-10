import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num: nums) {
			// boolean canAdd = set.add(num);
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}
}
