/**
 * @see <a href="https://leetcode.com/problems/text-justification/">Text Justification</a>
 */

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null) throw new NullPointerException();
        List<List<String>> lists = new ArrayList<>();
        List<Integer> length = new ArrayList<>();
        
        List<String> first = new ArrayList<>();
        lists.add(first);
        length.add(0);
        for (int i = 0; i < words.length; ++i) {
            if (words[i].length() != 0) { // "" will not be considered.
                int n = lists.get(lists.size() - 1).size();
                if (length.get(lists.size() - 1) + words[i].length() + n > maxWidth) {
                        List<String> newList = new ArrayList<>();
                        lists.add(newList); 
                        length.add(0);
                        --i;
                } else {
                        lists.get(lists.size() - 1).add(words[i]);
                        length.set(length.size() - 1, words[i].length() + length.get(lists.size() - 1));
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (lists.size() == 1 && lists.get(0).size() == 0) {
            StringBuilder sb = new StringBuilder(); 
            for (int i = 0; i < maxWidth; ++i) {
                sb.append(" ");
            }
            res.add(new String(sb));
            return res;
        }
        
        for (int i = 0; i < lists.size() - 1; ++i) {
            int n = lists.get(i).size();
            int len = length.get(i);
            int nSpace = maxWidth - len;
            if (n == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(lists.get(i).get(0));
                for (int k = 0; k < nSpace; ++k) {
                    sb.append(" ");
                }
                res.add(new String(sb));
            } else {
                int num = n - 1;
                int each = nSpace / num;
                int remainder = nSpace % num;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < remainder; ++k) {
                    sb.append(lists.get(i).get(k));
                    for (int j = 0; j < each + 1; ++j) {
                        sb.append(" ");
                    }
                }
                for (int k = remainder; k < n - 1; ++k) {
                    sb.append(lists.get(i).get(k));
                    for (int j = 0; j < each; ++j) {
                    sb.append(" ");
                    }
                }
                sb.append(lists.get(i).get(n - 1));
                res.add(new String(sb));
            }
        }
        
        StringBuilder sbLast = new StringBuilder();
        int n = lists.get(lists.size() - 1).size();
        int len = length.get(length.size() - 1);
        for (int i = 0; i < n - 1; ++i) {
            sbLast.append(lists.get(lists.size() - 1).get(i));
            sbLast.append(" ");
        }

        sbLast.append(lists.get(lists.size() - 1).get(n - 1));
        int remain = maxWidth - len - (n - 1);
        for (int i = 0; i < remain; ++i) {
            sbLast.append(" ");
        }
        res.add(new String(sbLast));
        return res;
    }
}
