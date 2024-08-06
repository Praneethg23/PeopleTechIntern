class DoubleLinkedList{
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            next = null;
            prev = null;
        }
        public void setData(int data){
            this.data=data;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setPrev(Node prev){
            this.prev = prev;
        }
        public int  getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
        public Node getPrev(){
            return prev;
        }
    }
    Node head;
    Node top;
    DoubleLinkedList(){
        head = null;
        top = null;
    }
    public void insertAtBegining(int data){
        Node node = new Node(data);
        if(head != null){
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        else{
            head = node;
            top = node;
        }
    }
    public void insertAtEnding(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            top = node;
        }
        else{
            top.setNext(node);
            node.setPrev(top);
            top = node;
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
            node.setPrev(temp);
            if(temp.getNext()!=null){
                temp.getNext().setPrev(node);
            }else{
                top = node;
            }
            temp.setNext(node);
        }
    }
    public int deleteAtHead(){
        if(head == null){
            System.out.println("list is empty");
            return -1;
            
        }
        else{
            int res = head.getData();
            System.out.println("Deleted "+head.getData());
            head = head.getNext();
            if(head == null){
                top = null;
            }
            return res;
        }
    }
    public int deleteAtEnd(){
        if(head == null){
             System.out.println("list is empty");
             return -1;
        }
        else if(head.getNext()==null){
            return deleteAtHead();
        }
        else{
            int res = top.getData();
            Node temp = top.getPrev();
            top.prev = null;
            temp.next = null;
            top = temp;
            return res;
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
    public int getHeadData(){
        if(head!=null){
            return head.getData();
        }
        else{
            System.out.println("Empty List");
            return -1;
        }
    }
    public int getTopData(){
        if(top!=null){
            return top.getData();
        }
        else{
            System.out.println("Empty List");
            return -1;
        }
    }
    
}