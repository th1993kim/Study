package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2750 {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = -1001;
        for (int i=0; i<n; i++) {
            int subMin = 1000;
            for (int j=0; j<n; j++) {
                if (min < arr[j]) {
                    subMin = Math.min(subMin, arr[j]);
                }
            }
            min = subMin;
            System.out.println(min);
        }

    }

    public static void gptSolution(int [] arr, int n) {
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int middleIndex = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, middleIndex - 1);
            quickSort(arr, middleIndex, endIndex);
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, endIndex);
        return i + 1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
