import java.util.*;
public class QueueTester{
    public static void main (String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
            System.out.println("\nOptions \n 1. Enqueue \n 2.Dequeue  \n 3. Peek \n 4. isEmpty  \n 5. Size \n 6. Exit\n");
            switch(sc.nextInt()){
                case 1:{
                    System.out.println("Enter the Data to be enqueued: ");
                    queue.enqueue(sc.nextInt());
                    break;
                }
                case 2:{
                    System.out.println("Element dequeued : "+queue.dequeue());
                    break;
                }
                case 3:{
                    System.out.println("Element at front : "+queue.peek());
                    break;
                }
                case 4:{
                    System.out.println("Queue is "+ (queue.isEmpty()?"empty":"not empty"));
                    break;
                }
                case 5:{
                    System.out.println("Queue has "+queue.getSize()+" elements at present");
                    break;
                }
                case 6:{
                    System.out.println("Exiting");
                    flag = true;
                    break;
                }
                default:{
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }while(flag != true);
    }
}