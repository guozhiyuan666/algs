package chapter2sec4;

public class MinPQ <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    MinPQ() {
        pq = (Key[]) new Comparable[5];
    }

    MinPQ(int MaxN) {
        pq = (Key[]) new Comparable[MaxN + 1];
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public void insert(Key v){
        if (N + 1 == pq.length) {
            resize(pq.length * 2);
        }
        pq[++N] = v;
        swim(N);
    }

    public Key getMin(){
        return pq[1];
    }
    public Key delMin(){
        if(N == pq.length / 4){
            resize(pq.length / 2 + 1);
        }
        Key min = pq[1];
        exch(1,N--);
        pq[N + 1] = null;
        sink(1);
        return min;
    }

    /*辅助方法*/
    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private boolean more(int i, int j){
        return pq[i].compareTo(pq[j]) > 0;
    }
    private void swim(int k){
        while(k > 1 && more(k / 2 ,k)){
            exch(k / 2, k);
            k = k / 2;
        }
    }
    private void sink(int k){
        while(2 * k <= N){
            int i = 2 * k;
            if(i < N && more(i, i+1)){
                i++;
            }
            if(!more(k, i)) break;
            exch(k, i);
            k = i;
        }
    }
    private void resize(int cap) {
        Key[] aux = (Key[]) new Comparable[cap];
        for (int i = 0; i <= N; i++) { //这里需要注意，不是i < pq.length  !!!!!!
            aux[i] = pq[i];
        }
        pq = aux;
    }

/*测试主函数*/
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>(2);
        pq.insert(2);
        System.out.println(pq.delMin());
       // System.out.println(pq.delMin());
        pq.insert(1);
        System.out.println(pq.delMin());
        System.out.println(pq.isEmpty());
    }
}
