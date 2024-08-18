class AVLTree{
     class Node{
        int val,height;
        Node right,left;
        public Node(int val){
            this.val = val;
            this.height=1;
            this.right = null;
            this.left = null;
        }
    }
    Node root;
    int size;
    public BinarySearchTree(){
        this.root = null;
        size = 0;
    }
    public Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 
        x.right = y; 
        y.left = T2; 
        y.height = 1 + Math.max(height(y.left), height(y.right)); 
        x.height = 1 + Math.max(height(x.left), height(x.right)); 
        return x; 
    } 
    public Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
        y.left = x; 
        x.right = T2;
        x.height = 1 + Math.max(height(x.left),height(x.right)); 
        y.height = 1 + Math.max(height(y.left), height(y.right)); 
        return y; 
    } 
    public Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }
    public Node insertRec(Node root,int val){
         if (node == null) 
            return new Node(val);
        if (val < node.val) 
            node.left = insertRec(node.left, val); 
        else (val > node.val) 
            node.right = insertRec(node.right, val); 
        
        if(root.right!=null && root.left!=null){
            root.height = 1 + Math.max(root.left.height,root.right.height);
        }else if(root.right!=null){
            root.height = 1 + root.right.height;
        }
        else{
            root.height = 1 + root.left.height;
        }
        int diff = getDiff(root);
        if (diff > 1 && val < node.left.val) 
            return rightRotate(node); 

        if (diff < -1 && val > node.right.val) 
            return leftRotate(node); 

 
        if (diff > 1 && val > node.left.val) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        if (diff < -1 && val < node.right.val) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 

        return node;
        
    }
    public int getDiff(Node root){
        if (root == null)
            return 0;
        if(root.right!=null && root.left!=null){
            return root.left.height - root.right.height;
        }else if(root.right!=null){
            return (0 - root.right.height);
        }
        else{
            return root.left.height;
        }
    }
    public void insert(int val){
        Node temp = new Node(val);
        if(root==null){
            Node temp = new Node(val);
            root = temp;
        }
        else{
            root = insertRec(root,temp);
        }
    }
    
    public Node deleteRec(Node root, int val) {
        if (root == null)
            return root;
        if (val < root.val)
            root.left = deleteRec(root.left, val);
        else if (val > root.key)
            root.right = deleteRec(root.right, val);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else 
                    root = temp; 
            } else {
                Node temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteRec(root.right, temp.val);
            }
        }
        if (root == null)
            return root;
        if(root.right!=null && root.left!=null){
            root.height = 1 + Math.max(root.left.height,root.right.height);
        }else if(root.right!=null){
            root.height = 1 + root.right.height;
        }
        else if(root.left!=null){
            root.height = 1 + root.left.height;
        }
        else{
            root.height = 1;
        }


        int diff = getDiff(root);

        if (diff > 1 && getDiff(root.left) >= 0)
            return rightRotate(root);

        if (diff > 1 && getDiff(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (diff < -1 && getDiff(root.right) <= 0)
            return leftRotate(root);

        if (diff < -1 && getDiff(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public String inorder(Node temp){
        if(temp == null){
            return "";
        }
        else{
            return inorder(temp.left)+" "+temp.val+" height :"+temp.height+" "+inorder(temp.right);
        }
    }
}