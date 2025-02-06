import java.util.*;
class jobsequencingproblem{

    static class job{
        int id;
        int deadline;
        int profit;
        public job(int i,int d,int p){
        id=i;
        deadline=d;
        profit=p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
          
        ArrayList<job> jobs =new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        ArrayList<Integer> ans=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            job idx=jobs.get(i);
            if(idx.deadline>time){
                time++;
                ans.add(idx.id);
            }
        }
        System.out.println("max job done"+time);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}