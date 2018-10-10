/**
#917. Reverse Only Letters
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, 
and all letters reverse their positions.

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "
*/

package com.olsh;
class ReverseOnlyLetters {
 public String reverseOnlyLetters(String S) {
  StringBuilder builder = new StringBuilder(S);
  for (int i = 0, j = S.length() - 1; i < j;) {
   if (!isLetter(builder.charAt(i))) {
    i++;
    continue;
   }
   if (!isLetter(builder.charAt(j))) {
    j--;
    continue;
   }
   char c = builder.charAt(i);
   builder.setCharAt(i, builder.charAt(j));
   builder.setCharAt(j, c);
   i++;
   j--;
  }
  return builder.toString();
 }

 public boolean isLetter(char c) {
  return (c <= 122 && c >= 97) || (c <= 90 && c >= 65);
 }
}
