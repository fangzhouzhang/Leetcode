public class JumpGame {
	/**
	 * @param A: A list of integers
	 * @return: A boolean
	 */
	public boolean canJump(int[] A) {
		// write your code here
		//M[i] means whether ith element can jump to the length - 1 index position
		boolean[] m = new boolean[A.length];
		int len = m.length;
		//System.out.println("len " + len);
		m[len - 1] = true;
		for (int i = len - 2; i >= 0; i--) {
			for (int j = 1; j <= A[i]; j++) {
				//System.out.println("j " + j);
				if (i + j >= len - 1 || m[i + j] == true) {
					//System.out.println("len " + len);
					m[i] = true;
					break;
				}
			}
		}
		return m[0];

	}
}
