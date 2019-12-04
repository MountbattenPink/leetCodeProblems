//91. Decode Ways
class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty())return 1;
        else if (s.startsWith("0"))return 0;
        else if (s.length()==1  || s.charAt(0)>50 || (s.charAt(0)==50 && s.charAt(1)>54)) return numDecodings(s.substring(1));
        else
            return numDecodings(s.substring(1))+numDecodings(s.substring(2));
    }
}
