public class _1323Maximum69Number {
	public int maximum69Number (int num) {
		int max = num;
		char[] arr = (num + "").toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char tmp = arr[i];
			if (arr[i] == '9') arr[i] = '6';
			else arr[i] = '9';
			max = Math.max(max, Integer.valueOf(new String(arr)));
			arr[i] = tmp;
		}
		return max;
	}
}
