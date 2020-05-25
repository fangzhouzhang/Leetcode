import java.util.HashMap;
import java.util.Map;

public class _166FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		long n = (long)numerator, d = (long)denominator;
		boolean same = (n > 0 &&  d > 0) || (n < 0 &&  d < 0);
		n = Math.abs(n); d = Math.abs(d);
		StringBuilder sb = new StringBuilder();
		long quotient = n / d;
		if (!same) sb.append('-');
		sb.append(quotient);
		if (n % d != 0) {
			sb.append('.');
			Map<Long, Integer> m = new HashMap<>();
			long r = n % d;
			while (r > 0) {
				if (m.containsKey(r)){
					sb.insert((int)m.get(r), "(");
					sb.append(")");
					break;
				}
				m.put(r, sb.length());
				sb.append((r * 10) / d);
				r = (r * 10) % d;
			}
		}
		return new String(sb);
	}
}
