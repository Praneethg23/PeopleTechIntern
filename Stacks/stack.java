public class Stack{
    DoubleLinkedList list;
    int size;
    Stack(){
        size = 0;
        list = new DoubleLinkedList();
    }
    public void push(int data){
        list.insertAtEnding(data);
        size++;
    }
    public int pop(){
        if(size>0){
            size--;
            return list.deleteAtEnd();
        }
        else{
            System.out.println("Empty Stack");
            return -1;
        }
    }
    public int peek(){
        if(size>0){
            return list.getTopData();
        }
        else{
            System.out.println("Empty Stack");
            return -1;
        }
    }
    public boolean isEmpty(){
        if(size>0){
            return false;
        }
        else{
            return true;
        }
    }
    public int getSize(){
        return size;
    }
}