
import java.util.Deque;
import java.util.LinkedList;

class stdq{
     public static class Stack{
        Deque<Integer> dq=new LinkedList<>();
        void push(int data){
            dq.addLast(data);
        }
        int remove(){
            return dq.removeLast();
        }
        int peek(){
            return dq.getLast();
        }
     }
     public static class Queue{
        Deque<Integer> dq=new LinkedList<>();
        void push(int data){
            dq.addLast(data);
        }
        int remove(){
            return dq.removeFirst();
        }
        int peek(){
            return dq.getLast();
        }
     }
    public static void main(String[] args) {
          Queue st=new Queue();
           st.push(1);
           st.push(2);
           st.push(3);
           System.out.println(st.remove());
           System.out.println(st.remove());
           System.out.println(st.remove());

    }
}