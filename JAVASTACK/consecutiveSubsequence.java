
import java.util.Stack;

public class  consecutiveSubsequence{

 public static int[] sequence(int[] arr){
      Stack<Integer> st=new Stack<>();
      int n=arr.length;
      for(int i=0;i<n;i++){
        if(st.isEmpty()||st.peek()!=arr[i]){
            st.push(arr[i]);
        } else if (st.peek()==arr[i]) {
            if(i==n-1||arr[i]!=arr[i+1]) st.pop();
        }
      }
      int res[]=new int[st.size()];
      for(int i=res.length-1;i>=0;i--){
        res[i]=st.pop();
      }

      return res;
 }
                            
    public static void main(String[] args) {
         int arr[]={1,2,2,3,7,7,7,2,9,8,8,8};
         int[] res1=sequence(arr);
         for(int i=0;i<res1.length;i++){
            System.out.print(res1[i]);
         }
    }
}