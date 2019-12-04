//290. Word Pattern

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[]words=str.split(" ");
        Map<Character, String>mappingToString = new HashMap<>();
        Map<String, Character>mappingToChar = new HashMap<>();
        
        if (pattern.length()!=words.length)return false;
        
        for (int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if (mappingToString.get(c)==null && mappingToChar.get(word)==null){
                mappingToString.put(c, word);
                mappingToChar.put(word, c);
            }
            else if (!(mappingToString.get(c)!=null &&  mappingToChar.get(word)!=null
                      && mappingToString.get(c).equals(word) && mappingToChar.get(word).equals(c)))
                return false;
        }
        return true;
    }
}
