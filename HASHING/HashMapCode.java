import java.util.ArrayList;
import java.util.LinkedList;


public class HashMapCode{
     
     public static class HashMap<K,V>{
        
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
            private int n;// n
            private int N;
            private LinkedList<Node> buckets[];// N

            @SuppressWarnings("unchecked")
            public HashMap(){
                this.N=4;
                this.buckets=new LinkedList[N];
                for(int i=0;i<4;i++){
                    buckets[i]=new LinkedList<>();
                }
            }
            // hashfunction
            private  int hashFunction(K key){
                int bi=key.hashCode();
                return Math.abs(bi)%N;
            }
            //search in ll
            private int searchinLL(K key,int bi){
               LinkedList<Node> ll=buckets[bi];
               int di=0;

               for(int i=0;i<ll.size();i++){
                   Node node=ll.get(i);
                   if(node.key==key){
                    return di;
                   }
                   di++;
               }
               return -1;
            }
            //rehash code
            @SuppressWarnings("unchecked")
            private void rehash(){
                LinkedList<Node> oldBucket[]=buckets;
                buckets=new LinkedList[2*N];
                N=2*N;
                for(int i=0;i<buckets.length;i++){
                    buckets[i]=new LinkedList<>();
                }
                //add elements in new bucket
                for(int i=0;i<oldBucket.length;i++){
                    LinkedList<Node> ll=oldBucket[i];
                    for(int j=0;j<ll.size();j++){
                        Node node=ll.get(j);
                        put(node.key, node.value);
                    }
                }
            }
         //put
         public void put(K key,V value){
              int bi=hashFunction(key);
              int di=searchinLL(key,bi);

              if(di!=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
              }else{
                buckets[bi].add(new Node(key,value));
                n++;
              }
              double lambda=(double)n/N;
              if(lambda>2.0){
                rehash();
              }
         }
         //containskey
       public boolean containskey(K key){
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);

        if(di!=-1){
           return  true;
        }else{
          return false;
        }
       }
         //remove
       public V remove(K key){
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);

        if(di!=-1){
          Node node=buckets[bi].remove(di);
          n--;
           return node.value;
        }else{
          return null;
        }
       }
       //get 
       public V get(K key){
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);

        if(di!=-1){
          Node node=buckets[bi].get(di);
           return node.value;
        }else{
           return null;
        }
       }
       // keySets
     public ArrayList<K> keySet(){
        ArrayList<K> keys=new ArrayList<>();
         for(int i=0;i<buckets.length;i++){
             LinkedList<Node> ll=buckets[i];
             for (Node node : ll) {
                 keys.add(node.key);
             }
         }
         return keys;
     }
     //isEmpty
     public boolean isEmpty(){
        return n==0;
     }
     }
    public static void main(String[] args) {
    HashMap<String,Integer> hm=new HashMap<>();
    hm.put("india", 100);
    hm.put("China", 150);
    hm.put("SRilanka", 3);
    hm.put("USA", 30);
     ArrayList<String> keys=hm.keySet();

     for (String k : keys) {
        System.out.println(k);
     }
     System.out.println(hm.get("india"));
     System.out.println(hm.remove("india"));
     System.out.println(hm.get("india"));
     System.out.println(hm.isEmpty());
    }
}