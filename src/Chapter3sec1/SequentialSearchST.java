package Chapter3sec1;

import java.util.ArrayList;
import java.util.Iterator;

public class SequentialSearchST <Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private Node first;
    @Override
    public Iterator<Key> iterator(){
        return new STIterator();
    }
    public class STIterator implements Iterator<Key>{
        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        public Key next(){
            Key key = current.key;
            current = current.next;
            return key;
        }
    }

    private class Node{
        Key key;
        Value val;
        Node next;
        Node(Key key,Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)) return x.val;  //命中，有key这个键
        }
        return null;                         //未命中，无key这个键
    }
    public void put(Key key, Value val){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                x.val = val;   //命中，更新key的值
                return;
            }
        }
        first = new Node(key,val,first);//未命中，创建新节点
    }
    public ArrayList<Key> keys(){  // 无序
        ArrayList<Key> keys = new ArrayList<>();
        for(Node x = first; x != null; x = x.next){
            keys.add(x.key);
        }
        return keys;
    }
    public ArrayList<Key> keys(Key lo, Key hi){//  无序
        ArrayList<Key> keys = new ArrayList<>();
        for(Node x = first; x != null; x = x.next){
            if(x.key.compareTo(lo) > 0 && x.key.compareTo(hi) < 0){
                keys.add(x.key);
            }
        }
        return keys;
    }
    public int size(Key lo, Key hi){
        int size = 0;
        for(Node x = first; x != null; x = x.next){
           size++;
        }
        return size;
    }

}
