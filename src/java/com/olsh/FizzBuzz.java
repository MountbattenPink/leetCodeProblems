/**
#412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for 
the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
Example:
n = 15,
Return:
["1", "2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
*/
package com.olsh;

import java.util.ArrayList;
import java.util.List;

class FizzBuzz {
 public List<String> fizzBuzz(int n) {
  List <String> res = new ArrayList<String>();
  for (int i = 1; i <= n; i++) {
   if (i % 3 == 0) {
    if (i % 5 == 0) res.add("FizzBuzz");
    else res.add("Fizz");
   } else if (i % 5 == 0) res.add("Buzz");
   else res.add(String.valueOf(i));
  }
  return res;
 }
}
