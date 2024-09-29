package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int[] numbers = new int[n];
        int sum = 0;
        for (int i = 0; i< n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        int middle = quickSelect(numbers, 0, n - 1, n / 2);
        int avg = sum / n;

        System.out.println(avg);
        System.out.println(middle);
    }
    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pi = partition(arr, low, high);

        if (pi == k) {
            return arr[pi];
        } else if (k < pi) {
            return quickSelect(arr, low, pi -1, k);
        } else {
            return quickSelect(arr, pi + 1, high, k);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low -1;
        for (int i=low; i<high; i++) {
            if (arr[i] < pivot) {
                left++;
                swap(arr, left, i);
            }
        }
        swap(arr, left + 1, high);
        return left + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
