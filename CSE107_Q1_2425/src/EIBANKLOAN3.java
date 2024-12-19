import java.io.*;
import java.util.*;

public class EIBANKLOAN3 {// Bank Loan 2
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var cost = reader.nextDouble();
        var maxMonthlyPay = reader.nextDouble();
        var noMonth = reader.nextInt();
        var rate = reader.nextDouble() / 100 / 12;
        var fee = reader.nextDouble() / 100;

        double debt = cost;
        double prePay = 0;

        for (int i = 1; i <= noMonth; i++) {
            double principle = cost / noMonth;
            principle -= prePay;
            double monthlyInterest = debt * rate;

            if (principle > 0) {
                prePay = (maxMonthlyPay - monthlyInterest - principle)
                        / (1 + fee);
                debt = debt - principle - prePay;
            } else {
                prePay = (maxMonthlyPay - monthlyInterest)
                        / (1 + fee);
                debt = debt - prePay;
            }

            if (debt > 0) {
                sb.append(i + " " + (long) Math.round(debt));
                sb.append("\n");
            } else {
                sb.append(i + " " + 0);
                break;
            }
        }

        System.out.println(sb);
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}