import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int bits = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int add = convert(c);
			// System.out.println(add);
			// bits <<= 2;
			// bits += add;
			if (i < 9) {
				//only at most 9 digits, add number, then move left;
				bits <<= 2;
				bits += add;
				continue;
			} else {
				bits = (bits << 2) & 0xfffff;
				bits += add;
				map.put(bits, map.getOrDefault(bits, 0) + 1);
				if (map.get(bits) == 2) {
					res.add(s.substring(i - 9, i + 1));
				}
			}
		}
		return res;
	}
	private int convert(char c) {
		int num = 0;
		switch(c) {
			case 'A':
				num = 0;
				break;
			case 'C':
				num = 1;
				break;
			case 'G':
				num =  2;
				break;
			case 'T':
				num =  3;
				break;
		}
		return num;
	}
}
