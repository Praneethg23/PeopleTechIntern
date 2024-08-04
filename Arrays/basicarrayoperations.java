
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Arrays; 
import java.util.stream.IntStream; 

public class BasicArrayOperations
{
    public static void main(String[] args) {
        //normal decleration
        int arr[] = new int[5];
        //directly intializing array with elements
        int arr1[] = new int[]{1,2,3,5};
        //method 2
        int arr2[] = {3,4,2,1,9};
        
        //insertion
        arr[0]=4;
        arr[1]=6;
        arr[2]=8;
        arr[3]=10;
        arr[4]=12;
        
        //traversal of a array
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
        
        for(int i=0;i<arr2.length;i++){
            if(i==arr2.length-1){
               System.out.print(arr2[i]);
               continue;
            }
            System.out.print(arr2[i]+",");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
               System.out.print(arr[i]);
               continue;
            }
            System.out.print(arr[i]+",");
        }
        //deletion in arrays are not straight forward.
        //Arrays are not completely dynamic in nature
        //Few Languages provide dynamic array such C/C++ where we can delete 
        //python as numpy library which can perform all the things with already implemented methods
        //For Java,arrays are not dyanamic and deletion can only be done using other array or array copy or datastructures such as linked IllegalMonitorStateException
        //Another popular method for deletion in arrays in Java is using Streams
        
        //deleting elemnt at index 2
        final int arr_del[] = arr ;
        System.out.println("Array Before deletion: "
                        + Arrays.toString(arr)); 
        arr = IntStream.range(0, arr_del.length) .filter(i -> i != 2).map(i -> arr_del[i]).toArray(); 
            
        System.out.println("Array After deletion: "
                        + Arrays.toString(arr)); 
        
    }
}
