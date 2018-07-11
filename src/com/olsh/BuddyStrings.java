/*
859. Buddy Strings
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
*/

class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length())return false;
        boolean discreapencyOccured = false; 
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        Set<Character> setADuplicates = new HashSet<>();
        Set<Character> setBDuplicates = new HashSet<>();
        int counter = 0;
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)!=B.charAt(i)){
                counter++;
                manipulateWithMap(discreapencyOccured, setA, setB, A.charAt(i));
                manipulateWithMap(discreapencyOccured, setB, setA, B.charAt(i));
                discreapencyOccured = true;
            }
            else {
                setADuplicates.add(A.charAt(i));
                setBDuplicates.add(B.charAt(i));}
        }
        return (counter==2 && setA.size()==0 && setB.size()==0)
            || (counter==0 && setADuplicates.size()<A.length() && setBDuplicates.size()<B.length());
    }
    
    
    public void manipulateWithMap(boolean b, Set<Character> set1, Set<Character> set2, Character c){
        if (!b){
            set1.add(c);
        }
        else {
            set2.remove(c);
        }
    }
}
