import java.util.*;
import java.util.stream.Collectors;

/**
 # 888.
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]


Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
 **/

public class UncommonWordsFromTwoSentences {
    public static String[] uncommonFromSentences(String A, String B) {
        List list = new ArrayList();
        Map<String, Integer> words = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();

        for (Character c: (A+" "+B+" ").toCharArray()){
            {
                if (c==' '){
                    if (!words.keySet().contains(currentWord.toString())){
                        words.put(currentWord.toString(), 1);
                    }
                    else words.put(currentWord.toString(),words.get(currentWord.toString())+1);
                    currentWord = new StringBuilder();
                }
                else {
                    currentWord.append(c);
                }
            }
        }
        List<String> result = words.entrySet()
                .stream()
                .filter(map -> map.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet",
                "this apple is sour")));
    }
}
