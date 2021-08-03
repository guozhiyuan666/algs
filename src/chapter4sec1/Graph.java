package chapter4sec1;

import edu.princeton.cs.algs4.Bag;

import java.util.Scanner;

public class Graph {
    private final int V; //顶点个数
    private int E;       //边的条数
    private Bag<Integer>[] adj;

    public Graph(int V){ //创建由V个顶点的图
        this.V = V;      //初始状态有V个顶点
        this.E = 0;      //0条边
        adj = new Bag[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<>();
        }
    }
    public Graph(Scanner in){
        this(in.nextInt());  //初始状态每个邻接表数组为空；
        int E = in.nextInt();
        for(int i = 0; i < E; i++){
            int v = in.nextInt(); //文本里的第一个数，一个顶点
            int w = in.nextInt(); //第二个顶点
            addEdge(v, w);
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public int V(){
        return V; //顶点个数
    }
    public int E(){
        return E; //边的条数
    }
    public Iterable<Integer> adj(int v){//返回顶点v的相邻的顶点
        return adj[v];
    }
}
