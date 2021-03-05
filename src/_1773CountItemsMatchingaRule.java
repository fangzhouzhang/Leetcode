import java.util.List;

public class _1773CountItemsMatchingaRule {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int res = 0;
		for (List<String> item : items) {
			if (ruleKey.equals("type") && ruleValue.equals(item.get(0))) {
				res++;
			} else if (ruleKey.equals("color") && ruleValue.equals(item.get(1))) {
				res++;
			} else if (ruleKey.equals("name") && ruleValue.equals(item.get(2))) {
				res++;
			}
		}
		return res;
	}
}
