import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	public int distributeCandies(int[] candies) {
		if (candies.length == 0) return 0;
		Set<Integer> set = new HashSet<>();
		for (int n: candies) set.add(n);
		return Math.min(candies.length / 2, set.size());
	}
}
