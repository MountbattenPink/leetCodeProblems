/**
#904. Fruit Into Baskets
In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, 
then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, 
but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

 

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 

Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length

*/

package com.olsh;

class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree.length == 0) return 0;
        int maxAmount = 0;
        int changeIndex = 0;
        Deque<Integer> fruitInBaskets = new LinkedList<Integer>();
        for (int i = 0; i < tree.length; i++) {
            if (fruitInBaskets.size() == 0 || tree[i] == fruitInBaskets.getLast()) {
                fruitInBaskets.add(tree[i]);
            } else if (tree[i] == fruitInBaskets.getFirst() 
                       || changeIndex == 0 
                       || (changeIndex != 0 && ((LinkedList<Integer>) fruitInBaskets).get(changeIndex - 1) == tree[i])) {
                changeIndex = fruitInBaskets.size();
                fruitInBaskets.add(tree[i]);
            } else if (changeIndex != 0) {
                maxAmount = Math.max(maxAmount, fruitInBaskets.size());
                for (int j = 0; j < changeIndex; j++) {
                    fruitInBaskets.removeFirst();
                }
                changeIndex = fruitInBaskets.size();
                fruitInBaskets.add(tree[i]);

            }
        }
        maxAmount = Math.max(maxAmount, fruitInBaskets.size());
        return maxAmount;
    }

}
