import java.util.Scanner;

public class Main {

    // Bubble sort function.
    public static int[] sort(int[] arr) {

        int inputLength = arr.length;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {
            is_sorted = true;
            for (int j = 1; j < (inputLength - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    is_sorted = false;
                }
            }
            if (is_sorted)
                break;
        }
        return arr;
    }

    // Binary search function.
    public static void binarySearch(int arr[], int first, int last, int key) {

        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.printf("%d -> True", key);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.printf("%d -> False", key);
        }
    }

    public static void main(String[] args) {

        // Get size of array.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter array size: ");
        int n = input.nextInt();
        int arr[] = new int[n];

        // Get array elements.
        System.out.println("Please enter elements, e.g. 0 1 2 3 4 5: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int[] sorted_arr = new int[n];
        sorted_arr = sort(arr);

        // Print sorted array.
        for (int i = 0; i < n; i++){
            System.out.print(sorted_arr[i]);
            if (i != n - 1)
                System.out.print(" ,");
            else
                System.out.print("\n");
        }

        System.out.println("Please enter number to search: ");
        int key = input.nextInt();
        // Result print in function.
        binarySearch(sorted_arr, 0, n - 1, key);
    }
}

