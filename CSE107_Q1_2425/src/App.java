import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        var N = sc.nextLong();
        var M = sc.nextLong();
        var K = sc.nextInt();
        var X = sc.nextDouble() / 100;

        double debt = N - M;
        double monthlyPay = debt / K;

        for (int i = 1; i <= K; i++) {
            double payment = monthlyPay + debt * X;
            debt -= monthlyPay;
            sb.append(i + " " + (long) payment).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}