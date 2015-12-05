/**
 * @see <a href="https://leetcode.com/problems/unique-word-abbreviation/">Unique Word Abbreviation</a>
 */

public class ValidWordAbbr {
    // if the word correspond to a key, and the word is the only key in the words that have the same key.
    // return true;
    // if the key of the word does not belong to the keys of the dictionary, it is unique, return true.
    HashMap<String, Set<String>> hm = new HashMap<String, Set<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            String key = getAbbreviation(dictionary[i]);
            if (hm.containsKey(key)) hm.get(key).add(dictionary[i]);
            else {
                Set<String> ss = new HashSet<String>();
                ss.add(dictionary[i]);
                hm.put(key, ss);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getAbbreviation(word);
        /*
        if (!hm.containsKey(key)) return true;
        return hm.get(key) <= 1;
        */
        if (!hm.containsKey(key)) return true;
        if (hm.get(key).size() == 1 && hm.get(key).contains(word)) return true;
        return false;
    }
    
    public String getAbbreviation(String word) {
        String key = null;
        if (word.length() <= 2) key = word;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length() - 2);
            sb.append(word.charAt(word.length() - 1));
            key = new String(sb);            
        }
        return key;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
