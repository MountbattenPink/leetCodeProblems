/**
#338. Counting Bits
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
class CountingBits {
    public int[] countBits(int num) {
    int [] res = new int[num+1];
	res[0]=0;
    if (num>=1){
		res[1]=1;
    }
    int pow2 = 1;
    int current = 0;
	for (int i=2;i<=num;i++){
		current++;
		if (current==pow2){
            current=0;
            pow2*=2;
        }
	countBit(res, i,pow2);
    }
    return res;
}

public void countBit(int[] res, int i, int pow2){
	res[i]=res[i-pow2]+1;
    }
}


