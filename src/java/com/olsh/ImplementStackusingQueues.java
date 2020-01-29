/*
225. Implement Stack using Queues
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:
You must use only standard operations of a queue -- which means only push to back, 
peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate 
a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

package com.olsh;
import java.lang.Deque;
import java.lang.LinkedList;

class ImplementStackusingQueues {
Deque<Integer>a;
Deque<Integer>b;

    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!b.isEmpty()) a.addFirst(b.removeLast());
        a.addFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (a.size()>1)b.addFirst(a.removeLast());
        int res = a.removeLast();
        while (!b.isEmpty())a.addFirst(b.removeLast());
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        while (a.size()>1)b.addFirst(a.removeLast());
        int res = a.removeLast();
        b.addFirst(res);
        while (!b.isEmpty())a.addFirst(b.removeLast());
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
