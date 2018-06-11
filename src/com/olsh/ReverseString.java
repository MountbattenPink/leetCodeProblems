/**
 *
 * № 344 Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */

public class ReverseString {
    public String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s.chars().forEach(c->stringBuilder.insert(0,(char)c));
        return stringBuilder.toString();
    }
}
