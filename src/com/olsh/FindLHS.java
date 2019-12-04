//594. Longest Harmonious Subsequence
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer>mapping = new HashMap<>();
        for (int n:nums){
            mapping.merge(n, 1, (a,b)->a+b);
        }
        int sum = 0;
        for (int k: mapping.keySet()){
            if (mapping.get(k-1)!=null)sum = Math.max(mapping.get(k-1)+mapping.get(k), sum);
            if (mapping.get(k+1)!=null)sum = Math.max(mapping.get(k+1)+mapping.get(k), sum);
        }
        return sum;
    }
}
