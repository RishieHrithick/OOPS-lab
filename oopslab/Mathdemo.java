import java.io.*;

class MathOperations {
    public int sum(int a, int b) {
        return a + b;
    }
    public double sum(double a, double b, double c) {
        return a + b + c;
    }
    public int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }
}

public class MathDemo {
    public static void main(String[] args) {
        try (PrintWriter log = new PrintWriter(new FileWriter("MathDemo.log", true))) {
            MathOperations mo = new MathOperations();

            int twoInt = mo.sum(5, 10);
            double threeDouble = mo.sum(2.5, 3.5, 4.5);
            int varargsSum = mo.sum(1, 2, 3, 4, 5);

            String msg1 = "Sum of two ints: " + twoInt;
            String msg2 = "Sum of three doubles: " + threeDouble;
            String msg3 = "Sum using varargs: " + varargsSum;

            System.out.println(msg1);
            System.out.println(msg2);
            System.out.println(msg3);

            log.println(msg1);
            log.println(msg2);
            log.println(msg3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
