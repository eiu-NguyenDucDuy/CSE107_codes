import java.io.*;
import java.util.*;

class EIAPP21222FQ3 {// EIUSAVING 3
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        double[] interestRates = { 0, .0390, .0392, .0395, .0399, .0404,
                .0554, .0572, .0592, .0614, .0638, .0664, .0692 };

        var moneyWanted = reader.nextDouble();
        var noMonth = reader.nextInt();

        double temp = 0;
        for (; noMonth > 0; noMonth--) {
            int year = noMonth / 12;
            int currMonth = noMonth % 12;

            if (currMonth == 0)
                temp += Math.pow(1 + interestRates[12], year);
            else
                temp += Math.pow(1 + interestRates[12], year) * (1 + interestRates[currMonth] / 12 * currMonth);
        }
        double deposit = moneyWanted / temp;

        System.out.println((double) Math.round(deposit * 1e+4) / 1e+4);
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