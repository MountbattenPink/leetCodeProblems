class FlippingAnImage {
public int[][] flipAndInvertImage(int[][] A) {
        for (int[]row: A){
            for (int i = 0; i < row.length/2; i++){
                int swapVar1 = row[i];
                int swapVar2 = row[row.length - 1 - i];
                row[i] = 1 - swapVar2;
                row[row.length - 1 - i] = 1 - swapVar1;
            }
            if (row.length%2 == 1){
                row[row.length/2]=1-row[row.length/2];
            }
        }
        return A;
    }
    
}
