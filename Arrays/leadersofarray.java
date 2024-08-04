
import java.util.Random; 
import java.util.*; 
//This is the Code to Find the leaders of a Array
//A element in an array can be called as a Leader ,when all the elements present to right side of the element are lesser than itself
public class LeadersOfArray{
    
    public static void main (String[] args) {
        int arr[] = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { 
            arr[i] = rand.nextInt(1000);  
        }
        //size of the leaders will always be less than or equal to the size of the array
        System.out.println("Array Randomly Generated : "
                        + Arrays.toString(arr)); 
        int leaders[] = new int[arr.length];
        int present_leader = arr[arr.length-1];
        leaders[0]=present_leader;
        int num = 1;
        for(int i = arr.length - 2;i>=0;i--){
            if(arr[i]>present_leader){
                present_leader = arr[i];
                leaders[num++] = present_leader;
            }
        }
        
        System.out.println("There are "+num+" leaders in the array :- ");
        for(int i = 0;i<num;i++){
           if(i==num-1){
               System.out.print(leaders[i]);
               continue;
            }
            System.out.print(leaders[i]+",");
        }
    }
}