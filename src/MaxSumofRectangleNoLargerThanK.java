public class MaxSumofRectangleNoLargerThanK {
	public int maxSumSubmatrix(int[][] matrix, int t) {
		if (matrix == null || matrix.length == 0) {
			return -1;
		}
		int[][] rowPre = getRowPrefix(matrix);

		int[] compress = new int[matrix[0].length];
		int temp = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length + 1; i++) {
			for (int j = i + 1; j < matrix.length + 1; j++) {
				for (int k = 0; k < matrix[0].length; k++) {
					compress[k] = rowPre[k][j] - rowPre[k][i];
				}
				int tempRes = getTempRes(compress, t);
				if (tempRes > temp && tempRes <= t) {
					temp = tempRes;
				}
			}
		}

		return temp;

	}


	private int[][] getRowPrefix(int[][] matrix) {
		int[][] prefix = new int[matrix[0].length][matrix.length + 1];

		for (int i = 0; i < prefix.length; i++) {
			prefix[i][0] = 0;
		}
		int temp = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			temp = 0;
			for (int j = 1; j < matrix.length + 1; j++) {
				temp += matrix[j - 1][i];
				prefix[i][j] = temp;
			}
		}

		return prefix;
	}

	private int getTempRes(int[] arr, int target) {
		int temp = 0;


		// for (int num: arr) {
		//     System.out.print(num + " ");
		// }
		// System.out.println();


		int[] prefix = new int[arr.length + 1];
		prefix[0] = 0;
		for (int i = 1; i < prefix.length; i++) {
			temp += arr[i - 1];
			prefix[i] = temp;
		}


		// for (int num: prefix) {
		//     System.out.print(num + " ");
		// }
		// System.out.println();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prefix.length; i++) {
			for (int j = i + 1; j < prefix.length; j++) {
				int sum = prefix[j] - prefix[i];
				if (sum > max && sum <= target) {
					max = sum;
				}
			}
		}
		return max;
	}
}
