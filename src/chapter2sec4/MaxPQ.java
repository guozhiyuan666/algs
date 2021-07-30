package chapter2sec4;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

//    public MaxPQ(){
//        pq = (Key[]) new Comparable[10];
//    }
    public MaxPQ(int maxSize){//构造堆，给数组的容量大小；
        pq = (Key[]) new Comparable[maxSize + 1];
    }
    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void swim(int i){
        while(i > 1 && less(i / 2, i)){
            exch(i / 2, i);
            i = i /2;
        }
    }
    private void sink(int i){
        while( 2 * i <= N){
            int j = 2 * i;
            if(j < N && less(j, j + 1)) j++;
            if(!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    public void insert(Key k){
        pq[++N] = k;
        swim(N);
    }
    public Key delMax(){
        Key k = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return k;
    }
    public Key getMax(){
        return pq[1];
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }
}
