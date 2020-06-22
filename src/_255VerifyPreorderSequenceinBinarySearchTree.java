public class _255VerifyPreorderSequenceinBinarySearchTree {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) return true;
		int n = preorder.length;
		return validateBST(preorder, 0, n - 1);
	}

	private boolean validateBST(int[] p, int start, int end) {
		if (start >= end) return true;
		int pivot = p[start];
		for (int i = start; i <= end; i++) {
			if (!checkSmall(p, start + 1, i, pivot) || !checkBig(p, i + 1, end, pivot)) continue;
			if (validateBST(p, start + 1, i) && validateBST(p, i + 1, end)) return true;
		}
		return false;
	}

	private boolean checkSmall(int[] p, int i, int j, int v) {
		for (int k = i; k <= j; k++) {
			if (p[k] >= v) return false;
		}
		return true;
	}

	private boolean checkBig(int[] p, int i, int j, int v) {
		for (int k = i; k <= j; k++) {
			if (p[k] <= v) return false;
		}
		return true;
	}
}
