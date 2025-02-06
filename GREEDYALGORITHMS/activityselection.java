
import java.util.*;

class  activityselection{

    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};      // total TC ->nlog(n)
        int end[]={2,4,6,7,9,9};
        
      int activities[][]=new int[start.length][3];
//   sorting 
for(int i=0;i<start.length;i++){
    activities[i][0]= i;
    activities[i][1]=start[i];
    activities[i][2]=end[1];
}
  Arrays.sort(activities, Comparator.comparingDouble(o ->o[2]));

int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        maxAct=1;
        ans.add(activities[0][0]);
         
        int lastEnd=activities[0][2];
        int StartTime;
        for(int i=1;i<end.length;i++){
            StartTime=activities[i][1];
            if(StartTime>=lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println("max activity can be performed"+" "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}