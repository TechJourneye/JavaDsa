
import java.util.Stack;

class qusingtwostacks{
    static class Queue{
        Stack<Integer> s1=new Stack<>();
        Stack<Integer>  s2=new Stack<>();

        boolean isEmpty(){
         return s1.isEmpty();
        }

        void add(int data){// ____TC=O(n)
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }
        int dequeue(){
            return s1.pop();
        }
        int peek(){
            return s1.peek();
        }
    }
    
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
        
    }
}