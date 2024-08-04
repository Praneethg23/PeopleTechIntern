mport java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class ListNode{
    ListNode prev,next;
    int freq;
    Set<String> strings = new HashSet<>();
    public ListNode() {
        this.freq = 0;
    }
    public ListNode(String string, int freq) {
        this.freq = freq;
        strings.add(string);
    }

    public ListNode insert(ListNode node) {
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }
    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}
class AllOne {
    private final ListNode root = new ListNode();
    private final Map<String, ListNode> map = new HashMap<>();
    public AllOne() {
        root.next = root;
        root.prev = root;
    }
    
    public void inc(String string) {
        if (!map.containsKey(string)) {
            if (root.next == root || root.next.freq > 1) {
                map.put(string, root.insert(new ListNode(string, 1)));
            } else {
                root.next.strings.add(string);
                map.put(string, root.next);
            }
        } else {
            ListNode curr = map.get(string);
            ListNode next = curr.next;
            if (next == root || next.freq > curr.freq + 1) {
                map.put(string, curr.insert(new ListNode(string, curr.freq + 1)));
            } else {
                next.strings.add(string);
                map.put(string, next);
            }
            curr.strings.remove(string);
            if (curr.strings.isEmpty()) {
                curr.remove();
            }
        }
    }
    
    public void dec(String string) {
        ListNode curr = map.get(string);
        if (curr.freq == 1) {
            map.remove(string);
        }else {
            ListNode prev = curr.prev;
            if (prev == root || prev.freq < curr.freq- 1) {
                map.put(string, prev.insert(new ListNode(string, curr.freq - 1)));
            } else {
                prev.strings.add(string);
                map.put(string, prev);
            }
        }
        curr.strings.remove(string);
        if (curr.strings.isEmpty()) {
            curr.remove();
        }
    }
    
    public String getMaxKey() {
        if (root.prev == root) return "";
        return root.prev.strings.iterator().next();
    }
    
    public String getMinKey() {
        if (root.next == root) return "";
        return root.next.strings.iterator().next();
        
    }
}
