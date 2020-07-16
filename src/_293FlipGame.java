import java.util.ArrayList;
import java.util.List;

public class _293FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() <= 0) return res;
		char[] arr = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (arr[i] == arr[i + 1] && arr[i] == '+') {
				change(arr, i);
				res.add(new String(arr));
				change(arr, i);
			}
		}
		return res;
	}

	private void change(char[] arr, int i) {
		if (arr[i] == '+') {
			arr[i] = '-';
			arr[i + 1] = '-';
		} else {
			arr[i] = '+';
			arr[i + 1] = '+';
		}
	}
}
