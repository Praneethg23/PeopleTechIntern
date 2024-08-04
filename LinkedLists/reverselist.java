
public class ReverseList{
    
    
    public static void main (String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtBegining(9);
        list.insertAtBegining(7);
        list.insertAtBegining(5);
        list.insertAtBegining(3);
        list.insertAtBegining(1);
        list.insertAtBegining(0);
        list.printList();
        list.reverse();
        list.printList();
        
    }
}