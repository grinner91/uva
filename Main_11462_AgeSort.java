import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by zaman on 12/02/16.
 *
 * 11462 - Age Sort

 *
 */


 class Main_11462_AgeSort {

    int[] ages;

    private void quickSort(int[] data, int left, int right)
    {
        int pivot = data[(left+right)/2];
        int low = left, high = right, temp;

        while(low <= high)
        {
            while (data[low] < pivot) low++;
            while (data[high] > pivot) high--;

            if(low <= high)
            {
                temp = data[low];
                data[low] = data[high];
                data[high] = temp;
                low++;
                high--;
            }
        }
        //low is pivot index
        if(left < low -1 ) quickSort(data,left, low-1);
        if(low < right) quickSort(data,low,right);
    }

    public  void solve()
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases;
        //StringTokenizer tokenizer;
        StringBuilder stringBuilder;

        while(true)
        {
            testCases = scanner.nextInt();
            if(testCases == 0) break;

            ages = new int[testCases];
            //tokenizer = new StringTokenizer(scanner.nextLine());

            for(int i = 0; i < testCases; i++)
            {
                ages[i] = scanner.nextInt(); //Integer.parseInt(tokenizer.nextToken());
            }

            quickSort(ages,0,ages.length-1);

            stringBuilder = new StringBuilder();

            for(int i = 0; i < testCases; i++)
            {
                if(i > 0 ) stringBuilder.append(" ");
                stringBuilder.append(ages[i]);
            }

            System.out.println(stringBuilder.toString());
        }

    }

    public static void main(String[] args)
    {
        new Main_11462_AgeSort().solve();
    }

}

/*

Sample Input
5
3 4 2 1 5
5
2 3 2 3 1
0


Sample Output
1 2 3 4 5
1 2 2 3 3


 */
