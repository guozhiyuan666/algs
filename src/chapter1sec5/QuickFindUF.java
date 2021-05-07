package chapter1sec5;

public class QuickFindUF {
    private int count;
    private int [] uf;
    QuickFindUF(int N){
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
        return uf[p];
    }

    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(qID == pID) {return;}
        for(int j = 0; j < uf.length; j++){
            if(uf[j] == pID){
                uf[j] = qID;
            }
        }
        count--;
    }

}

