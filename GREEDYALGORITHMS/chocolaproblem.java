
import java.util.Arrays;
import java.util.Collections;

class chocolaproblem{

    public static void main(String[] args) {
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        int h=0; int v=0;
        int vp=1;int hp=1;
        int cost=0;
        while(h<costVer.length&&v<costHor.length){
              if(costVer[v]>=costHor[h]){ //vertical piece
               cost+=costVer[v]*hp;
               vp++;
               v++;
            }else{
              cost+=costHor[h]*vp;
              hp++;
              h++;
            }
        }
        while(h<costHor.length){
            cost+=costHor[h]*vp;
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost+=costVer[v]*hp;
            vp++;
            v++;
        }
        System.out.println(cost);
        System.out.println(hp);
    }
}