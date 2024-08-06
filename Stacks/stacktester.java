import java.util.*;
public class StackTester{
    public static void main (String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
            System.out.println("\nOptions \n 1. Push \n 2. Pop \n 3. Peek \n 4. isEmpty  \n 5. Size \n 6. Exit\n");
            switch(sc.nextInt()){
                case 1:{
                    System.out.println("Enter the Data to be pushed : ");
                    stack.push(sc.nextInt());
                    break;
                }
                case 2:{
                    System.out.println("Element popped : "+stack.pop());
                    break;
                }
                case 3:{
                    System.out.println("Element at top : "+stack.peek());
                    break;
                }
                case 4:{
                    System.out.println("Stack is "+ (stack.isEmpty()?"empty":"not empty"));
                    break;
                }
                case 5:{
                    System.out.println("Stack has "+stack.getSize()+" elements at present");
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