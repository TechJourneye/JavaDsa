
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class qrev{
   public static void reverseQ(Queue<Integer> q){
    Stack<Integer> st=new Stack<>();

    while(!q.isEmpty()){
        st.push(q.remove());
    }
    while(!st.isEmpty()){
        q.add(st.pop());
    }

   }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
        reverseQ(q);
        System.out.println(q);
    }
}