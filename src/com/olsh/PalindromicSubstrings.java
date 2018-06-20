import java.util.ArrayList;
import java.util.List;

/**
№ 647.
 Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.
 */


class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++){
            count++;
            int j = i-1;
            int k=i;
            if (i!=0 && s.charAt(i) == s.charAt(k)){
                count = findPolindromes(count, j,k,s);
            }
            j=i-1;
            k++;
            count = findPolindromes(count, j,k,s);

        }
        return count;
    }

    public int findPolindromes(int count, int j, int k, String s){
        while (j>=0 && k<s.length() && s.charAt(j)==s.charAt(k))
        {
            count++;
            j--;
            k++;
        }
        return count;
    }
}
