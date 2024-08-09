import java.util.Random;
import java.util.Arrays;
public class SortTesting{
    static void randomGenerator(int arr[],int ran){
        int n = arr.length;
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(ran);
        }
    }
    static void randomGeneratorFloat(float arr[]){
        int n = arr.length;
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextFloat();
        }
    }
    public static void main (String[] args) {
        int arr[] = new int[30];
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.inSort(arr);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        float arrF[] = new float[20];
        randomGeneratorFloat(arrF);
        System.out.println(Arrays.toString(arrF));
        Sorting.bucketSort(arrF);
        System.out.println(Arrays.toString(arrF));
        randomGenerator(arr,6);
        System.out.println(Arrays.toString(arr));
        arr = Sorting.countSortMain(arr);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        Sorting.radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        randomGenerator(arr,1000);
        System.out.println(Arrays.toString(arr));
        Sorting.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        
        
 
    }
}