
import java.util.Random; 
import java.util.*; 
//Given an array of size n and an integer k, find all elements in the array that appear more than n/k times.
public class Occurnces{
    public static void main (String[] args) {
        int arr[] = new int[20];
        Random rand = new Random();
        for (int i = 0; i < 20; i++) { 
            arr[i] = rand.nextInt(5);
        }
        System.out.println("Array Randomly Generated : "+ Arrays.toString(arr));
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 6;
        int res[] = new int[k-1];
        int ind=0;
        for(int i = 0;i<arr.length;i++){
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
                if(count==arr.length/k){
                    res[ind++]=arr[i];
                }
            }
        }
        System.out.println("Numbers withatleast  N/k Occurnces");
        for(int i = 0;i<ind;i++){
           if(i==ind-1){
               System.out.print(res[i]);
               continue;
            }
            System.out.print(res[i]+",");
        }
        
        
    }
}