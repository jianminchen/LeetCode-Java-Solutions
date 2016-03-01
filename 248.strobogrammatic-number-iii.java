/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/
 */
// dynamic programming solution, generate afterwards solutions based on previous solutions
// at the end, only count valid results
public class Solution {
	public int strobogrammaticInRange(String low, String high) {
		char[][] chart = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
		List<List<String>> rawRes = new ArrayList<>();
		List<String> first = new ArrayList<>();
		first.add("0"); first.add("1"); first.add("8");
		rawRes.add(first);
		List<String> second = new ArrayList<>();
		for (int i = 0; i < chart.length; ++i) {
			second.add(new String(chart[i]));
		}
		rawRes.add(second);
		
		for (int i = 2; i < high.length(); ++i) {
			List<String> next = new ArrayList<>();
			for (int ci = 0; ci < chart.length; ++ci) {
				for (String s : rawRes.get(i - 2)) {
					StringBuilder sb = new StringBuilder();
					sb.append(chart[ci][0]);
					sb.append(s);
					sb.append(chart[ci][1]);
					next.add(new String(sb));
				}
			}
			rawRes.add(next);
		}
		
		int count = 0;
		for (int len = low.length(); len <= high.length(); ++len) {
			for (String s : rawRes.get(len - 1)) {
				if (s.length() != 1 && s.charAt(0) == '0') {}
				else {
					if (len > low.length() && len < high.length()) {
					    ++count;
					} else {
						if (len == low.length() && len == high.length()) {
							if (s.compareTo(low) >= 0 && s.compareTo(high) <= 0) ++count;
						} else if (len == low.length()) {
							if (s.compareTo(low) >= 0) ++count;
						} else if (len == high.length()) {
							if (s.compareTo(high) <= 0) ++count;
						}
					}
				}
			}
		}
		return count;
	}
}
