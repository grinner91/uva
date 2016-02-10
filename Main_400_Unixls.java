/**
 * Created by zaman on 09/02/16.
 *
 * 400 - Unix ls
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=341
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

 class Main_400_Unixls {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String str;
        ArrayList<String> files;
        while(scanner.hasNextLine())
        //while(true)
        {
            str = scanner.nextLine();
            if(null == str || str.isEmpty()) break;

            int fileCount = Integer.parseInt(str);
            int maxFileNameSize = 0;
            files = new ArrayList<String>();

            for(int i = 0; i < fileCount; i++) {
                str = scanner.nextLine();
                files.add(str);
                if(str.length() > maxFileNameSize)
                    maxFileNameSize = str.length();
            }

            int col =  ( (60 - maxFileNameSize) / (maxFileNameSize + 2)) + 1;

            int row =(int) Math.ceil((double) fileCount / (double) col);

            Collections.sort(files);

            System.out.println("------------------------------------------------------------");

            int len = 0;
            StringBuilder stringBuilder = null;

            for(int r = 0; r < row; r++)
            {
                stringBuilder = new StringBuilder();

                for(int c = r; c < fileCount; c+=row)
                {
                    if(c > r ) stringBuilder.append("  ");

                    str = files.get(c);
                    stringBuilder.append(str);

                    len = maxFileNameSize - str.length();
                    for(int s = 0 ; s < len; s++)
                        stringBuilder.append(" ");
                }
                System.out.println(stringBuilder.toString());
            }


        }
    }
}


/*


Sample Input

10
tiny
2short4me
very_long_file_name
shorter
size-1
size2
size3
much_longer_name
12345678.123
mid_size_name
12
Weaser
Alfalfa
Stimey
Buckwheat
Porky
Joe
Darla
Cotton
Butch
Froggy
Mrs_Crabapple
P.D.
19
Mr._French
Jody
Buffy
Sissy
Keith
Danny
Lori
Chris
Shirley
Marsha
Jan
Cindy
Carol
Mike
Greg
Peter
Bobby
Alice
Ruben


Sample Output

------------------------------------------------------------
12345678.123         size-1
2short4me            size2
mid_size_name        size3
much_longer_name     tiny
shorter              very_long_file_name
------------------------------------------------------------
Alfalfa        Cotton         Joe            Porky
Buckwheat      Darla          Mrs_Crabapple  Stimey
Butch          Froggy         P.D.           Weaser
------------------------------------------------------------
Alice       Chris       Jan         Marsha      Ruben
Bobby       Cindy       Jody        Mike        Shirley
Buffy       Danny       Keith       Mr._French  Sissy
Carol       Greg        Lori        Peter


 */
