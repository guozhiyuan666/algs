package Chapter3sec1;

import java.util.Iterator;

/**
 * 基于两个数组实现二分查找
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST <Key extends Comparable<Key>, Value> implements Iterable<Key>{
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capcity){//动态调整数组大小，未实现
        keys = (Key[]) new Comparable[capcity];
        vals = (Value[]) new Comparable[capcity];
    }

    /**
     * 核心算法，二分查找符号表，rank()返回比key小的个数
     * @param key
     * @return int
     */
    public int rank(Key key){
        int lo = 0;
        int hi = N - 1;
        while(lo <= hi){ //这里是 <= ！！
            int mid = ( lo + hi ) / 2;
            int cmp = key.compareTo(keys[mid]);
            if( cmp == 0) return mid;
            else if(cmp < 0) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;//返回lo，若key比所有keys数组中元素都大，lo一直在更新，若key比所有keys数组中元素都小，则lo = 0；
    }
    public void put(Key key,Value val){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val; //命中，更新值，结束
            return;
        }
        else{
            for(int j = N; j > i; j--){  //未命中，插入新的键值对，比key大的向后移动一位
                keys[j] = keys[j - 1];
                vals[j] = vals[j - 1];
            }
            keys[i] = key;
            vals[i] = val;
        }
        N++;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }else{
            return null;
        }
    }

    public Key[] keys(){
        return keys;
    }
    public boolean contains(Key key){
        return rank(key) < N && keys[rank(key)].compareTo(key) == 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return new BinarySearchSTIterator();
    }
    public class BinarySearchSTIterator implements Iterator<Key>{
        int i = 0;
        public boolean hasNext(){
            return i < N;
        }
        public Key next(){
            Key key;
            key = keys[i];
            i +=1;
            return key;
        }
    }
}
