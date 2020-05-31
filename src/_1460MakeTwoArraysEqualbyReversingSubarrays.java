import java.util.HashSet;
import java.util.Set;

public class _1460MakeTwoArraysEqualbyReversingSubarrays {
	public boolean canBeEqual(int[] target, int[] arr) {
		if (target == null && arr == null) return true;
		if (target == null || arr == null) return false;
		Set<Integer> set = new HashSet<>();
		for (int t : target) set.add(t);
		for (int t : arr) if (!set.contains(t)) return false;
		return true;
	}
}
