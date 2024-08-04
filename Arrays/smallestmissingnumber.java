import java.util.Random; 
import java.util.*; 
//finding Smallest Missing Positive Integer
public class SmallestMissingNumber{
    public static void main (String[] args) {
        int arr[] = new int[15];
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
        boolean check[] = new boolean[arr.length+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0)
                check[arr[i]]=true;
        }
        for(int i=1;i<check.length;i++)
        {
            if(check[i]==false){
                System.out.println("Smallest Positive Number Missing is "+i);
                break;
            }
        }
    }
}