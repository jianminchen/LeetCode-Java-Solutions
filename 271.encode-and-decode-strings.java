/**
 * @see <a href="https://leetcode.com/problems/encode-and-decode-strings/">Encode and Decode Strings</a>
 */

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        for (String str : strs) {
            sb.append('|');
            sb.append(str.length());
        }
        sb.append('|');
        sb.append(strs.size());
        return new String(sb);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '|') --i;
        int count = Integer.parseInt(s.substring(i + 1)); // the total number of strings;
        List<String> list = new ArrayList<String>();
        if (count == 0) return list;
        --i;
        Stack<Integer> stk = new Stack<Integer>();
        for (int j = 0; j < count; ++j) {
            int end = i + 1;
            while (s.charAt(i) != '|') --i;
            int start = i + 1;
            int len = Integer.parseInt(s.substring(start, end));
            stk.push(len);
            --i;
        }
        int cur = 0;
        while(!stk.isEmpty()) {
            int len = stk.pop();
            list.add(s.substring(cur, cur + len));
            cur = cur + len;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
