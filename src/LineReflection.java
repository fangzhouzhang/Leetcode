import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
			set.add(Arrays.hashCode(p));
		}
		int sum = min + max;
		for (int[] p : points) {
			if (!set.contains(Arrays.hashCode(new int[]{sum - p[0], p[1]}))) {
				return false;
			}
		}
		return true;
	}
}
