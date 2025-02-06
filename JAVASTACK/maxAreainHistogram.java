
import java.util.Stack;

class  maxAreainHistogram{
    public static void maxArea(int arr[]){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        //next smaller right
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            } else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
 //next smaller left
   for(int i=0;i<arr.length;i++){
    while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
        s.pop();
    }
    if(s.isEmpty()){
        nsl[i]=-1;
    }else{
        nsl[i]=s.peek();
    }
    s.push(i);
   }
   //area calculate
    for(int i=0;i<arr.length;i++){
        int height=arr[i];
        int width=nsr[i]-nsl[i]-1;
        int currarea=height*width;
        maxArea=Math.max(maxArea,currarea);
    }
    System.out.println("max area"+ " "+maxArea);
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }    
}