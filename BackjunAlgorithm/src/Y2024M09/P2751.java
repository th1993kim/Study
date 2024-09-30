package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        mergeSortSolution(arr, n);
//        heapSortSolution(arr, n);

        for (int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void heapSortSolution(int[] arr, int n) {
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 -1; i>=0; i--) {
            heapify(arr, n , i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n , largest);
        }

    }

    private static void mergeSortSolution(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            mergeSort(arr, left, mid, right);
        }
    }

    private static void mergeSort(int[] arr, int left, int mid, int right) {
        int n1 = mid -left + 1; //왼쪽 배열의 개수
        int n2 = right - mid; //우측 배열의 개수

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];

        for (int i = 0; i < n2; ++i)
            rightArr[i] = arr[mid + 1 + i];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


}
