import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(arr, new NumberComparator());
		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		if(arr[0].charAt(0) == '0')
			return "0";
		String res = "";
		for (String str : arr) {
			res += str;
		}
		return res;
	}
	private class NumberComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			return (s2 + s1).compareTo(s1 + s2);
		}
	}
}
