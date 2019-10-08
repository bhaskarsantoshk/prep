package amazon.heaps_and_maps;

import java.util.Hashtable;

public class LRUCache {
    private Hashtable<Integer, DListNode> cache = new Hashtable<>();
    private int capacity;
    private int count;
    private DListNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DListNode();
        tail = new DListNode();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = this.cache.get(key);
        if ( node == null ){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    private void moveToHead(DListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private void addNode(DListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DListNode node) {
        DListNode prev = node.prev;
        DListNode next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    public void set(int key, int value) {
        DListNode node = this.cache.get(key);
        if ( node == null ){
            DListNode newNode = new DListNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if ( count > capacity ){
                DListNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        }
        else{
            node.value = value;
            this.moveToHead(node);
        }
    }

    private DListNode popTail() {
        DListNode popped = tail.prev;
        this.removeNode(popped);
        return popped;
    }

    class DListNode{
        int key;
        int value;
        DListNode next;
        DListNode prev;
    }

}
