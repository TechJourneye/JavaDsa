
import java.util.Stack;

class  maxAreainHistogram{
   public static int maxArea(int[] arr){

    int maxArea=0;
    int nsr[]=new int[arr.length];
    int nsl[]=new int[arr.length];
    Stack<Integer> s=new Stack<>();
    //next smaller right
     for(int i=arr.length-1;i>=0;i--){
        while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            nsr[i]=arr.length;
        }else{
            nsr[i]=s.peek();
        }
        s.push(i);
     }
     //next smaller left
     s=new Stack<>();
     for(int i=0;i<arr.length;i++){
        while(!s.isEmpty()&&arr[i]<=arr[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            nsl[i]=arr.length;
        }else{
            nsl[i]=s.peek();
        }
        s.push(i);
     }
     //Area calculate
     for(int i=0;i<arr.length;i++){
        int ht=arr[i];
        int wd=nsr[i]-nsl[i]-1;
        maxArea=Math.max(ht*wd, maxArea);
     }
     return maxArea;
   }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        int arr1[]={2,4};
        System.out.print(maxArea(arr1));
    }    
}