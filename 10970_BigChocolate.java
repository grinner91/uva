import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zaman on 19/01/16.
 *
 * 10970 - Big Chocolate
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1911
 *
 */
 class Main_10970_BigChocolate {


    public  static  void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        while(scanner.hasNext())
        {

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            System.out.println((row * col)-1);

        }

    }

}
