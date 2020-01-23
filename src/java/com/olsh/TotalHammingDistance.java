/**
#477. Total Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
*/

package com.olsh;
class TotalHammingDistance {
 public int totalHammingDistance(int[] nums) {
        if (nums.length<2)return 0;
        int l = nums.length;
        String[]numbers = new String[nums.length];
        int max = 0;
        for (int i=0;i<=nums.length-1;i++)
        {
            max=Math.max(max, nums[i]);
        }
        int maxL = Integer.toBinaryString(max).length();
        for (int i=0;i<=nums.length-1;i++)
        {
            numbers[i]=String.format("%"+maxL+"s", Integer.toBinaryString(nums[i])).replace(' ', '0');
        }
        double result = 0;
        char c;
        for (int i=0;i<maxL;i++){
            int numOfc = 1;
            c=numbers[0].charAt(i);
            for (int j=1;j<l;j++){
                if (numbers[j].charAt(i)==c){
                    numOfc++;
                }
            }
            if (numOfc==l)continue;
            if (numOfc==l-1 || numOfc==1) result+=l-1;
            else {result+=comb(l,numOfc);}
        }
        return (int)result;
    }

   public double comb(int length, int numOfc){
       if (numOfc==length)return 0;
        if (numOfc==length-1||numOfc==1) return length-1;
        double a = c(length,length-2);
        double b = c(numOfc, numOfc-2);
        double c =  c(length-numOfc,length-numOfc-2 );
        double d=  a- b - c ;
        return d;
    }

    public double c(int n,int k){
        double res = 1;
        for (int i=k+1;i<=n;i++){
            res*=i;
        }
        return res/2;
    }
}

