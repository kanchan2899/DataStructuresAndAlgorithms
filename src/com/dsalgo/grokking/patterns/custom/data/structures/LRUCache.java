package com.dsalgo.grokking.patterns.custom.data.structures;

import java.util.HashMap;

class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode<T> prev;

    public LinkedListNode(T dataVal) {
        this.data = dataVal;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public int size() {
        return this.length;
    }

    public void insertAtHead(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }
    public void insertAtTail(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public void addFirst(LinkedListNode<T> newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public void addLast(LinkedListNode<T> newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public void remove(T data) {
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            if(temp.data == data) {
                this.remove(temp);
                return;
            }
            temp = temp.next;
        }
    }

    public void remove(LinkedListNode<T> node) {
        if(node == null) {
            return;
        }
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        if(node == this.head) {
            this.head = this.head.next;
        }
        if(node == this.tail) {
            this.tail = this.tail.prev;
            if(this.tail != null) {
                this.tail.next = null;
            }
        }
        this.length--;
        node = null;
    }

    public void removeFirst() {
        this.remove(this.head);
    }

    public void removeLast() {
        this.remove(tail);
    }

    public LinkedListNode<T> getFirst() {
        return this.head;
    }

    public LinkedListNode<T> getLast() {
        return this.tail;
    }
}

class Pair {
    public int first;
    public int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

// We will use a LinkedList of a pair of integers where the first integer will be the key and the
// second integer will be the value
class KeyValuePairLL extends LinkedList<Pair> {

};

public class LRUCache {
    int cacheCapacity;

    // hashmap will store a key and iterators of LinkedList nodes
    HashMap<Integer, LinkedListNode<Pair>> cacheMap = new HashMap<>();

    KeyValuePairLL cacheList = new KeyValuePairLL();

    public LRUCache(int size) {
        this.cacheCapacity = size;
    }

    int get(int key) {
        LinkedListNode<Pair> foundIter;

        // check if the key exists in the cache hashmap
        if(cacheMap.containsKey(key)) {
            foundIter = cacheMap.get(key);
        } else {
            return -1;
        }

        LinkedListNode<Pair> listIterator = foundIter;

        // if the key exists, we need to move it to the front of the list
        cacheList.remove(foundIter);
        cacheList.addFirst(listIterator);
        return listIterator.data.second;
    }

    void set(int key, int value) {
        // check if the key exists in the cache hashmap
        if(cacheMap.containsKey(key)) {
            LinkedListNode<Pair> foundIter = cacheMap.get(key);
            LinkedListNode<Pair> listIterator = foundIter;

            // move the node corresponding to key to front of the list
            cacheList.remove(foundIter);
            cacheList.addFirst(listIterator);

            // we then update the value of the node
            listIterator.data.second = value;
            return;
        }

        // if key does not exist and the cache is full
        if(cacheMap.size() == cacheCapacity) {
            // we need to evict the LRU entry

            // get the key of the LRU node
            // the first element of each cache entry is the key
            int keyTemp = cacheList.getLast().data.first;

            // this is why we needed to store a <key, value> pair in the cacheList
            // we would not have  been able to get the key if we had just stored the values

            // remove the last node in the list
            cacheList.removeLast();

            // remove the entry from the cache
            cacheMap.remove(keyTemp);
        }

        // the addFirst function inserts a new element at the front of the list in constant time
        cacheList.insertAtHead(new Pair(key, value));

        // set the value of the key as the list beginning since we added the new element at the
        // head of the list
        if(cacheMap.containsKey(key)) {
            cacheMap.replace(key, cacheList.getFirst());
        } else {
            cacheMap.put(key, cacheList.getFirst());
        }
    }

    public static void main(String[] args) {
        int cacheCapacity = 2;
        LRUCache cache = new LRUCache(cacheCapacity);

        int[] keys = {10, 10, 15, 20, 15, 25, 4};
        String[] values = {"20", "get", "25", "40", "get", "85", "5"};

        for(int i = 0; i < keys.length; i++) {
            if(values[i] == "get") {
                System.out.println(cache.get(keys[i]));
            } else {
                cache.set(keys[i], Integer.parseInt(values[i]));
            }
        }
    }
}
