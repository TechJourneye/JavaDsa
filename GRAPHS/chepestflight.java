import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class chepestflight{

static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>(); // initilized null to empty arrayList
         }

         for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int des=flights[i][1];
            int wt=flights[i][2];

            Edge e=new Edge(src, des, wt);
            graph[src].add(e);
         }

    }
  public static class Info{
    int v;
    int cost;
    int s;
    public Info(int v,int c,int s){
        this.v=v;
        this.cost=c;
        this.s=s;
    }
  }
    public static int chepestFlight( ArrayList<Edge>[] graph,int src,int des,int k){
             int[] dist=new int[graph.length];
             for(int i=0;i<dist.length;i++){
                if(i!=src){
                    dist[i]=Integer.MAX_VALUE;
                }
             }

             Queue<Info> q=new LinkedList<>();

             q.add(new Info(0, 0, 0));

             while(!q.isEmpty()){
                Info curr=q.remove();
                if(curr.s>k){
                    break;
                }
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(curr.cost+wt<dist[v]&&curr.s<=k){
                        dist[v]=curr.cost+wt;
                        q.add(new Info(v, dist[v], curr.s+1));
                    }
                }
             }
            
             if(dist[des]==Integer.MAX_VALUE){
                return -1;
             }

             return dist[des];
    }
    public static void main(String[] args) {
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        int v=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[v];
       createGraph(graph, flights);
       int f=chepestFlight(graph, 0, 3, 1);
       System.out.println(f);
    }
}