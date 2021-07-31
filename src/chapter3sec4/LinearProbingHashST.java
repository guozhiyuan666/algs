package chapter3sec4;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    private int N = 0;//键值对个数
    private int M = 16;//线性散列表默认大小为16；
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST(){
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    public LinearProbingHashST(int cap){
        this.M = cap;
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];

    }

    private int hash(Key k){
        return (k.hashCode() & 0x7fffffff) % M;//这里不是素数了？
    }
    private void resize(int cap){
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for(int i = 0; i < M; i++){
            if(keys[i] != null){
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }
    public void put(Key k, Value v){
        if(N >= M / 2) resize(M * 2);
        int i;
        for(i = hash(k); keys[i] != null; i = (i + 1) % M){//keys[hash(k)]为空时直接结束循环，执行后续赋值语句
            if(keys[i].equals(k)) { //keys[i]不为空且与想要添加的键相等，则重新为该键赋值
                vals[i] = v;
                return;
            }
        }
        keys[i] = k;
        vals[i] = v;
        N++;
    }
    public Value get(Key k){
        for(int i = hash(k); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(k)){
                return vals[i];//命中
            }
        }
        return null;//for循环结束后，未命中；
    }
    public boolean contains(Key k){
        return get(k) != null;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for(int i = 0; i < M; i++){
            if(keys[i] != null){
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

}
