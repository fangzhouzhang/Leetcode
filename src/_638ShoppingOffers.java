import java.util.ArrayList;
import java.util.List;

public class _638ShoppingOffers {
	private int min;
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		min = Integer.MAX_VALUE;
		dfs(price, special, 0, 0, needs);
		return min;
	}

	private void dfs(List<Integer> price, List<List<Integer>> special, int idx, int money, List<Integer> needs) {
		if (money >= min) return;
		if (idx == special.size()) {
			int remain = getPriceBySinglePrice(price, needs);
			if (remain + money < min) {
				min = remain + money;
			}
			return;
		}
		List<Integer> newNeeds = updateNeeds(special.get(idx), needs);
		if (newNeeds != null) {
			List<Integer> curSpe = special.get(idx);
			dfs(price, special, idx, money + curSpe.get(curSpe.size() - 1), newNeeds);
		}
		dfs(price, special, idx + 1, money, needs);
	}

	private int getPriceBySinglePrice(List<Integer> price, List<Integer> needs) {
		int sum = 0;
		for (int i = 0; i < price.size(); i++) {
			sum += price.get(i) * needs.get(i);
		}
		return sum;
	}

	private List<Integer> updateNeeds(List<Integer> spec, List<Integer> needs) {
		List<Integer> newNeeds = new ArrayList<>();
		for (int i = 0; i < needs.size(); i++) {
			int diff = needs.get(i) - spec.get(i);
			if (diff < 0) {
				return null;
			} else {
				newNeeds.add(diff);
			}
		}
		return newNeeds;
	}
}
