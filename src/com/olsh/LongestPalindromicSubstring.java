/**
#5
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s==null || s.isEmpty()) return "";
        StringBuilder res = new StringBuilder(String.valueOf(s.charAt(0)));
        char prev = 0;
        char pprev = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c==prev){
                findCurrentPolindrome(s, i, false, res);
            }
            if (c==pprev){
                findCurrentPolindrome(s, i, true, res);
            }
            prev=s.charAt(i);
            if (i>0){
                pprev=s.charAt(i-1);
            }
        }
        return res.toString();
    }


    public StringBuilder findCurrentPolindrome(String s, int i, boolean lengthEven, StringBuilder res){
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        int j;
        for (j=0; (!lengthEven && j<i)||(lengthEven && j<i-1); j++){
            stack.push(s.charAt(j));
        }
        if (lengthEven){
            builder.append(s.charAt(j));
            j++;
        }

        while (!stack.isEmpty() && j<s.length() && stack.peek().equals(s.charAt(j))){
            builder.append(stack.peek());
            builder.insert(0, stack.peek());
            stack.pop();
            j++;
        }
        if (res.toString().length()<builder.toString().length())
        {
            res.setLength(0);
            res.append(builder.toString());
        }
        return res;
    }
}
