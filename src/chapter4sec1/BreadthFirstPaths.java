package chapter4sec1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {
    private int[] edgeTo;
    private boolean[] mark;
    private int s;

    public BreadthFirstPaths(Graph g, int s){
        edgeTo = new int[g.V()];
        mark = new boolean[g.V()];
        this.s = s;
        bfs(g, s);
    }
    public void bfs(Graph g, int s){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);                           //用一个队列辅助 P345
        mark[s] = true;                             //从队列中删去顶点0并将它的相邻顶点2、1 和 5 加入队列中，标记它们并分别将它们在 edgeTo[] 中的值设为 0
        while(!queue.isEmpty()){                    //从队列中删去顶点 2 并检查它的相邻顶点 0 和 1，发现两者都已经被标记。将相邻的顶点 3和 4 加入队列，标记它们并分别将它们在 edgeTo[] 中的值设为 2
            int v = queue.dequeue();                //从队列中删去顶点 1 并检查它的相邻顶点 0 和 2，发现它们都已经被标记了。
            for(int x : g.adj(v)){                  //从队列中删去顶点 5 并检查它的相邻顶点 3 和 0，发现它们都已经被标记了
                if(!mark[x]){                       //从队列中删去顶点 3 并检查它的相邻顶点 5、 4 和 2，发现它们都已经被标记了
                    edgeTo[x] = v;                  //从队列中删去顶点 4 并检查它的相邻顶点 3 和 2，发现它们都已经被标记了
                    mark[x] = true;
                    queue.enqueue(x);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return mark[s];
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
