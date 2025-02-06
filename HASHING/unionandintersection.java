import java.util.*;
public class unionandintersection{
    
    public static void main(String[] args) {
     int arr[]={7,3,9};
     int arr1[]={6,3,9,2,9,4};
     HashSet<Integer> set=new HashSet<>();
     //union 
     for(int i=0;i<arr.length;i++){
        set.add(arr[i]);
     }
     for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
     }
    System.out.println(set.size());
    set.clear();
    
    //intersection
    int count=0;
    for(int i=0;i<arr.length;i++){
        set.add(arr[i]);
    }

    for(int i=0;i<arr1.length;i++){
        if(set.contains(arr1[i])){
            count++;
            set.remove(arr[i]);
            System.out.println(arr[i]);
        }
    }
    System.out.println(count);
    }
}