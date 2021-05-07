package chapter1sec5;

public class QuickUnionUF {
    private int count;
    private int [] uf;
    QuickUnionUF(int N){
        uf = new int[N];
        for(int i = 0; i < N; i++){
            uf[i] = i;
        }
        count = N;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
    public int find(int p){
        //找出根节点，分量名称
        while(p != uf[p]){
            p = uf[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot){
            return;
        }else{
            uf[pRoot] = qRoot;
            count--;
        }
    }
}
