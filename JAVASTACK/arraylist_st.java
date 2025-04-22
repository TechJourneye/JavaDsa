import java.util.*;
public class arraylist_st {
   
        public static ArrayList<Integer> list=new ArrayList<>();
         public static boolean isEmpty(){
            return list.size()==0;
           
         }
         //push
         void push(int data){
          list.add(data);
         }
         //pop
         int pop(){
            if(isEmpty()){
                return -1;
            }
            return list.remove(list.size()-1);
         }
         //peak
         int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
         }

  
  public static String reverse(String str){
       Stack<Character> s=new Stack<>();
       int idx=0;
       while(idx<str.length()){
         s.push(str.charAt(idx));
         idx++;
       }
       StringBuilder result=new StringBuilder();
       while(!s.isEmpty()){
        result.append(s.pop());
       }
       String res=result.toString();
       return res;
  }

    public static void pushAtBtm(Stack<Integer> st,int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int top=st.pop();
        pushAtBtm(st, val);
        st.push(top);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
         return;
        }
        int top=st.pop();
        reverseStack(st);
        pushAtBtm(st, top);
    }
    public static void main(String[] args) {
    //    Stack st=new Stack();
    Stack<Integer> st=new Stack<>();
    st.push(1);
      st.push(2);
      st.push(3);
    reverseStack(st);
    System.out.println(st);
    //   st.push(1);
    //   st.push(2);
    //   st.push(3);
    // //   while(!st.isEmpty()){
    // //     System.out.println(st.peek());
    // //     st.pop();
    // //   }
    //     pushAtBtm(st,4);
    //       while(!st.isEmpty()){
    //     System.out.println(st.peek());
    //     st.pop();
    //   }
    }
}
