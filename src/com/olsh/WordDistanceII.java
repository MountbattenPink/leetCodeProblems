//244. Shortest Word Distance II

class WordDistance {
    Map<String, List<Integer>> indices;
        
    public WordDistance(String[] words) {
        indices = new HashMap<>();
        for (int i=0;i<words.length;i++){
            List<Integer>list = new ArrayList();
            list.add(i);
            if (indices.get(words[i])==null)indices.put(words[i], list);
            else indices.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (int i:indices.get(word1)){
            for (int j:indices.get(word2)){
                min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
