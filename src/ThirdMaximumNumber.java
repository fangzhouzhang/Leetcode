public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		Integer m1 = null, m2 = null, m3 = null;
		for (Integer num : nums) {
			if (num.equals(m1) || num.equals(m2) || num.equals(m3)) {
				continue;
			}
			if (m1 == null || m1 < num) {
				m3 = m2;
				m2 = m1;
				m1 = num;
			} else if (m2 == null || m2 < num) {
				m3 = m2;
				m2 = num;
			} else if (m3 == null || m3 < num) {
				m3 = num;
			}
		}
		return m3 == null ? m1 : m3;
	}
}
