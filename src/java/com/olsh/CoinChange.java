package com.olsh; /**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest
number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins,
return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        List<Integer> nums = IntStream.of(coins).boxed()
                .sorted()
                .collect(Collectors.toList());


        Map<Integer, List<Integer>> c = new ConcurrentHashMap<>();
        for (int i = nums.size()-1; i >= 0; i--) {
            //System.out.println(c);
            int num = nums.get(i);
            Set<Integer> set = c.keySet();
            for (Integer key : set) {
                if (key >= num) {
                    for (int count = 1; count<= key/num;count++) {
                        if (c.get(key - num*count) == null) {
                            List<Integer> newValue = new ArrayList<>(c.get(key));
                            for (int j=0;j<count;j++) newValue.add(num);
                            c.put(key - num*count, newValue);
                        } else if (c.get(key - num*count).size() > c.get(key).size() + count) {
                            List<Integer> newValue = new ArrayList<>(c.get(key));
                            for (int j=0;j<count;j++) newValue.add(num);
                            c.put(key - num*count, newValue);
                        }
                    }
                }
            }
            //System.out.println(c);

            for (int count = 1; count<= amount/num;count++){
                if (c.get(amount- count*num)==null) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < count; j++) list.add(num);
                    c.put(amount - count * num, list);
                }
            }
        }

        if (c.get(0)!=null){
            return c.get(0).size();
        }
        else return -1;
    }
}
