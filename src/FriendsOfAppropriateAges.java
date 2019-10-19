import java.util.Arrays;

public class FriendsOfAppropriateAges {
	public int numFriendRequests(int[] ages) {
		if (ages.length == 0) return 0;
		int res = 0;
		int n = ages.length;
		Arrays.sort(ages);
		for (int i = n - 1; i >= 0; i--) {
			for (int j= i - 1; j >= 0; j--) {
				if (ages[i] <= ages[j] * 0.5 + 7) continue;
				if (ages[i] == ages[j]) res++;
				res++;
			}
		}
		return res;
	}
}
