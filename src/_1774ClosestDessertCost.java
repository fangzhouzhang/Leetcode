import java.util.HashSet;
import java.util.Set;

public class _1774ClosestDessertCost {
	int diff = Integer.MAX_VALUE, closest = -1;
	Set<Integer> set;
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		set = new HashSet<>();
		dfsTop(toppingCosts, 0, 0);
		for (int base : baseCosts) {
			// add cur base
			for (int c : set) {
				if (Math.abs(c + base - target) < diff) {
					diff = Math.abs(c + base - target);
					closest = c + base;
				} else if (Math.abs(c + base - target) == diff) {
					if (c + base < closest) {
						closest = c + base;
					}
				}
			}
		}
		return closest;
	}

	private void dfsTop(int[] toppingCosts, int idx, int cost) {
		if (toppingCosts.length == idx) {
			set.add(cost);
			return;
		}

		for (int i = 1; i < 3; i++) {
			dfsTop(toppingCosts, idx + 1, cost + toppingCosts[idx] * i);
		}

		dfsTop(toppingCosts, idx + 1, cost);
	}
}
