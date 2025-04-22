import java.util.*;

public class RemoveConsecutiveSubSequence {
    
    public static class Edge{
        int src;
        int des;
        int wt;

        public Edge(int s,int d,int w){
          this.src=s;
          this.des=d;
          this.wt=w;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int c){
          this.cost=c;
          this.v=v;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    @SuppressWarnings("unchecked") 
     public static void main(String[] args) {
        
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }

        //0 vertex
        graph[0].add(new Edge(0, 1, v));
        //1 vertex
        graph[1].add(new Edge(1, 0, v));
        graph[1].add(new Edge(1, 2, v));
        graph[1].add(new Edge(1, 3, v));

        //2 vertex;
        graph[2].add(new Edge(2, 1, v));
        graph[2].add(new Edge(2, 3, v));
        graph[2].add(new Edge(2, 4, v));
//     3vertex
        graph[3].add(new Edge(3, 1, v));
        graph[3].add(new Edge(3, 2, v));
       // 4 vetrex
        graph[4].add(new Edge(4, 2, v));


        for (int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println(e.des);
        }
     }
}
