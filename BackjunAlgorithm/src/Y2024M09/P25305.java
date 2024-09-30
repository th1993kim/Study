package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringTokenizer scores = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(scores.nextToken());
        }

        quickSort(arr, 0, n - 1);

        System.out.println(arr[n-k]);
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pi = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pi - 1);
            quickSort(arr, pi + 1, endIndex);
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int left = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] > pivot) {
                left ++;
                swap(arr, left, i);
            }
        }

        swap(arr, left + 1, endIndex);
        return left + 1;
    }

    private static void swap(int[] arr, int left, int i) {
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
    }
}
