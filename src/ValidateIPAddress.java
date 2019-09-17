public class ValidateIPAddress {
	public String validIPAddress(String IP) {
		if (isIPV4(IP)) {
			return "IPv4";
		}
		if (isIPV6(IP.toUpperCase())) {
			return "IPv6";
		}
		return "Neither";
	}

	private boolean isIPV4(String IP) {
		int cnt = 0;
		for (char c : IP.toCharArray()) {
			if (c == '.') {
				cnt++;
			}
		}
		if (cnt != 3) {
			return false;
		}
		String[] fields = IP.split("\\.");
		if (fields.length != 4) {
			return false;
		}
		for (String field : fields) {
			if (field.isEmpty() || field.length() > 3) {
				return false;
			}
			for (int i = 0; i < field.length(); i++) {
				if (!Character.isDigit(field.charAt(i))) {
					return false;
				}
			}
			int num = Integer.valueOf(field);
			if ((!String.valueOf(num).equals(field)) || num < 0 || num > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean isIPV6(String IP) {
		int cnt = 0;
		for (char c : IP.toCharArray()) {
			if (c == ':') {
				cnt++;
			}
		}
		if (cnt != 7) {
			return false;
		}
		String[] fields = IP.split("\\:");
		if (fields.length != 8) {
			return false;
		}
		for (String field : fields) {
			if (field.isEmpty() || field.length() > 4) {
				return false;
			}
			for (int i = 0; i < field.length(); i++) {
				if ((!Character.isDigit(field.charAt(i))) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
					return false;
				}
			}
		}
		return true;
	}
}
