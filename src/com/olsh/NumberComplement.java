public class NumberComplement {
    public int findComplement(int num) {
        int res = 0;
        int i= 0;
        while (num>0){
            if (num%2 == 0){
                res += Math.pow(2, i);
            }
            num/=2;
            i++;
        }
        return res;
        }
}
