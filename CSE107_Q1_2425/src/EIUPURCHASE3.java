import java.io.*;
import java.util.*;

class EIUPURCHASE3 {// Installment Purchase 3
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        long originalPrice = reader.nextLong();
        long prepareMoney = reader.nextLong();
        int numMonth = reader.nextInt();
        double expectedMonthlyInterest = reader.nextDouble();

        double debt = originalPrice - prepareMoney;
        double monthlyInstallment = (debt * expectedMonthlyInterest)
                / (1 - Math.pow(1 + expectedMonthlyInterest, -numMonth));
        System.out.println((long) monthlyInstallment);
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