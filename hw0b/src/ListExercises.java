import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        int sum = 0;
        for(int n : L){
            sum += n;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> list = new ArrayList<>();
        for(int n : L){
            if(n % 2 == 0){
                list.add(n);
            }
        }
        return list;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonList = new ArrayList<>();
        for(int n : L1){
            if(L2.contains(n)){
                commonList.add(n);
            }
        }
        return commonList;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for(String word: words){
            for(Character ch : word.toCharArray()){
                if(ch == c){
                    count++;
                }
            }
        }
        return count;
    }
}
