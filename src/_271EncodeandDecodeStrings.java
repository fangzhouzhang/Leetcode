import java.util.ArrayList;
import java.util.List;

public class _271EncodeandDecodeStrings {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str: strs) {
			sb.append(str.length()).append("/").append(str);
		}
		return new String(sb);
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> ret = new ArrayList<>();
		int idx = 0;
		while (idx < s.length()) {
			int slash = s.indexOf("/", idx);
			int size = Integer.valueOf(s.substring(idx, slash));
			idx = slash + size + 1;
			ret.add(s.substring(slash + 1, idx));
		}
		return ret;
	}
}
