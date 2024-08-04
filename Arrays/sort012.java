
import java.util.Random; 
import java.util.*; 
//This Problem is to sort arrays with 0,1,2 present in them in time complexity of O(n)
public class Sort012{
    public static void main(String[] args){
        int arr[] = new int[20];
        Random rand = new Random();
        for (int i = 0; i < 20; i++) { 
            arr[i] = rand.nextInt(3);  
        }
        System.out.println("Array Randomly Generated : "+ Arrays.toString(arr));
        int point0 = 0,point1=0,point2=arr.length-1;
        while(point1<=point2){
            switch(arr[point1]){
                case 0 :{
                    arr[point1] = (arr[point1]+arr[point0]) - (arr[point0]=arr[point1]);
                    point1++;
                    point0++;
                    break;
                }
                case 1 :{
                    point1++;
                    break;
                }
                case 2:{
                    arr[point1] = (arr[point1]+arr[point2]) - (arr[point2]=arr[point1]);
                    point2--;
                    break;
                }
            }
        }
        System.out.println("Array After Sorting : "+ Arrays.toString(arr));
        
    }
}