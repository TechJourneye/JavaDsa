
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class qll{
       static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
        }
    }
    static Node head;
    static Node tail;

    boolean isEmpty(){
        return head==null&&tail==null;
    }
         void enqueue(int data){
            Node newNode=new Node(data);
             if(head==null){
                head=tail=newNode;
                return;
             }
             tail.next=newNode;
             tail=newNode;
         }
         int dequeue(){
            if(head==null){
                System.out.println("LL is empty");
                return -1;
            }
            int val=head.data;
            head=head.next;
            if(head==null){
                tail=null;
            }
            return val;
         }

         int peek(){
            return head.data;
         }
  
    public static void main(String[] args) {
        Queue<Integer> q=new ArrayDeque<>();
        qll q1=new qll();
     q.add(1);
     q.add(2);
     q.add(3);
        while(!q.isEmpty()){
            System.out.print((q.peek())+" ");
            q.remove();
        }
    }
}