import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1333FilterRestaurantsbyVeganFriendlyPriceandDistance {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
		List<Integer> res = new ArrayList<>();
		List<int[]> rs = new ArrayList<>();
		if (restaurants == null || restaurants.length == 0) return res;
		for (int[] r : restaurants) {
			if (((r[2] == 1 && veganFriendly == 1) || veganFriendly == 0) && r[3] <= maxPrice && r[4] <= maxDistance) rs.add(r);
		}
		Collections.sort(rs, new MyComparator());
		for (int[] r : rs) res.add(r[0]);
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			if (a[1] != b[1]) return b[1] - a[1];
			return b[0] - a[0];
		}
	}
}
