public class BackspaceStringCompare {

public boolean backspaceCompare(String S, String T) {
        Deque<Character> resultS = createQueue(S);
        Deque<Character> resultT = createQueue(T);
        return Arrays.equals(resultS.toArray(),resultT.toArray());
    }

    public Deque<Character> createQueue(String S){
        Deque<Character> result = new LinkedList<>();
        S.chars().forEach(item -> {
            if ((char)item!='#')
            {
                result.add((char)item);
            }
            else {
                result.pollLast();
            }
        });
        return result;
    }
  }
}
