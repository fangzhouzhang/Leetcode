public class _165CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] a1 = version1.split("\\.");
		String[] a2 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < a1.length && j < a2.length) {
			int v1 = Integer.valueOf(a1[i]);
			int v2 = Integer.valueOf(a2[j]);
			if (v1 < v2) return -1;
			else if (v1 > v2) return 1;
			i++;
			j++;
		}


		while (i < a1.length) {
			int v1 = Integer.valueOf(a1[i]);
			int v2 = 0;
			if (v1 < v2) return -1;
			else if (v1 > v2) return 1;
			i++;
		}

		while (j < a2.length) {
			int v1 = 0;
			int v2 = Integer.valueOf(a2[j]);
			if (v1 < v2) return -1;
			else if (v1 > v2) return 1;
			j++;
		}
		return 0;
	}
}
