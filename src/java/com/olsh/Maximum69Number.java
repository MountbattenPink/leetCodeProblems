package com.olsh;
import java.lang.Integer;

class Maximum69Number {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='6')
                return Integer.valueOf(str.substring(0, i)+"9"+str.substring(i+1,str.length()));
        }
        return num;
    }
}
