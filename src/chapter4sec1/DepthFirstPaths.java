package chapter4sec1;


import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
    private int[] edgeTo;
    private boolean[] mark;
    public final int s;

    public DepthFirstPaths(Graph g, int s){
        edgeTo = new int[g.V()];
        mark  = new boolean[g.V()];
        this.s = s;
        dfs(g, s);
    }
    public void dfs(Graph g, int v){
        mark[v] = true;
        for(int w : g.adj(v)){
            if(!mark[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return mark[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
