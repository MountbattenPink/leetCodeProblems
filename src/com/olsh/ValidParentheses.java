/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> p = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque stack = new LinkedList<>();
        for (Character c: s.toCharArray()){
            if (p.containsKey(c) && !stack.isEmpty() && stack.getLast()==p.get(c))
                stack.removeLast();
            else stack.add(c);
            }
        return stack.isEmpty();
    }
}
