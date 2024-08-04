class Solution {
    //Merge 2 sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        else{
            ListNode head;
            ListNode traversal;
            if(list1.val<=list2.val){
                head = list1;
                traversal = list1;
                list1 = list1.next;
            }
            else{
                head = list2;
                traversal = list2;
                list2 = list2.next;
            }
            while(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    traversal.next=list1;
                    traversal = traversal.next;
                    list1 = list1.next;
                }else{
                    traversal.next=list2;
                    traversal = traversal.next;
                    list2 = list2.next;
                }
            }
            if(list1 == null){
                traversal.next = list2;
            }
            else{
                traversal.next = list1;
            }
            return head;
        }

    }
//Question 2
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr!=null){
            if(prev.val == curr.val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
        
    }
//Question 3
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        else{
            int carry = 0;
            ListNode res = new ListNode();
            ListNode dummy = res;
            while(l1!=null || l2!=null){
                int sum = ((l1!=null)?l1.val:0)+((l2!=null)?l2.val:0)+carry;
                carry = sum/10;
                sum = sum%10;
                dummy.next = new ListNode(sum);
                dummy = dummy.next;
                l1 = ((l1!=null)?l1.next:null);
                l2 = ((l2!=null)?l2.next:null);
            }
            if(carry>0){
                dummy.next = new ListNode(carry);
            }
            return res.next;
        }
    }
//Question 4
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i=0;i<n;i++){
            if(first.next!=null){
                first = first.next;
            }
            else if(i==n-1){
                return head.next;
            }
        }
        while(first.next!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
//Question 5
public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;

        head = temp1;
        while(true){
            ListNode dummy = temp1.next;
            temp1.next = temp;
            if(dummy == null || dummy.next == null){
                temp.next = dummy;
                break;
            }
            temp.next = dummy.next;
            temp = dummy;
            temp1 = temp.next;

        }
        return head;
        
    }
//question 6
public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;  
        while(temp != null){  
            ListNode front = temp.next;  
            temp.next = prev;  
            prev = temp;
            temp = front; 
        }
        return prev;  
    }
    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public ListNode getKPart(ListNode head,int k){
        k -= 1;
        while (head != null && k > 0) {
            k--;
            head = head.next;
        }
        return head;
    
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode kNode = getKPart(curr, k);
            if (kNode == null) {
                if (prev != null) {
                    prev.next = curr;
                }
                break;
            }
            
            ListNode p1 = kNode.next;
            kNode.next = null;
            reverse(curr);
            if (curr == head) {
                head = kNode;
            } else {
                prev.next = kNode;
            }
            prev = curr;

            curr = p1;
        }
        return head;
    }
}
