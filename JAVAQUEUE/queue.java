

public class queue{
    public static class Queue{
      public static int arr[];
      static int rear;

        public Queue(int n) {
              arr=new int[n];
              rear=-1;
        }
        boolean isEmpty(){
            return rear==-1;
        }
        void enqueue(int data){
            if(rear==arr.length-1){
                System.out.println("queue is empty");
                return;
            }
            rear=rear+1;
            arr[rear]=data;
        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return val;
        }
       int peek(){
        return arr[0];
       }
        
    }

    public static void main(String[] args) {
     Queue q=new Queue(5);
     q.enqueue(1);
     q.enqueue(2);
     q.enqueue(3);
     while(!q.isEmpty()){
           System.out.println(q.peek());
           q.dequeue();
     }
    }
}