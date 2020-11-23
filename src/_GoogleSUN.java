import java.util.HashMap;
import java.util.Map;

public class _GoogleSUN {
	/**
	 * input: "plays under the moon", "sun"
	 * output:
	 * plays
	 *     under the
	 *  moon
	 * @param input
	 * @param band
	 * @return
	 */
	private String concatString(String input, String band) {
		String[] arr = input.split(" ");
		Map<Integer, int[]> map = new HashMap<>();
		int n = band.length(), idx = 0, maxPos = Integer.MIN_VALUE;
		int[] pos = new int[band.length()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (band.charAt(idx) == arr[i].charAt(j)) {
					maxPos = Math.max(maxPos, j);
					int[] pair = {i, j};
					pos[idx] = i;
					map.put(idx, pair);
					idx++;
					break;
				}
			}
			if (idx == band.length()) break;
		}
		StringBuilder sb = new StringBuilder();
		idx = 0;
		for (Map.Entry<Integer, int[]> e: map.entrySet()) {
			int space = maxPos - e.getValue()[1];
			for (int i = 0; i < space; i++) sb.append(' ');
			sb.append(arr[e.getValue()[0]]);
			//space + word
			if (idx < band.length() - 1) {
				for (int j = e.getValue()[0] + 1; j < pos[idx + 1]; j++) {
					sb.append(' ');
					sb.append(arr[j]);
				}
			} else {
				for (int j = e.getValue()[0] + 1; j < arr.length; j++) {
					sb.append(' ');
					sb.append(arr[j]);
				}
			}
			sb.append('\n');
			idx++;
		}
		return new String(sb);
	}
}
