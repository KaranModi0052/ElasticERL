package ERL;// -----------------------------------------------------
// Assignment #3
// © Karan Modi & Dhruv Panchal
// Written by: Karan Modi - 40220970 & Dhruv Panchal - 40226430
// ---------------------------------------------------

public class MS
{
    private static void merge(long arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        long L[] = new long[n1];
        long R[] = new long[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    private static void sort(long arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static long[] getSortedArr(long[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

}
