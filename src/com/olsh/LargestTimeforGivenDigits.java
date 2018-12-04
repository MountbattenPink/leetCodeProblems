/*
Given an array of 4 digits, return the largest 24 hour time that can be made.
The smallest 24 hour time is 00:00, and the largest is 23:59.  
Starting from 00:00, a time is larger if more time has elapsed since midnight.
Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
Example 1:
Input: [1,2,3,4]
Output: "23:41"
Example 2:
Input: [5,5,5,5]
Output: ""
Note:
A.length == 4
0 <= A[i] <= 9
*/

package com.olsh;
import java.util.Arrays;
class LargestTimeforGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(A);
        List<String>aa = permute(A).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (String str:aa){
            if (isValid(str.charAt(0)-48,str.charAt(1)-48,str.charAt(3)-48,str.charAt(4)-48))return str;
        }
        return "";
    }
    public boolean isValid(int h, int hh, int m, int mm){
        return (((h==2 && hh<=3)||(h<=1 && hh<=9)) && (m<=5 && mm<=9));
    }
    
    public List<String> permute(int[] nums) {
        List<String>a=new ArrayList<String>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(nums, nums.length-1, res);
        for (List list:res){
            StringBuilder bld = new StringBuilder();
            for (int i=0;i<4;i++){
                bld.append(list.get(i));
            }
            bld.insert(2,":");
            a.add(bld.toString());
        }
        return a;
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
            }
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
