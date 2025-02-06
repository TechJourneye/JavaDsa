
import java.util.HashMap;

public class majorityElement{


    public static void main(String[] args) {     // TC= O(n)
        int nums[]={1,3,2,2,2,2,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
 

      for (Integer i : hm.keySet()) {
          if(hm.get(i)>(nums.length/3)){
            System.out.print(i+"  ");
          }
      }

    }
}