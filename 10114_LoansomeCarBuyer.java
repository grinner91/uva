import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by zaman on 15/01/16.
 *
 * 10114 - Loansome Car Buyer - solution
 *
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1055
 *
 */
class Main_10114_LoansomeCarBuyer {


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        while(true) {

            int monthCount = scanner.nextInt();
            if(monthCount < 0) break;

            float downpayment = scanner.nextFloat();
            float loanAmount = scanner.nextFloat();
            int rateCount = scanner.nextInt();

            scanner.nextLine();


            int month;
            float rate;
            float[] depri = new float[monthCount + 1];
            String line;
            StringTokenizer tokenizer;

            for (int i = 0; i < rateCount; i++) {
                line = scanner.nextLine();
                tokenizer = new StringTokenizer(line);

                month = Integer.parseInt(tokenizer.nextToken());
                rate = Float.parseFloat(tokenizer.nextToken());

                Arrays.fill(depri, month, monthCount, rate);
            }

            float carValue = downpayment + loanAmount, monthlyPayment = loanAmount / monthCount;
            month = 0;
            carValue = carValue - (depri[month] * carValue);

            if (Float.compare(carValue, loanAmount) < 0)
            {
                for (month=1; month < monthCount; month++) {

                    carValue -= (depri[month] * carValue);
                    loanAmount -= monthlyPayment;

                    if (Float.compare(carValue, loanAmount) > 0) break;
                }
            }

            if (month == 1) System.out.println(month+" month");
            else  System.out.println(month+" months");
        }
    }
}


/*


12 500.0 9999.99 2
0 .05
2 .1
-12 500.0 9999.99 2


SampleInput
30 500.0 15000.0 3
0 .10
1 .03
3 .002
12 500.0 9999.99 2
0 .05
2 .1
60 2400.0 30000.0 3
0 .2
1 .05
12 .025
-99 0 17000 1

SampleOutput
4 months
1 month
49 months


 */
