public class _1108DefanginganIPAddress {
	public String defangIPaddr(String address) {
		if (address == null || address.length() == 0) return address;
		StringBuilder sb = new StringBuilder();
		for (char c : address.toCharArray()) {
			if (c == '.') sb.append('[').append(c).append(']');
			else sb.append(c);
		}
		return new String(sb);
	}
}
