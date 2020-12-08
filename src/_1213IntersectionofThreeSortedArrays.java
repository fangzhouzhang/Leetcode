import java.util.ArrayList;
import java.util.List;

public class _1213IntersectionofThreeSortedArrays {
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> res = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
				res.add(arr1[i]);
				i++;
				j++;
				k++;
			} else if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) i++;
			else if (arr1[i] >= arr2[j] && arr2[j] <= arr3[k]) j++;
			else if (arr1[i] >= arr3[k] && arr2[j] >= arr3[k]) k++;
		}
		return res;
	}
}
