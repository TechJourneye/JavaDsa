public class arrayimplementation{

    public static class Stack{
        private static int arr[];
        private static int idx;
        public static int size;
        Stack(int n){
            arr=new int[n];
            idx=-1;
            size=n;
        }
        boolean isEmpty(){
         return idx==-1;
        }
        //isFull
        boolean isFull(){
            return idx+1==size;
        }
        //push
        void push(int data){
            if(isFull()){
             System.out.println("array is full");
             return;
            }
            idx=idx+1;
            arr[idx]=data;
        }
        //void pop
        int pop(){
            if(isEmpty()){
                System.out.println("array is empty");
                return -1;
            }
            int top=arr[idx];
           
                arr[idx]=0;
            
            idx--;
            return top;
        }
        int peek(){
            return arr[idx];
        }
        void display(){
            if(isEmpty()){
                System.out.println("empty");
                return;
            }
            for(int i=0;i<=idx;i++){
                System.out.print("["+arr[i]+""+"]");
            }
            System.out.println();
        }
        void printFull(){
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
         Stack st=new Stack(5);
         st.push(1);
         st.push(20);
         st.push(30);
         st.push(40);
         st.push(50);
         st.display();
         st.pop();
         st.pop();
         st.pop();
         st.pop();
         st.pop();
         st.pop();
    
    }
}