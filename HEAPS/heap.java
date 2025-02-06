
import java.util.ArrayList;

class heap{
    
    static class heap1{
         ArrayList<Integer> arr=new ArrayList<>();
         
         public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int par=(x-1)/2;

            while(arr.get(x)<arr.get(par)){
                int temp=arr.get(par);
                arr.set(par, arr.get(x));
                arr.set(x,temp);
                x=par;
                par=(x-1)/2;
            }
         }

         public int peek(){
            return arr.get(0);
         }
//    hepify
         private void heapify(int i){
             int left=2*i+1;
             int right=2*i+2;
             int minidx=i;
             if(left<arr.size()&&arr.get(minidx)>arr.get(left)){
                minidx=left;
             }

             if(right<arr.size()&&arr.get(minidx)>arr.get(right)){
                minidx=right;
             }

             if(minidx!=i){
                int temp=arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
             }
         }

         public int remove(){

            int data=arr.get(0);
            // swap
           arr.set(0, arr.get(arr.size()-1));
           arr.set(arr.size()-1, data);

           //remove
           arr.remove(arr.size()-1);
           // fif the heap(hepify)
         heapify(0);
           return data;
            
         }
         public boolean isEmpty(){
            return arr.size()==0;
         }
    }
    public static void main(String[] args) {
        
        heap1 pq=new heap1();
        pq.add(4);
        pq.add(3);
        pq.add(10);
        pq.add(1);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
         
    }
}