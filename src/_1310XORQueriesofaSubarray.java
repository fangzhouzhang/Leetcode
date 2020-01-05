public class _1310XORQueriesofaSubarray {
	public int[] xorQueries(int[] arr, int[][] queries) {
		if (arr == null || arr.length == 0 || queries == null || queries.length == 0) return new int[0];
		int[] prefix = new int[arr.length + 1];
		int sum = 0;
		for (int i = 1; i < arr.length + 1; i++) {
			sum ^= arr[i - 1];
			prefix[i] = sum;
		}
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			res[i] = prefix[end + 1] ^ prefix[start];
		}
		return res;
	}
}
