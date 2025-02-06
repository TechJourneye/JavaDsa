public class circularq{

    public static class queue{
        static int arr[] ;
        static  int size;
        static  int front;
        static int rear;
        public queue(int n){
            arr=new int[n];
            size=n;
            front=-1;
            rear=-1;
        }

        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        public static void enQueue(int data){
            if(isFull()){
                System.out.println("Q is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        
        }
        public static int dequeue(){
             if(isEmpty()){
                System.out.println("empty");
                return -1;
             }
             int val=arr[front];
             if(rear==front){
                rear=front=-1;
             }else{
                front=(front+1)%size;
             }
             return val;
        }
    }
    public static void main(String[] args) {
         queue q=new queue(5);
         q.enQueue(1);
         q.enQueue(2);
         q.enQueue(3);
         q.enQueue(4);
         q.enQueue(5);
         while(!q.isEmpty()){
         System.out.println(q.dequeue());
         }
    }
}