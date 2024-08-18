class BinarySearchTree{
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
    public void insertRec(Node root,Node temp){
        if(root.val > temp.val){
            if(root.left==null){
                root.left = temp;
            }else{
                insertRec(root.left,temp);
            }
        }else{
            if(root.right==null){
                root.right = temp;
            }else{
                insertRec(root.right,temp);
            }
            
        }
        if(root.right!=null && root.left!=null){
            root.height = 1 + Math.max(root.left.height,root.right.height);
        }else if(root.right!=null){
            root.height = 1 + root.right.height;
        }
        else{
            root.height = 1 + root.left.height;
        }
    }
    public void insert(int val){
        Node temp = new Node(val);
        if(root==null){
            root = temp;
        }
        else{
            insertRec(root,temp);
        }
    }
    public Node deleteRec(Node root,int val){
        
        if(root == null){
            return null;
        }
        if (root.val > val) {
            root.left = deleteRec(root.left, val);
        } else if (root.val < val) {
            root.right = deleteRec(root.right, val);
        } else {
            if (root.left == null) {
                if(root.right!=null && root.right.left!=null && root.right.right!=null){
                    root.right.height = 1 + Math.max(root.right.left.height,root.right.right.height);
                }else if(root.right!=null && root.right.right!=null){
                    root.right.height = 1 + root.right.right.height;
                }else if(root.right!=null && root.right.left!=null){
                    root.right.height = 1 + root.right.left.height;
                }else{
                    root.right.height = 1;
                }
                return root.right;
            }
            if (root.right == null) {
                if(root.left!=null && root.left.left!=null && root.left.right!=null){
                    root.left.height = 1 + Math.max(root.left.left.height,root.left.right.height);
                }else if(root.left!=null && root.left.right!=null){
                    root.left.height = 1 + root.left.right.height;
                }else if(root.left!=null && root.left.left!=null){
                    root.left.height = 1 + root.left.left.height;
                }else{
                    root.left.height = 1;
                }
                return root.left;
            }
            Node succ = getSuccessor(root);
            root.val = succ.val;
            root.right = deleteRec(root.right, succ.val);
        }
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