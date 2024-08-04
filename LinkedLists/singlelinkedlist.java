import java.util.*;

//this is a class for implementation of Linked list and its functionalities
class SingleLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next = null;
        }
        public void setData(int data){
            this.data=data;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public int  getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
    }
    Node head;
    SingleLinkedList(){
        head = null;
    }
    public void insertAtBegining(int data){
        Node node = new Node(data);
        if(head != null){
            node.setNext(head);
        }
        head = node;
    }
    public void insertAtEnding(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }
    public void insertAtPosition(int data,int pos){
        if(pos==0){
            insertAtBegining(data);
        }
        else{
            Node node = new Node(data);
            Node temp = head;
            int pres = 0;
            while(pos>pres+1){
               if(temp.getNext()!=null){
                   temp = temp.getNext();
                   pres++;
               }else{
                   System.out.println("cannot add element at the specified position due to current list size");
                   return;
               }
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            
        }
    }
    public void deleteAtHead(){
        if(head == null){
            System.out.println("list is empty");
        }
        else{
            System.out.println("Deleted "+head.getData());
            head = head.getNext();
        }
    }
    public void deleteAtEnd(){
        if(head == null){
             System.out.println("list is empty");
        }
        else if(head.getNext()==null){
            deleteAtHead();
            return;
        }
        else{
            Node curr = head;
            Node prev = null;
            while(curr.getNext()!=null){
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(null);
            System.out.println("Deleted "+curr.getData());
        }
    }
    public void deleteByData(int data){
        if(head == null){
             System.out.println("list is empty");
        }
        else{
            if(head.getData()==data){
                deleteAtHead();
                return;
            }
            Node curr = head;
            Node prev = null;
            while(curr!=null && curr.getData()!=data){
                prev = curr;
                curr = curr.getNext();
            }
            if(curr!=null){
                prev.setNext(curr.getNext());
                curr.setNext(null);
                System.out.println("Deleted "+data);
            }
            else{
                System.out.println("Couldn't find the element ");
            }
        }
    }
    public int getListSize(){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.getNext();
            size++;
        }
        return size;
    }
    public void printList(){
        if(head==null){
            System.out.println("Empty List");
        }else{
            System.out.println("List : ");
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
            }
        }
    }
    public void reverse(){
        
        if(head!=null && head.getNext()!=null){
            Node curr = head;
            Node prev = null;
            while(curr!=null){
                Node temp = prev;
                prev = curr;
                curr = curr.getNext();
                if(prev!=null){
                    prev.setNext(temp);
                }
                
            }
            head = prev;
        }
    }
    
}