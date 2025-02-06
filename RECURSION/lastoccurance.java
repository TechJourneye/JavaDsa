public class lastoccurance{

    public static int lastoccu(int arr[],int n,int key){
        //base case
         if(n==-1) return -1;
           //working method
         if(arr[n]==key) return n;
      // recursive call
         return lastoccu(arr, n-1, key);
    }
    //last occurance
    public static int lastoccu2(int arr[], int n, int key) {
        // Base case: If we've searched the whole array and didn't find the key
        if (n == arr.length) return -1;
        
        // Recursive call: search the rest of the array
        int isFound = lastoccu2(arr, n + 1, key);
        
        // If the key is found later in the array, return that index
        if (isFound != -1) {
            return isFound;
        }
        
        // If not found later and current element matches the key, return current index
        if (arr[n] == key) {
            return n;
        }

        return -1; // Otherwise, return -1 if the key wasn't found
    }

    public static int lastoccu3(int arr[],int n,int key){
        if(n==arr.length){
           return -1;
        }

        int isFound=lastoccu(arr, n+1, key);
        
        if(isFound==-1&&arr[n]==key){
           return n;
        }

        return isFound;
       }
    public static void main(String[] args) {

        int arr[]={1,2,3,4,50,6,7,8,50,9,90};
        System.out.println(lastoccu3(arr, 0, 50));

    }
    
}