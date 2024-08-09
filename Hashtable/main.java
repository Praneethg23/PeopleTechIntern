
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.ArrayList;
import java.util.Objects;

class HashNode {
    String key;
    int value;
    final int hashCode;
    HashNode next;
    public HashNode(String key, int value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}


class Map {
    ArrayList<HashNode> buckets;
    int num;
    int size;


    public Map()
    {
        buckets = new ArrayList<>();
        num = 10;
        size = 0;

        for (int i = 0; i < num; i++)
            buckets.add(null);
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return getSize() == 0; }
    
    private final int hashCode (String key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(String key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % num;

        index = index < 0 ? index * -1 : index;
        return index;
    }


    public int remove(String key)
    {
        
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode head = buckets.get(bucketIndex);


        HashNode prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            prev = head;
            head = head.next;
        }


        if (head == null)
            return -1;


        size--;


        if (prev != null)
            prev.next = head.next;
        else
            buckets.set(bucketIndex, head.next);

        return head.value;
    }

    public int get(String key)
    {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
      
        HashNode head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        return -1;
    }


    public void add(String key, int value)
    {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = buckets.get(bucketIndex);
        HashNode newNode = new HashNode(key, value, hashCode);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);


        if ((1.0 * size) / num >= 0.7) {
            ArrayList<HashNode> temp = buckets;
            buckets = new ArrayList<>();
            num = 2 * num;
            size = 0;
            for (int i = 0; i < num; i++)
                buckets.add(null);

            for (HashNode headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
public class Main{

    public static void main(String[] args)
    {
        Map map = new Map();
        map.add("hello", 1);
        map.add("world", 2);
        map.add("hash", 4);
        map.add("table", 5);
        System.out.println(map.getSize());
        System.out.println(map.remove("world"));
        System.out.println(map.remove("hash"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
}
