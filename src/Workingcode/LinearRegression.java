package Workingcode;

import java.util.Arrays;

public class LinearRegression {
    private static double mean(double[] xs) {
        double total = 0;
        for (double x : xs)
            total += x;
        return total / xs.length;
    }

    public static double getSlope(double[] xs, double[] ys) {
        double xMean = mean(xs);
        double yMean = mean(ys);

        double numerator = 0;
        double denominator = 0;
        for (int i = 0; i < xs.length; i++) {
            double dx = xs[i] - xMean;
            double dy = ys[i] - yMean;
            numerator += dx * dy;
            denominator += dx * dx;
        }
        return numerator / denominator;
    }

    public static double getExponent(double[] xs, double[] ys) {
        if (xs.length != ys.length)
            throw new IllegalArgumentException("xs and ys must have the same length.");
        if (xs.length < 2)
            throw new IllegalArgumentException("Must have at least two coordinates.");

        double[] log_xs = new double[xs.length];
        double[] log_ys = new double[ys.length];

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] <= 0 || ys[i] <= 0)
                throw new IllegalArgumentException("all coordinate values must be positive.");
            log_xs[i] = Math.log(xs[i]);
            log_ys[i] = Math.log(ys[i]);
        }
        return getSlope(log_xs, log_ys);
    }

    public static void reportBigO(double[] xs, double[] ys) {
        System.out.println("This function appears to be O(n^" + getExponent(xs, ys) + ")");
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        try {
            double[] xs = new double[10];
            double[] ys = new double[xs.length];

            for (double i = 0.0; i <= xs.length; i++) {
                Arrays.fill(xs, i);
            }

            for (double s = 0.0; s <= ys.length; s++) {
                Arrays.fill(ys, Math.sqrt(xs[(int) s]));
            }

            reportBigO(xs, ys);
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }


    }
}

