import java.util.*;

public class Task {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 1, 3, 2, 6};
        int p = 0;
        int r = A.length-1;


        sort(A, p, r);
        System.out.println(Arrays.toString(A));

    }
    private static void sort (int[] A, int p, int r){
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q+1, r);
            merge(A, p, q, r);
        }
    }
    private static void merge (int[] A, int p, int q, int r){
        int[] B = Arrays.copyOfRange(A, p, q+1);
        int[] C = Arrays.copyOfRange(A, q+1, r+1);
        int[] result = new int[B.length + C.length];
        int indexB = 0;
        int indexC = 0;
        for(int i = 0; i<B.length+C.length; i++){
            if(indexC == C.length || (indexB != B.length && B[indexB] < C[indexC] )){
                result[i] = B[indexB++];
            }else{
                result[i] = C[indexC++];
            }
        }
        int indexResult = 0;
        for(int i = p; i <= r; i++){
            A[i] = result[indexResult++];
        }
    }
}
