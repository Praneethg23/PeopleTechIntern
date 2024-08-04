import java.util.Random; 
import java.util.*; 

//find maximum sum of a sub array in given array;
public class MaxSubArraySum{
    public static void main (String[] args) {
        int arr[] = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { 
            if(rand.nextInt(2)==0){
                arr[i] = rand.nextInt(10);
            }
            else{
                arr[i] = -1*rand.nextInt(10);
            }
        }
        System.out.println("Array Randomly Generated : "+ Arrays.toString(arr));
        int max_sum=arr[0],curr_sum=arr[0];
        for(int i=1;i<arr.length;i++){
            curr_sum+=arr[i];
            if(max_sum<curr_sum)
                max_sum=curr_sum;
            if (curr_sum < 0)
                curr_sum= 0;
        }
        System.out.println("Maximum sum is "+max_sum);
    }
}