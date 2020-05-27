import java.util.*;

public class _187RepeatedDNASequences {
	int M = 1000000007;
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() <= 10) return res;
		Set<Long> set = new HashSet<>();
		long val = 0l;
		long aL = 1l;
		// convert string to array of integers
		Map<Character, Integer> toInt = new HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
		for (int i = 0; i < 10; i++) {
			int v = toInt.get(s.charAt(i));
			val = (val * 4  + v) % M;
			aL = aL * 4 % M;
		}
		set.add(val);

		List<Integer> ends = new ArrayList<>();
		for (int i = 10; i < s.length(); i++) {
			int del = toInt.get(s.charAt(i - 10));
			int add = toInt.get(s.charAt(i));
			val = (val * 4 - del * aL % M + M) % M;
			val = (val + add) % M;
			if (set.contains(val)) {
				ends.add(i);
			} else {
				set.add(val);
			}
		}
		Set<String> dedup = new HashSet<>();
		for (int end : ends) {
			String cur = s.substring(end - 9, end + 1);
			if (dedup.add(cur))
				res.add(cur);
		}
		return res;
	}
}
