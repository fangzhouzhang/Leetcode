public class SmallestRectangleEnclosingBlackPixels {
	public int minArea(char[][] image, int x, int y) {
		//try to find left
		if (image.length == 0)
			return 0;
		int start = 0;
		int end = y;
		int mid = 0;
		int left = y, right = y, top = x, bottom = x;

		start = 0;
		//end = y;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (colHasOne(image, mid)) {
				//go left
				end = mid - 1;
			} else {
				//go right
				start = mid + 1;
			}
		}
		if (left > start) {
			left = start;
		}
		end = left;
		// System.out.println("left is " + left);



		start = y;
		end = image[0].length - 1;
		//start = y;
		end = image[0].length - 1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (colHasOne(image, mid)) {
				//go right
				start = mid + 1;
			} else {
				//go left

				end = mid - 1;
			}
		}
		if (right < end) {
			right = end;
		}
		start = right;
		// System.out.println("right is " + right);

		start = 0;
		end = x;
		start = 0;
		//end = x;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (rowHasOne(image, mid)) {
				//go up
				//start = mid + 1;
				end = mid - 1;
			} else {
				//go down
				start = mid + 1;
				//end = mid - 1;
			}
		}
		if (top > start) {
			top = start;
		}
		end = top;
		// System.out.println("top is " + top);

		start = x;
		end = image.length - 1;
		//start = x;
		end = image.length - 1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (rowHasOne(image, mid)) {
				//go down
				start = mid + 1;
				//end = mid - 1;
			} else {
				//go up
				//start = mid + 1;
				end = mid - 1;
			}
		}
		if (bottom < end) {
			bottom = end;

		}
		start = bottom;
		// System.out.println("bottom is " + bottom);
		// System.out.println(" top is " + top + " bottom is " + bottom + " left is " + left + " right is " + right);
		return (bottom - top + 1) * (right - left + 1);
	}
	private boolean colHasOne(char[][] image, int col) {
		for (int i = 0; i < image.length; i++) {
			if (image[i][col] == '1') {
				return true;
			}
		}
		return false;
	}
	private boolean rowHasOne(char[][] image, int row) {
		for (int i = 0; i < image[0].length; i++) {
			if (image[row][i] == '1') {
				return true;
			}
		}
		return false;
	}
}
