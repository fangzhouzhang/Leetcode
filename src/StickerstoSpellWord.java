import java.util.HashMap;
import java.util.Map;

public class StickerstoSpellWord {
	public int minStickers(String[] stickers, String target) {
		if (stickers.length == 0) return 0;
		Map<String, Integer> map = new HashMap<>();
		map.put("", 0);
		int[][] fre = new int[stickers.length][26];
		for (int i = 0; i < stickers.length; i++) {
			for (int j = 0; j < stickers[i].length(); j++) {
				fre[i][stickers[i].charAt(j) - 'a']++;
			}
		}
		return dfs(stickers, target, map,fre);
	}

	private int dfs(String[] stickers, String target, Map<String, Integer> map, int[][] fre) {
		if (map.containsKey(target)) return map.get(target);

		int[] targetFre = new int[26];
		for (char c : target.toCharArray()) targetFre[c - 'a']++;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < stickers.length; i++) {
			if (fre[i][target.charAt(0) - 'a'] == 0) continue;
			StringBuilder rem = new StringBuilder();
			for (int j = 0; j < 26; j++) {
				if (targetFre[j] - fre[i][j] > 0) {
					char c = (char)(j + 'a');
					for (int k = 0; k < targetFre[j] - fre[i][j]; k++) rem.append(c);
				}
			}
			int cur = dfs(stickers, new String(rem), map, fre);
			if (cur != -1) res = Math.min(res, cur + 1);
		}

		if (res != Integer.MAX_VALUE) {
			map.put(target, res);
			return res;
		} else {
			map.put(target, -1);
			return -1;
		}
	}
}
