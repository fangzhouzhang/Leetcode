import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFormofInteger {
	public List<Integer> addToArrayForm(int[] A, int K) {
		LinkedList<Integer> res = new LinkedList<>();
		if (A == null || A.length == 0) {
			return null;
		}

		String str1 = "";
		for (int num : A) {
			str1 += num;
		}
		Integer k = K;
		String str2 = k.toString();

		int carry = 0;
		int idx1 = str1.length() - 1;
		int idx2 = str2.length() - 1;
		while (idx1 >= 0 && idx2 >= 0) {
			int sum = str1.charAt(idx1) - '0' + str2.charAt(idx2) - '0' + carry;
			res.addFirst(sum % 10);
			carry = sum / 10;
			idx1--;
			idx2--;
		}

		while (idx1 >= 0) {
			int sum = str1.charAt(idx1) - '0' + carry;
			res.addFirst(sum % 10);
			carry = sum / 10;
			idx1--;
		}
		while (idx2 >= 0) {
			int sum = str2.charAt(idx2) - '0' + carry;
			res.addFirst(sum % 10);
			carry = sum / 10;
			idx2--;
		}
		if (carry != 0) {
			res.addFirst(carry);
		}


		return (List)res;
	}
}
