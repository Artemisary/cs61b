package hw2;

import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    PercolationFactory a = new PercolationFactory();
    Percolation b;
    int[] x;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N < 1 || T < 1) {
            throw new java.lang.IllegalArgumentException("We need a positive number!");
        }
        b = a.make(N);
        x = new int[T];
        for (int i = 0; i < T; i++) {
            int c = StdRandom.uniform(N * N);
            while (!b.percolates()) {
                while (b.isOpen(c / 4, c - c / 4 + 1))
                    c = StdRandom.uniform(N * N);
                b.open(c / 4, c - c / 4 + 1);
            }
            x[i] = b.numberOfOpenSites();
        }
    }   // perform T independent experiments on an N-by-N grid

    public double mean() {
        double m = 0;
        for (int i = 0; i < x.length; i++) {
            m = (double) x[i] + m;
        }
        return m / (double) x.length;
    }                                           // sample mean of percolation threshold

    public double stddev() {
        double s = 0;
        for (int i = 0; i < x.length; i++) {
            s = ((double) x[i] - this.mean()) * ((double) x[i] - this.mean()) + s;
        }
        return Math.sqrt(s / (double) (x.length - 1));
    }                                         // sample standard deviation of percolation threshold

    public double confidenceLow() {
        return this.mean() - 1.96 * this.stddev() / Math.sqrt((double) x.length - 1);
    }                                  // low endpoint of 95% confidence interval

    public double confidenceHigh() {
        return this.mean() + 1.96 * this.stddev() / Math.sqrt((double) x.length - 1);
    }                                 // high endpoint of 95% confidence interval

}
