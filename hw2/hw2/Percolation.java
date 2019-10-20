package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF a;
    public int N;
    public int C = 0;
    public int[] OpenSet;

    public Percolation(int M) {
        N = M;
        a = new WeightedQuickUnionUF(N * N);
        OpenSet = new int[N * N];
    }                // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col) {
        C = C + 1;
        if (row == 1) {
            if (OpenSet[N + col - 1] == 1)
                a.union(N + col - 1, col - 1);
            if (col == 1)
                if (OpenSet[1] == 1)
                    a.union(1, 0);
            if (col == N)
                if (OpenSet[N - 2] == 1)
                    a.union(N - 2, N - 1);
            for (int i = 0; i < 3; i++)
                if (OpenSet[col - 2 + i] == 1)
                    a.union(+col - 2 + i, col - 1);
        } else if (row == N) {
            if (OpenSet[(N - 2) * N + col - 1] == 1)
                a.union((N - 2) * N + col - 1, (N - 1) * N + col - 1);
            if (col == 1)
                if (OpenSet[(N - 1) * N + 1] == 1)
                    a.union((N - 1) * N + 1, (N - 1) * N);
            if (col == N)
                if (OpenSet[N * N - 1] == 1)
                    a.union(N * N - 1, N * N);
            for (int i = 0; i < 3; i++)
                if (OpenSet[(N - 1) * N + col - 2 + i] == 1)
                    a.union((N - 1) * N + col - 2 + i, (N - 1) * N + col - 1);
        } else if (col == 1) {
            for (int i = 0; i < 3; i++)
                if (OpenSet[(row - 2 + i) * N] == 1)
                    a.union((row - 2 + i) * N, (row - 1) * N);
            if (OpenSet[(row - 1) * N + 1] == 1)
                a.union((row - 1) * N + 1, (row - 1) * N);
        } else if (col == N) {
            for (int i = 0; i < 3; i++)
                if (OpenSet[(row - 1 + i) * N - 1] == 1)
                    a.union((row - 1 + i) * N - 1, row * N - 1);
            if (OpenSet[row * N - 2] == 1)
                a.union(row * N - 2, row * N - 1);
        } else {
            for (int i = 0; i < 3; i++) {
                if (OpenSet[(row - 1) * N + col - 2 + i] == 1)
                    a.union((row - 1) * N + col - 2 + i, (row - 1) * N + col - 1);
                if (OpenSet[(row - 2 + i) * N + col - 1] == 1)
                    a.union((row - 2 + i) * N + col - 1, (row - 1) * N + col - 1);
            }
        }
        OpenSet[(row - 1) * N + col - 1] = 1;
    }// open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (OpenSet[(row - 1) * N + col - 1] == 1)
            return true;
        return false;
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (a.connected(i, (row - 1) * N + col - 1))
                return true;
        }
        return false;
    }  // is the site (row, col) full?

    public int numberOfOpenSites() {
        return C;
    }           // number of open sites

    public boolean percolates() {
        for (int i = 0; i < N; i++)
            for (int j = (N - 1) * N; j < N * N; j++) {
                if (a.connected(i, j))
                    return true;
            }
        return false;
    }              // does the system percolate?

    public static void main(String[] args) {
        Percolation test = new Percolation(4);
        System.out.println(test.isOpen(3, 4));
        test.open(3, 4);
        System.out.println(test.isOpen(3, 4));
        test.open(2, 4);
        test.open(2, 2);
        test.open(2, 1);
        test.open(2, 3);
        test.open(4, 3);
        System.out.println(test.isFull(3, 4));
        test.open(1, 2);
        System.out.println(test.isFull(3, 4));
        System.out.println(test.isFull(2, 1));
        System.out.println(test.percolates());
        test.open(3, 3);
        System.out.println(test.percolates());
    }   // use for unit testing (not required, but keep this here for the autograder)

}
