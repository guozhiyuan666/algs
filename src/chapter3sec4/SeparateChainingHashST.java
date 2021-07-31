package chapter3sec4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;


/**
 * 拉链法处理碰撞的散列表
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {
    private int N; //键值对的个数；
    private int M; //散列表大小
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST(){
        this(997);//默认大小，改成动态调整大小的更好
    }
    public SeparateChainingHashST(int M){
        this.M = M;
        SequentialSearchST[] st;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i = 0; i < M; i++){
            st[i] = new SequentialSearchST();
        }
    }
    public int hash(Key k){
        return (k.hashCode() & 0x7fffffff) % M;
    }
    public void put(Key k, Value v){
        st[hash(k)].put(k, v);
    }
    public Value get(Key k){
        Value v = st[hash(k)].get(k);
        return v;
    }
    public void delete(Key k){
        st[hash(k)].delete(k);
    }
    public boolean contains(Key k){
        return get(k) != null;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++){
            if(!st[i].isEmpty()){
                for(Key k : st[i].keys())
                queue.enqueue(k);
            }
        }
        return queue;
    }
}


