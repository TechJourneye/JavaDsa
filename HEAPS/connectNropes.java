
import java.util.PriorityQueue;

class connectNropes{


    public static void main(String[] args) {
        int ropes[]={2,3,3,4,6};
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost=0;
        while(!pq.isEmpty()){
        int min1=pq.remove();
        int min2=pq.remove();
        int dist=min1+min2;
        cost+=dist;
        pq.add(dist);
        }
        System.out.println("cost"+cost);
    }
}