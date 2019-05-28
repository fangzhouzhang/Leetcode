import java.util.HashMap;
import java.util.Map;

public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] res = new int[barcodes.length];
		Map<Integer, Integer> map = new HashMap<>();
		int freMax = 0;
		int freNum = 0;
		for (int num : barcodes) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.get(num) > freMax) {
				freMax = map.get(num);
				freNum = num;
			}
		}
		//System.out.println(freNum + "  " + freMax);
		int idx = 0;
		for (int f = 0; f < freMax; f++, idx += 2) {
			res[idx] = freNum;
		}
		map.remove(freNum);
		for (Integer num : map.keySet()) {
			for (int i = 0; i < map.get(num); i++, idx += 2) {
				if (idx >= barcodes.length) {
					idx = 1;
				}
				res[idx] = num;
			}
		}
		return res;
	}
}
