/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<String>uniqueQueries= new HashSet<String>();
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        if (map.size()==1 && nums[0]==0){
            List newTriple = new ArrayList();
            newTriple.add(nums[0]);
            newTriple.add(nums[0]);
            newTriple.add(nums[0]);
            res.add(newTriple);
            return res;
            }
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                    Integer ind = map.get(-(nums[i]+nums[j]));
                    if (ind!=null && ind!=i && ind!=j){
                        List newTriple = new ArrayList();
                        newTriple.add(nums[i]);
                        newTriple.add(nums[j]);
                        newTriple.add(-(nums[i]+nums[j]));
                        if (!uniqueQueries.contains(hash(newTriple))){
                            res.add(newTriple);
                            uniqueQueries.add(hash(newTriple));
                        }
                }
            }
        }
        return res;
    }
    
    public String hash(List<Integer>l){
        StringBuilder builder= new StringBuilder();
        builder.append(Math.min(Math.min(l.get(0), l.get(1)), l.get(2)));
        builder.append(Math.max(Math.max(l.get(0), l.get(1)), l.get(2)));
        return builder.toString();
    }
}
