package com.olsh;

class TransponentMatrix {
    public int[][] transpose(int[][] A) {
        int B[][] = new int[A[0].length][A.length];
        int temp = 0;
        for (int i=0;i<A.length;i++){
         for (int j=0;j<A[0].length;j++){
             B[j][i] = A[i][j];
         }  
    }
        return B;
    }
}
