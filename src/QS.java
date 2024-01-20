package ERL;
public class QS {

    private static void swap(long[] arr, int i, int j)
    {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(long[] arr, int low, int high)
    {

        long pivot = arr[high];

        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  private static void quickSort(long[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static long[] getSortedArr(long[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        return arr;
    }
}

