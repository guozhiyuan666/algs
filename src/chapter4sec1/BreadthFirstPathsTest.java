package chapter4sec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BreadthFirstPathsTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:\\IDE\\IDEAWorkPlace\\algs\\out\\production\\algs\\mediumG.txt"));
        Graph g = new Graph(sc);
        BreadthFirstPaths dfp = new BreadthFirstPaths(g, 0); //起点为0，的所有路径
        Iterable<Integer> path = dfp.pathTo(4); //起点0与200之间的路径
        for(int x : path){
            System.out.print(" " + x);
        }
    }
}
