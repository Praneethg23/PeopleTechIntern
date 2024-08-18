
class BinaryTree{
    class Node{
        int val;
        Node right,left;
        public Node(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
    Node root;
    int size;
    public BinaryTree(){
        this.root = null;
        size = 0;
    }
    public void insert(int val){
        Node temp = new Node(val);
        size++;
        if(size==1){
            root = temp;
            return;
        }
        Node trav = root;
        int j = (int)Math.pow(size,0.5);
        int k = (int)Math.pow(2,j);
        int end = (int)Math.pow(2,j+1);
        while(end-k > 2){
            int pivot = k+((end - k)/2) - 1;
            if(size > pivot){
                trav = trav.right;
                k = pivot + 1;
            }
            else{
                trav = trav.left;
                end = pivot;
            }
        }
        if(size == k){
            trav.left = temp;
        }else{
            trav.right = temp;
        }
    }
    public int height(){
        return (int)Math.pow(size,0.5)+1;
    }
    public int delete(){
        int res;
        if(size==0){
            return -1;
        }
        if(size==1){
            res = root.val;
            root = null;
            return res;
        }
        Node trav = root;
        int j = (int)Math.pow(size,0.5);
        int k = (int)Math.pow(2,j);
        int end = (int)Math.pow(2,j+1);
        while(end-k > 2){
            int pivot = k+((end - k)/2) - 1;
            if(size > pivot){
                trav = trav.right;
                k = pivot + 1;
            }
            else{
                trav = trav.left;
                end = pivot;
            }
        }
        if(size == k){
            res = trav.left.val;
            trav.left = null;
        }else{
            res = trav.right.val;
            trav.right = null;
        }
        return res;
    }
    public String inorder(Node temp){
        if(temp == null){
            return "";
        }
        else{
            return inorder(temp.left)+" "+temp.val+" "+inorder(temp.right);
        }
    }
}
