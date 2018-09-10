/**
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
 

Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.
*/
class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
       Map<Character, String> dict = new HashMap<>();
        dict.put('a', ".-");
        dict.put('b', "-...");
        dict.put('c', "-.-.");
        dict.put('d', "-..");
        dict.put('e', ".");
        dict.put('f', "..-.");
        dict.put('g', "--.");
        dict.put('h', "....");
        dict.put('i', "..");
        dict.put('j', ".---");
        dict.put('k', "-.-");
        dict.put('l', ".-..");
        dict.put('m', "--");
        dict.put('n', "-.");
        dict.put('o', "---");
        dict.put('p', ".--.");
        dict.put('q', "--.-");
        dict.put('r', ".-.");
        dict.put('s', "...");
        dict.put('t', "-");
        dict.put('u', "..-");
        dict.put('v', "...-");
        dict.put('w', ".--");
        dict.put('x', "-..-");
        dict.put('y', "-.--");
        dict.put('z', "--..");
        Set <String> set = new HashSet<>();
        StringBuilder b = new StringBuilder();
        for (String w:words){
            b.setLength(0);
            for (Character c:w.toCharArray()){
                b.append(dict.get(c));
            }
            set.add(b.toString());
        }
        return set.size();
    }
}
