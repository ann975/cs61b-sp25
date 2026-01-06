import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> tm = new TreeMap<>();
        int count = 1;
        char ch = 'a';
        while(count <= 26){
            tm.put(ch, count);
            ch = (char) (ch + 1);
            count++;
        }
        return tm;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> tm = new TreeMap<>();
        for(int n: nums){
            tm.put(n, n * n);
        }
        return tm;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> tm = new TreeMap<>();
        for(String word: words){
            tm.put(word, tm.getOrDefault(word, 0) + 1);
        }
        return tm;
    }
}
