import java.io.*;
import java.util.*;

public class EIUCREDIT {// Thẻ tín dụng
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        var N = reader.nextInt();
        var R = reader.nextDouble();
        var T = reader.nextInt();

        var transactions = new HashMap<Integer, Double>();
        for (var i = 0; i < N; i++) {
            var date = reader.nextInt();
            var money = reader.nextDouble();
            transactions.put(date, transactions.getOrDefault(date, (double) 0) + money);
        }

        double balance = 0;
        double interest = 0;
        double temp = 0;
        for (int i = 1; i <= T; i++) {
            if (balance < 0)
                temp += balance;

            if (temp != 0 && i != 1 && i % 30 == 1) {
                interest = temp * (R / 30);
                balance += interest;
                temp = 0;
            }

            if (transactions.get(i) != null)
                balance += transactions.get(i);
        }

        if (balance / (long) balance == 1)
            System.out.println((long) balance);
        else
            System.out.printf("%.7f", balance);
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