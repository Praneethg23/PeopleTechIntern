class Queue{
    DoubleLinkedList list;
    int size;
    Queue(){
        size = 0;
        list = new DoubleLinkedList();
    }
    public void enqueue(int data){
        list.insertAtEnding(data);
        size++;
    }
    public int dequeue(){
        if(size>0){
            size--;
            return list.deleteAtHead();
        }
        else{
            System.out.println("Empty Queue");
            return -1;
        }
    }
    public int peek(){
        if(size>0){
            return list.getHeadData();
        }
        else{
            System.out.println("Empty Queue");
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