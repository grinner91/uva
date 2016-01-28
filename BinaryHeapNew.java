
/**
 * Created by zaman on 28/01/16.
 */

class BinaryHeapNew {

    int[] data;
    int dataCount;

    public BinaryHeapNew()
    {
        data = new int[100];
        dataCount = 1;
    }

    void insert(int n)
    {
        data[dataCount++] = n;
        heapifyUp();
    }

    void heapifyUp()
    {
        int i = dataCount - 1;
        int parent, temp;

        while( (parent = i / 2) > 0 )
        {
            if(data[i] > data[parent]) {
                swap(i, parent);
            }
            i = parent;
        }
    }

    void swap(int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    void heapifyDown()
    {

        int i = 1;
        int left, right, temp;

        while(i < dataCount)
        {

            left = i * 2;
            right = (i * 2 ) + 1;

            if(left > dataCount) break;

            if(data[left] > data[right] && data[left] > data[i])
            {
                swap(left,i);
                i = left;
            }
            else if (data[right] > data[i])
            {
                swap(right,i);
                i = right;
            }
            else
                break;
        }
    }

    int extractMax()
    {

        int max = data[1];
        data[1] = data[dataCount];
        data[dataCount] = -1;
        dataCount--;

        heapifyDown();

        return max;
    }

    void sort()
    {
        dataCount--;
        while(dataCount>=1)
            System.out.print(extractMax()+", ");

    }

    public  static void main(String[] args)
    {

        BinaryHeapNew bh = new BinaryHeapNew();
//
//        bh.insert(2);
//        bh.insert(3);
//        bh.insert(5);
        for(int i = 0; i < 20; i++)
        {
            int n = (int)(Math.random() * 100);
            System.out.print(n+", ");

            bh.insert(n);
        }

        System.out.println();

        //bh.extractMax();

        bh.sort();

        System.out.println();

    }
}
