
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class bipartite{

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

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
                   graph[i]=new ArrayList<>(); // initilized null to empty arrayList
                }
                graph[0].add(new Edge(0, 1, 10));
                graph[0].add(new Edge(0, 2, 15));
                graph[0].add(new Edge(0, 3, 30));

                graph[1].add(new Edge(1, 0, 10));
                graph[1].add(new Edge(1, 3, 40));

                graph[2].add(new Edge(2, 3, 50));
                graph[2].add(new Edge(2,0, 15));

                graph[3].add(new Edge(3, 0, 30));
                graph[3].add(new Edge(3, 2, 50));

                // graph[4].add(new Edge(4,5, 5));
                // graph[4].add(new Edge(4, 1, 5));

                // graph[5].add(new Edge(5, 2, 5));
                // graph[5].add(new Edge(5, 0, 5));

                //0--vertex
                // graph[0].add(new Edge(0, 1, 5));
                // graph[0].add(new Edge(0, 2, 0));
                // //1--vertex
                // graph[1].add(new Edge(1, 0,5));
                // graph[1].add(new Edge(1, 3, 1));
                // // graph[1].add(new Edge(1, 3,3));
                // //2--vertex
                // graph[2].add(new Edge(2, 0,1));
                // graph[2].add(new Edge(2, 4,2));
                // // graph[2].add(new Edge(2,1,1));
                // //3--vertex
                // // graph[3].add(new Edge(3,4,1));
                // graph[3].add(new Edge(3,1,3));
                // graph[3].add(new Edge(3, 4, 0));
                // //4-vettex
                // // graph[4].add(new Edge(4,3,2));
                // graph[4].add(new Edge(4,2,2));
                // graph[4].add(new Edge(4,3,2));
                // //5 vertex
                // // graph[5].add(new Edge(5,3,2));
                // // graph[5].add(new Edge(5,4,2));
                // graph[5].add(new Edge(5,6,2));
                // graph[5].add(new Edge(5,3,2));
                // //6vertx
                // graph[6].add(new Edge(6,5,2));  
    }
   public static boolean isBipartite(ArrayList<Edge>[] graph){
    int col[]=new int[graph.length];
    for(int i=0;i<col.length;i++){
      col[i]=-1;
    }

    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<graph.length;i++){
        if(col[i]==-1){
            q.add(i);
            col[i]=0;//yellow
            while(!q.isEmpty()){
              int curr= q.remove();
              for(int j=0;j<graph[curr].size();j++){
               Edge e=graph[curr].get(j);
               if(col[e.dest]==-1){
                int nextCol=col[curr]==0?1:0;
                col[e.dest]=nextCol;
                q.add(e.dest);
               } else if(col[curr]==col[e.dest]){
                return false;// not bipartite
               }
              }
            }
        }
    }
    return true;
   }
   // detect cycle for directed graph
   public static boolean isCycle(ArrayList<Edge>[] graph){
    boolean vis[]=new boolean[graph.length];
    boolean stack[]=new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
      if(!vis[i]){
         if(isCycleUtil(graph,i,vis,stack)){
          return true;
         }
      }
    }
    return false;
   }
   public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
             vis[curr]=true;
             stack[curr]=true;
             for(int i=0;i<graph[curr].size();i++){
              Edge e=graph[curr].get(i);
              if(stack[e.dest]){
                return true;
              }
              if(!vis[e.dest]&&isCycleUtil(graph, e.dest, vis, stack)){
                return true;
              }
             }
             stack[curr]=false;
             return false;
   }

   // topological sort
   public static void topSort(ArrayList<Edge>[] graph){
    boolean vis[]=new boolean[graph.length];
   Stack<Integer> s=new Stack<>();
    for(int i=0;i<graph.length;i++){
      if(!vis[i]){
       topSortUtil(graph,i,vis,s);
      }
    }
    while(!s.isEmpty()){
      System.out.println(s.pop());
    }
   }
   public static void topSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> s){
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
              Edge e=graph[curr].get(i);
              if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
              }
            }
            s.add(curr);
   }
   // topological sort bfs approach
   public static void calinDegree(ArrayList<Edge>[] graph,int[] inDegree){
          for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
              Edge e=graph[v].get(j);
              inDegree[e.dest]++;
            }
          }
   }
   public static void topSortbfs(ArrayList<Edge>[] graph){
     int[] inDegree=new int[graph.length];
     calinDegree(graph, inDegree);
     Queue<Integer> q=new LinkedList<>();

     for(int i=0;i<inDegree.length;i++){
      if(inDegree[i]==0){
        q.add(i);
      }
     }
     while(!q.isEmpty()){
       int curr=q.remove();
       System.out.print(curr+" ");
       for(int i=0;i<graph[curr].size();i++){
          Edge e=graph[curr].get(i);
          inDegree[e.dest]--;
          if(inDegree[e.dest]==0){
            q.add(e.dest);
          }
       }
     }
   }
   // All path from source to target
   public static void srcTotarUtil(ArrayList<Edge>[] graph,int src,int des,String path){
       if(src==des){
        System.out.print(path+des);
       }
       for(int i=0;i<graph[src].size();i++){
        Edge e=graph[src].get(i);
        srcTotarUtil(graph, e.dest, des, path+src);
       }

   }
   // dijkstra algorithm
   public static class Pair implements Comparable<Pair>{
    int n;
    int path;
    public Pair(int n,int p){
      this.n=n;
      this.path=p;
    }

    @Override
    public int compareTo(Pair p2){
        return this.path-p2.path;
    }
   }
   public static void dijkstra(ArrayList<Edge>[] graph,int src){
          int dist[]=new int[graph.length];

          for(int i=0;i<graph.length;i++){
            if(i!=src){
              dist[i]=Integer.MAX_VALUE;
            }
          }
          boolean[] vis=new boolean[graph.length];
          PriorityQueue<Pair> pq=new PriorityQueue<>();
           pq.add(new Pair(src, 0));

           while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
            for(int i=0;i<graph[curr.n].size();i++){
               Edge e=graph[curr.n].get(i);
               int u=e.src;
               int v=e.dest;
               int wt=e.wt;
               if(dist[u]+wt<dist[v]){
                  dist[v]=dist[u]+wt;
                  pq.add(new Pair(v, dist[v]));// update distance src to v
               }
            }
           }
           }
           // distance
           for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
           }
   }
   // prim's algorithm
   public static class Pair2 implements Comparable<Pair2>{
    int n;
    int cost;
    public Pair2(int n,int p){
      this.n=n;
      this.cost=p;
    }

    @Override
    public int compareTo(Pair2 p2){
        return this.cost-p2.cost;
    }
   }

   public static void prim(ArrayList<Edge>[] graph){//
        boolean[] vis=new boolean[graph.length];
        PriorityQueue<Pair2> pq=new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
     
        int totalCost=0;
        while(!pq.isEmpty()){
          Pair2 curr=pq.remove();
          if(!vis[curr.n]){
            vis[curr.n]=true;
            totalCost+=curr.cost;
            
            for(int i=0;i<graph[curr.n].size();i++){
              Edge e=graph[curr.n].get(i);
              pq.add(new Pair2(e.dest, e.wt));
            }
          }
        }
        System.out.println(totalCost);
   }
    public static void main(String[] args) {
             /*
         * 0----1
         *     / \
         *    /   \
         *   /     \
         *  2 ----- 3
            |
            |
            4
         */ 
        int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[6];
        createGraph(graph);
        
    }
    
}