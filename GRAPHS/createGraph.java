
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class createGraph{

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
                //0--vertex
                graph[0].add(new Edge(0, 1, 5));
                graph[0].add(new Edge(0, 2, 0));
                //1--vertex
                graph[1].add(new Edge(1, 0,5));
                graph[1].add(new Edge(1, 3, 1));
                // graph[1].add(new Edge(1, 3,3));
                //2--vertex
                graph[2].add(new Edge(2, 0,1));
                graph[2].add(new Edge(2, 4,2));
                // graph[2].add(new Edge(2,1,1));
                //3--vertex
                // graph[3].add(new Edge(3,4,1));
                graph[3].add(new Edge(3,1,3));
                graph[3].add(new Edge(3, 4, 0));
                //4-vettex
                // graph[4].add(new Edge(4,3,2));
                graph[4].add(new Edge(4,2,2));
                graph[4].add(new Edge(4,3,2));
                // //5 vertex
                // // graph[5].add(new Edge(5,3,2));
                // // graph[5].add(new Edge(5,4,2));
                // graph[5].add(new Edge(5,6,2));
                // graph[5].add(new Edge(5,3,2));
                // //6vertx
                // graph[6].add(new Edge(6,5,2));  
    }
// breadth first sEARCH
    public static void bfs(ArrayList<Edge>[]  graph){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                bfsUtil(graph, visit);
            }
        }
        
    }
    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] visit){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visit[curr]){
                visit[curr]=true;
                System.out.println(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //depth first search
    public static void dfs(ArrayList<Edge>[] graph){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                dfsUtil(graph,i, visit);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph,int curr,boolean vis[]){
          System.out.println(curr+" ");
          vis[curr]=true;
          for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest , vis);
            }
          }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph ,int src,int dest,boolean vis[]){
        if(src==dest) return true;

        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            int neighbour=e.dest;
            if(!vis[neighbour]&&hasPath(graph, neighbour, dest, vis)){
                return true;
            }
        }
        return false;
    }
    //cycle detection code
    public static boolean haveCycle(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(haveCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean haveCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            // case 3
            if(!vis[e.dest]){
                if(haveCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            //case 1
            else if(vis[e.dest]&&e.dest!=par){
                return true;
            }
            //case 2 do nothing
        }
        return false;
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
        ArrayList<Edge>[] graph=new ArrayList[v];
        createGraph(graph);
      System.out.println(haveCycle(graph));
    }
    
}




