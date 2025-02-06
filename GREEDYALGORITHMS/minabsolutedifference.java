
import java.util.Arrays;

class minabsolutedifference{

    public static void main(String[] args) {   // TC O(nlogn)
        
    int A[]={1,2,3};
    int B[]={2,1,4};

    Arrays.sort(A);
    Arrays.sort(B);
    int diff=0;
    for(int i=0;i<A.length;i++){
        diff+=Math.abs(A[i]-B[i]);
    }
    System.out.println( "Absolute difference is "+diff);
    }
}