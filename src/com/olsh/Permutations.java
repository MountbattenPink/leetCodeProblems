/**
#46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(nums, nums.length-1, res);
        return res;
    }

    public void permute(int[] nums, int tailSize, List<List<Integer>> tempRes) {
        if (tailSize==0){
            List<Integer>a = new ArrayList<>();
            a.add(nums[nums.length-1]);
			tempRes.add(a);
		}
        else {
	        permute(nums, tailSize-1, tempRes);
            int currentSize = tempRes.size();
            int currentLength = tempRes.get(0).size();
            int toInsert = nums[nums.length-tailSize-1];
            
       
              List<List<Integer>> copy=new ArrayList<List<Integer>>();
            for (int i=0;i<tempRes.size();i++){
                copy.add(new ArrayList<Integer>());
                 for (int j=0;j<tempRes.get(i).size();j++){
                    copy.get(i).add(tempRes.get(i).get(j));
                }
            }System.out.println("copy"+copy);
            for (int k=0;k<currentLength;k++){
             
            for (int i=0;i<copy.size();i++){
                List<Integer> b= new ArrayList<Integer>();
                for (int j=0;j<copy.get(i).size();j++){
                    b.add(copy.get(i).get(j));
                    }
                tempRes.add(b);
                }
            }       
             
             for (int i=0;i<tempRes.size();i+=currentSize)
             {
                 for (int j=i;j<i+currentSize;j++){
                     tempRes.get(j).add(i/currentSize, toInsert);
                 }
             }
             
            }
         
    }
        }

    
    


