package chapter1sec5;

import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF {
    int[] uf;
    int[] sz;//加权，保证将小树连接到大树
    int count;

    WeightedQuickUnionUF(int N){
        uf = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
           uf[i] = i;
        }
        for(int j = 0; j < N; j++){
            sz[j] = 1;
        }
        count = N;
    }
    public int find(int p){
        while(p != uf[p]){
            p = uf[p];
        }
        return p;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(sz[pRoot] < sz[qRoot]) { uf[pRoot] = qRoot; sz[qRoot] += sz[pRoot];} //把pRoot接到qRoot上
        else                      { uf[qRoot] = pRoot; sz[pRoot] += sz[qRoot];}
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)){
                continue;
            }
            uf.union(p,q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count + "个连通分量");
    }

}
