/**
 * Created by zaman on 09/02/16.
 *
 * 11777 - Automate the Grades
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2877
 *
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


 class Main_11777_AutomatetheGrades {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for(int t = 1; t <= testCases; t++)
        {

            float term1 = scanner.nextFloat();
            float term2 = scanner.nextFloat();
            float finalexam = scanner.nextFloat();
            float attendance = scanner.nextFloat();

            float[] classtests = new float[3];
            classtests[0] = scanner.nextFloat();
            classtests[1] = scanner.nextFloat();
            classtests[2] = scanner.nextFloat();

            Arrays.sort(classtests);

            float avg = (classtests[1] + classtests[2]) / 2;

            float grade = term1 + term2 + finalexam + attendance + avg;

            /* A ≥ 90% , B ≥ 80% & ¡ 90% , C ≥ 70% & ¡ 80% , D ≥ 60% & ¡ 70% , F < 60%    */

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Case " + t + ": ");

            if( Float.compare(grade,90.0f) >= 0) stringBuilder.append("A");
            else if( Float.compare(grade,80.0f) >= 0) stringBuilder.append("B");
            else if( Float.compare(grade,70.0f) >= 0) stringBuilder.append("C");
            else if( Float.compare(grade,60.0f) >= 0) stringBuilder.append("D");
            else  stringBuilder.append("F");

            System.out.println(stringBuilder.toString());

        }
    }
}

/*


Sample Input

3
15 18 25 8 15 17 12
20 20 30 10 20 20 20
20 20 30 10 18 0 0


Sample Output
Case 1: B
Case 2: A
Case 3: B


 */
