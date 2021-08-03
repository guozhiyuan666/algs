package chapter4sec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("F:\\IDE\\IDEAWorkPlace\\algs\\out\\production\\algs\\tinyG.txt"));
        Graph g = new Graph(in);

        System.out.println(g.V());
    }
}
