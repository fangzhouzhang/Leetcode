import java.util.List;

public class MajorityElement {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     * time: o(n) space: o(1)
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;//corner case
        }
        if (nums.size() == 1) {
            return nums.get(0);
        }
        Element e = new Element(nums.get(0), 1);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == e.value) {
                e.count++;
            } else if (nums.get(i) != e.value && e.count > 0) {
                e.count--;
            } else if (nums.get(i) != e.value && e.count == 0) {
                e.value = nums.get(i);
                e.count = 1;
            }
        }
        return e.value;
    }
    class Element {
        int value;
        int count;
        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
	public int majorityNumber_I(List<Integer> nums) {
		// write your code here
		int candidate = 0;
		int count = 0;
		for (Integer num: nums) {
			if (count == 0) {
				candidate = num;
			}
			if (candidate == num) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

}

