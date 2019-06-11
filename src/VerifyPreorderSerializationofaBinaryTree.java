public class VerifyPreorderSerializationofaBinaryTree {
	public boolean isValidSerialization(String preorder) {
		if (preorder.length() == 0) {
			return true;
		}
		int delta = 0;
		String[] arr = preorder.split(",");
		for (int i = 0; i < arr.length; i++) {
			if (delta == 1) {
				return false;
			}
			if (arr[i].equals("#")) {
				delta++;
			} else {
				delta--;
			}
		}
		return delta == 1;
	}
}
