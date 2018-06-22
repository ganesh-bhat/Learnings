package com.learning.datastructure;


import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ganes on 20-06-2018.
 */
public class GHashMap<K, V> implements Map<K, V> {

    int size;
    int capacity;
    transient Node<K,V>[] items;
    transient Set<Entry<K,V>> entrySet;
    final int MAX_CAPACITY  = Integer.MAX_VALUE;

    public GHashMap() {
        capacity = 16;
        init();
    }

    public GHashMap(int capacity) {
        if(capacity > MAX_CAPACITY) {
            this.capacity = MAX_CAPACITY;
        } else {
            this.capacity = capacity;
        }
        init();
    }

    private void init() {
        items = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        V value = null;
        int hashCode = hash(key);
        if (items[hashIndex(hashCode)] == null) {
            return false;
        } else {
            Node<K,V> temp = items[hashIndex(hashCode)];
            //check node exists
            while(temp!=null && !key.equals(temp.getKey())){
                temp = temp.next;
            }

            if(temp!=null) {
                //found existing key
                value = temp.getValue();
            }
        }
        return value == null;
    }

    private int hashIndex(int hashCode) {
        int val =  hashIndex(hashCode,items);
        return val;
    }

    private int hashIndex(int hashCode, Node[] table) {
        int val =  hashCode % (table.length);
        return val;
    }


    @Override
    public boolean containsValue(Object value) {
        if(value == null) {
            return false;
        }

        for(Map.Entry entry: entrySet()) {
            if(value.equals(entry.getValue())){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        V value = null;
        int hashCode = hashIndex(hash(key));
        if (items[hashCode] == null) {
            return null;
        } else {
            Node<K,V> temp = items[hashCode];
            //check node exists
            while(temp!=null && !isEquals(temp.key,(K)key)){
                temp = temp.next;
            }

            if(temp!=null && isEquals(temp.key,(K)key)) {
                //found existing key
                value = temp.getValue();
            }
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int hashCode = hash(key);
        int n = items.length;

        if (items[hashIndex(hashCode)] == null) {
            items[hashIndex(hashCode)] = new Node<>(hashCode, key, value, null);
        } else {
            Node<K,V> next = items[hashIndex(hashCode)];
            Node<K,V> temp = next;

            //check node exists
            while(temp!=null && !isEquals(key, temp.getKey())){
                temp = temp.next;
            }

            if(temp!=null && isEquals(key, temp.getKey())) {
                //found existing key
                oldValue = temp.getValue();
                temp.setValue(value);
            } else {
                items[hashIndex(hashCode)] = new Node<>(hashCode, key, value, next);
            }

        }
        if(++size==capacity){
            resize();
        }
        return oldValue;
    }

    private boolean isEquals(K key, K key1) {
        if(key == key1) {
            return true;
        }
        if(key!=null && key.equals(key1)) {
            return true;
        }
        return false;

    }

    private void resize() {
        System.out.println("Resizing");
        Node[] oldTab = items;
        int oldCapacity = capacity;
        if(oldCapacity>=MAX_CAPACITY) {
            return;
        }


        int newCapacity = (capacity << 1);
        if(newCapacity>=MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }


        System.out.println("old capacity:"+capacity+", new:"+newCapacity);

        Node[] newTab = new Node[newCapacity];
        ///need to rehash now

        for(int index=0;index<items.length;index++) {
            if(items[index]!=null) {
                Node node = items[index];
                do {
                    Node temp = node.next;

                    node.next = null;
                    int nodeHash = hashIndex(node.hash, newTab);
                    if(newTab[nodeHash] == null) {
                        newTab[nodeHash] = node;
                    } else {
                        Node prev = newTab[nodeHash];
                        node.next = prev;
                        newTab[nodeHash] = node;
                    }
                    node = temp;
                } while(node!=null);
            }
        }
        capacity = newCapacity;
        items = newTab;
    }

    private int hash(Object key){
        return key == null? 0: key.hashCode();
    }


    @Override
    public V remove(Object key) {
        V oldValue = null;
        int hashCode = hashIndex(hash(key));

        Node<K,V> node = items[hashCode];
        if (node  == null) {
            return null;
        } else {
            if(node.next == null) {//single node
                oldValue = node.value;
                items[hashCode] = null;
            } else {
                Node<K,V> prev = null;
                Node<K,V> temp = node;
                //check node exists
                while(temp!=null && !key.equals(temp.getKey())){
                    prev = temp;
                    temp = temp.next;
                }

                if(temp!=null) {
                    //found existing key
                    oldValue = temp.getValue();
                    //delete temp
                    prev.next = temp.next;
                }
            }

        }
        return oldValue;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (entrySet==null? (entrySet = new EntrySet()):entrySet);
    }

    class EntrySet extends AbstractSet<Entry<K, V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override
        public int size() {
            return size;
        }
    }

    class EntryIterator implements Iterator<Entry<K,V>> {

        Node next;
        int index;

        EntryIterator() {
            index = 0;
            while(items!=null && index< items.length && (next = items[index++])==null);
        }

        @Override
        public boolean hasNext() {
            return next !=null;
        }

        @Override
        public Entry<K, V> next() {
            Entry<K,V> entry = next;

            Node node = next.next;
            if(node == null) {
                while(items!=null && index< items.length && (next = items[index++])==null);
            } else {
                next = node;
            }

            return entry;
        }
    }



    static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        final int hash;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }


    public static void main(String[] args) {
        Map<Integer,String> map = new GHashMap<>(6);

        for(int val: IntStream.range(2, 7).toArray()) {
            map.put(val,""+val);
        }

        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println(map.remove(3));
        System.out.println(map.get(5));
        System.out.println(map.remove(5));

        System.out.println("\n-----");

        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}

