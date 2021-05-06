package chapter1sec5;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionPathCompressionUF {
    private int count;
    private int[] id;
    QuickUnionPathCompressionUF(int N){
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
        count = N;
    }
    public int find(int p){
        if(p == id[p]) return p;
        return id[p] = find(id[p]);//递归找到根节点后，将此节点直接连接到根节点
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;
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
