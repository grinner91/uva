
/**
 * Created by zaman on 12/02/16.
 *
 * Quick Sort Java Implementation
 *
 */

public class QuickSort {
    int[] data;
    final int MAX = 100;

    public QuickSort()
    {
        data = new int[MAX];
    }

    private void dummyData()
    {
        for(int i=0; i < MAX; i++)
        {
            data[i] = (int)( Math.random() * (double)100.0);
        }
    }


    private void quickSort(int[] data, int left, int right)
    {
        int pivot = data[(left+right) / 2];
        int low = left, high = right, temp;

        while(low <= high)
        {
            while(data[low] < pivot)  {  low++;    }
            while(data[high] > pivot)   {  high--;    }

            if(low <= high) {
                temp = data[high];
                data[high] = data[low];
                data[low] = temp;
                low++;
                high--;
            }
        }
        //low is pivot index
        if(left < low-1)  quickSort(data,left ,low-1);
        if(low < right) quickSort(data, low, right);
    }

    public void sort()
    {
        quickSort(data,0, data.length-1);
    }


    public  void printData()
    {
        for(int i =0; i < MAX; i++)
        {
            System.out.print(data[i]+", ");
        }
        System.out.println();
    }


    public  void printSortedData()
    {
        for(int i =0; i < MAX; i++)
        {
            System.out.print(data[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        QuickSort qs = new QuickSort();
        qs.dummyData();
        qs.printData();
        qs.sort();
        qs.printSortedData();

    }
}
