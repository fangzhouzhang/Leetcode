import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
	public List<String> commonChars(String[] A) {
		List<String> res = new ArrayList<>();
		if (A.length == 0) return res;
		int[] map = new int[26];
		Arrays.fill(map, Integer.MAX_VALUE);
		for (String s: A) {
			int[] cnt = new int[26];
			for (int i = 0; i < s.length(); i++) {
				cnt[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				map[i] = Math.min(map[i], cnt[i]);
			}
		}
		for (int i = 0; i < 26; i++) {
			int j = map[i];
			while (j > 0) {
				res.add((char)(i + 'a') + "");
				j--;
			}
		}
		return res;
	}
}
