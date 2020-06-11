import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _247StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) return res;
		char[] tmp = new char[n];
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		dfs(0, n - 1, tmp, map, res);
		return res;
	}

	private void dfs(int start, int end, char[] tmp, Map<Character, Character> map, List<String> res) {
		if (start > end) {
			res.add(new String(tmp));
			return;
		}

		if ((start != 0 && start <= end) || (start == end && start == 0)) {
			tmp[start] = '0';
			tmp[end] = '0';
			dfs(start + 1, end - 1, tmp, map, res);
		}

		if (start <= end) {
			tmp[start] = '1';
			tmp[end] = '1';
			dfs(start + 1, end - 1, tmp, map, res);
		}

		if (start < end) {
			tmp[start] = '6';
			tmp[end] = '9';
			dfs(start + 1, end - 1, tmp, map, res);
		}

		if (start <= end) {
			tmp[start] = '8';
			tmp[end] = '8';
			dfs(start + 1, end - 1, tmp, map, res);
		}

		if (start < end) {
			tmp[start] = '9';
			tmp[end] = '6';
			dfs(start + 1, end - 1, tmp, map, res);
		}
	}

	public List<String> findStrobogrammatic1(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) return res;
		char[] tmp = new char[n];
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		dfs(0, n - 1, tmp, map, res);
		return res;
	}

	private void dfs1(int start, int end, char[] tmp, Map<Character, Character> map, List<String> res) {
		if (start > end) {
			res.add(new String(tmp));
			return;
		}

		if ((start != 0 && start <= end) || (start == end && start == 0)) {
			tmp[start] = '0';
			tmp[end] = '0';
			dfs1(start + 1, end - 1, tmp, map, res);
		}

		if (start <= end) {
			tmp[start] = '1';
			tmp[end] = '1';
			dfs1(start + 1, end - 1, tmp, map, res);
		}

		if (start < end) {
			tmp[start] = '6';
			tmp[end] = '9';
			dfs1(start + 1, end - 1, tmp, map, res);
		}

		if (start <= end) {
			tmp[start] = '8';
			tmp[end] = '8';
			dfs1(start + 1, end - 1, tmp, map, res);
		}

		if (start < end) {
			tmp[start] = '9';
			tmp[end] = '6';
			dfs1(start + 1, end - 1, tmp, map, res);
		}
	}
}
