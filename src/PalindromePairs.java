import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j) {
					continue;
				}
				//i != j
				if (isP(words, i, j)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					res.add(temp);
				}
			}
		}
		return res;
	}
	private boolean isP(String[] words, int i, int j) {
		String compare = words[i] + words[j];
		int left = 0;
		int right = compare.length() - 1;
		while (left <= right) {
			if (compare.charAt(left) != compare.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
