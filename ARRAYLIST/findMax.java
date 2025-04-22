
import java.util.ArrayList;



class findMax{

    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(9);
        l.add(20);
        l.add(45);
        l.add(4);
        l.add(22);
        l.add(44);

      //Running the loop n times
      int max=Integer.MIN_VALUE;
      for(int i=0;i<l.size();i++){
        max=Math.max(max, l.get(i));
      }

   System.out.println(max);


        //running the LOOP N/2 times

         max=Integer.MIN_VALUE;
      
        for(int i=0;i<l.size()/2;i++){
          max=Math.max(max, l.get(i));
          if(i!=l.size()-1-i){
            max=Math.max(max, l.get(l.size()-1-i));
          }
          System.out.println("compared to "+l.get(i)+" and "+l.get(l.size()-i-1));
        }
        if(l.size()%2!=0){
            max=Math.max(max, l.get(l.size()/2));
        }

        System.out.println("Maximum value "+max);
    }
}