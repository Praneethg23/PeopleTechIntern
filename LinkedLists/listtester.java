import java.util.*;

public class ListTester{
    public static void main (String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
            System.out.println("\nOptions \n 1. Insert a element at Start \n 2. Insert a element at End \n Insert a element at Position \n 4. Delete Element at Start \n 5. Delete Element at end \n 6. Delete By Element \n 7. List Size \n 8. Print List \n9Reverse List .\n 10. Exit\n");
            
            switch(sc.nextInt()){
                case 1 :{
                    System.out.println("Enter the Data to be inserted : ");
                    list.insertAtBegining(sc.nextInt());
                    break;
                }
                case 2 :{
                    System.out.println("Enter the Data to be inserted : ");
                    list.insertAtEnding(sc.nextInt());
                    break;
                }
                case 3 :{
                    System.out.println("Enter the position");
                    int pos = sc.nextInt();
                    System.out.println("Enter the Data to be inserted : ");
                    list.insertAtPosition(sc.nextInt(),pos);
                    break;
                }
                case 4:{
                    list.deleteAtHead();
                    break;
                }
                case 5:{
                    list.deleteAtEnd();
                    break;
                }
                case 6:{
                    System.out.println("Enter the Element to be Deleted");
                    list.deleteByData(sc.nextInt());
                    break;
                }
                case 7:{
                    System.out.println("Size of the List : "+list.getListSize());
                    break;
                }
                case 8:{
                    list.printList();
                    break;
                }
                case 9:{
                    list.reverse();
                    System.out.println("List after reversing");
                    list.printList();
                    break;
                }
                case 10:{
                    System.out.println("Exiting");
                    flag = true;
                    break;
                }
            }
        }while(flag != true);
    }
}