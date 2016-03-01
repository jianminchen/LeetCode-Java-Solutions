/**
 * @see <a href="https://leetcode.com/problems/unique-word-abbreviation/">Unique Word Abbreviation</a>
 */

public class ValidWordAbbr {
    // If the word corresponds to a key, and the word is the only one that have the same key, return true.
    // If the key of the word does not belong to the keys of the dictionary, return true.
    private HashMap<String, Set<String>> hm = new HashMap<String, Set<String>>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; ++i) {
            String key = getAbbreviation(dictionary[i]);
            if (hm.containsKey(key)) {
                hm.get(key).add(dictionary[i]);
            } else {
                Set<String> ss = new HashSet<String>();
                ss.add(dictionary[i]);
                hm.put(key, ss);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getAbbreviation(word);
        if (!hm.containsKey(key)) return true;
        if (hm.get(key).size() == 1 && hm.get(key).contains(word)) return true;
        return false;
    }
    
    private String getAbbreviation(String word) {
        if (word.length() <= 2) {
            return word;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));
            return new String(sb);            
        }
    }
}
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
