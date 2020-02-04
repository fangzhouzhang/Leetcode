import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _833FindAndReplaceinString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		if (S == null || S.length() == 0) return "";
		char[] arr = S.toCharArray();
		Map<Integer, String> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) set.add(i);
		int changeChars = 0;
		for (int i = 0; i < indexes.length; i++) {
			if (isValidPair(arr, indexes[i], sources[i])) {
				for (int j = indexes[i]; j < sources[i].length() + indexes[i]; j++) set.remove(j);
				map.put(indexes[i], targets[i]);
				changeChars += targets[i].length();
			}
		}
		StringBuilder sb = new StringBuilder(set.size() + changeChars);
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(i)) sb.append(arr[i]);
			else if (map.containsKey(i)) {
				sb.append(map.get(i));
			}
		}
		return new String(sb);

	}

	private boolean isValidPair(char[] a, int idx, String s) {
		int j = 0;
		for (int i = idx; i < idx + s.length(); i++, j++) {
			if (i >= a.length || a[i] != s.charAt(j)) return false;
		}
		return true;
	}
}
