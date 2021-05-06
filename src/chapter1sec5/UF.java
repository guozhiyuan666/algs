package chapter1sec5;

import edu.princeton.cs.algs4.StdIn;

public class UF {
    int count;
    int [] uf;
    UF(int N){
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

/*
    public int find(int p){
        return uf[p];
    }
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(qID == pID){return;}
        if(qID != pID){
            for(int j = 0; j < uf.length; j++){
                if(uf[j] == pID){
                    uf[j] = qID;
                }
            }
        }
        count--;
    }
*/

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
