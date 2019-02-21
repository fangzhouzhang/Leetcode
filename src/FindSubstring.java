import java.util.HashSet;
import java.util.Set;

public class FindSubstring {
	public int findSubstring(String str, int k) {
		// Write your code here
		Set<String> set = new HashSet<>();
		for (int i = 0; i + k - 1 < str.length(); i++) {
			boolean fail = false;
			boolean[] dup = new boolean[26];
			for (int j = i; j <= i + k - 1; j++) {
				char ch = str.charAt(j);
				if (dup[ch - 'a'] == true) {
					fail = true;
					break;
				} else {
					dup[ch - 'a'] = true;
				}
			}
			if (fail == false) {
				set.add(str.substring(i, i + k));
			}
		}
		return set.size();
	}
}
