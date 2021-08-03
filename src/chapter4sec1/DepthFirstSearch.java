package chapter4sec1;

public class DepthFirstSearch {
    private boolean mark[]; //标记调用过dfs()的顶点，即遍历过的顶点
    private int count; //与顶点s连通的定顶点数

    public DepthFirstSearch(Graph g, int s){
        mark = new boolean[g.V()];
        dfs(g,s);
    }
    public void dfs(Graph g, int v){ //调用一次dfs（），该顶点就被遍历了
        mark[v] = true;
        count++;
        for(int w : g.adj(v)){//未被遍历过的与v相邻的顶点，继续调用dfs（）
            if(!mark[w]){
                dfs(g, w);
            }
        }
    }
    public boolean mark(int w){
        return mark[w];
    }
    public int count(){
        return count;
    }

}
