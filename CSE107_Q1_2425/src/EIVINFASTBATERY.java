import java.io.*;
import java.util.*;

class EIVINFASTBATERY {// Vinfast Battery-lease Policy
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        var cost = reader.nextDouble();// N
        var value = reader.nextDouble();// M
        var noMonth = reader.nextInt();// T
        var rate = reader.nextDouble() / 100;// r

        double moneyRest = value * rate;
        double postPaid = cost - value;

        double rentCost = (postPaid * rate * Math.pow(1 + rate, noMonth))
                / (Math.pow(1 + rate, noMonth) - 1);
                double result = moneyRest + rentCost;

        System.out.println((long) Math.round(result));
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