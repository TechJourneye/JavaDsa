
import java.util.PriorityQueue;

class slidingWindow{
public static class Pair implements Comparable<Pair>{
    int data;
    int Idx;
    public Pair(int data,int Idx){
        this.data=data;
        this.Idx=Idx;
    }
    @Override
    public  int compareTo(Pair p2){
        return p2.data-this.data;
    }
}

    public static void main(String[] args) {
    int win[]={1,3,-1,-3,5,3,6,7};
    int k=3;
     int res[]=new int[win.length-k+1];
     PriorityQueue<Pair> pq=new PriorityQueue<>();
     //add k size window in result
     for(int i=0;i<k;i++){
         pq.add(new Pair(win[i],i));
     }

     res[0]=pq.peek().data;

     for(int i=k;i<win.length;i++){
        while(pq.size()>0 && pq.peek().Idx<=(i-k)){
            pq.remove();
        }
        
        pq.add(new Pair(win[i], i));
        res[i-k+1]=pq.peek().data;
     }

     for(int i=0;i<res.length;i++){
        System.out.print(res[i]+" ");
     }
    }
}