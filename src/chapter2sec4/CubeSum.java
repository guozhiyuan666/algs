package chapter2sec4;
/*
我的思路和标准答案一样，“删除并打印最小的元素（itj，ij）。然后如果jev，插入元素（i+j+1），1）”，只是这句话没有正确理解
 */
public class CubeSum {
    private static class Unit implements Comparable<Unit> {
        int ij, i, j;
        Unit(int i, int j) {
            this.ij = i * i * i + j * j * j;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Unit a) {
            if (this.ij == a.ij) return 0;
            else if (this.ij < a.ij) return -1;
            else return 1;
        }
    }
//已经能顺利从小大到大打印了，接下来是找到 ab = cd
    public static void main(String[] args) {
        MinPQ<Unit> pq = new MinPQ<>();
        int N = 13;
        for (int i = 0; i < N; i++) {
            pq.insert(new Unit(i, 0));
        }
        while(!pq.isEmpty()){
                Unit temp = pq.delMin();
                System.out.println(temp.ij + " " + temp.i + " " + temp.j);
                if(temp.j < N){
                    pq.insert(new Unit(temp.i, temp.j + 1));
                }
            }
        }
    }

