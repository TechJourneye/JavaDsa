

public class doubleLL{
    public static Node head;
    static Node tail;
    static int size;

     static class Node{
        int data;
        Node next,prev;

        public Node(int data) {
          this.data=data;
        }
    
    }
        void addFirst(int data){
            Node newNode= new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }

            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        void printDll(){
            Node temp=tail;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.prev;
            }
            System.out.println();
        }
      int removeF(){
        
        int val=head.data;
        head=head.next;
        head.prev=null;
        return val;
      }
    public static void main(String[] args) {
         doubleLL dll=new doubleLL();
         dll.addFirst(1);
         dll.addFirst(3);
         dll.addFirst(4);
         dll.addFirst(5);
         System.out.println(dll.removeF());
        
         dll.printDll();
    }
}