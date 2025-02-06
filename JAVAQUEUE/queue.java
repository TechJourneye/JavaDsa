

public class queue{
    public static class Queue{
        public static int arr[];
        public static int size;
        public static int rear;
        public static int front;
        public Queue(int n) {
            arr=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }
        public  boolean isEmpty(){
            return rear==-1&&front==-1;
        }
        public static boolean isFull() {
             return (rear+1)%size==front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }
        int remove(){
            if(isEmpty()){
                System.out.println("array is empty");
                return -1;
            }
            int result=arr[front];
            if(front==rear){
                front=rear=-1;
            }else{
                front=(front+1)%size;
            }
            return result;
        }
        int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }
        
    }

    public static void main(String[] args) {
     Queue q=new Queue(5);
     q.add(1);
     q.add(2);
     q.add(3);
     while(!q.isEmpty()){
           System.out.println(q.peek());
           q.remove();
     }
    }
}