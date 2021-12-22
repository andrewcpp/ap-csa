import java.util.Arrays;

// Bubble Sort, Selection Sort, Insertion Sort

public class SortingAlgorithms {

	public static void main(String[] args) {

		int[] nums = {3, 9, 7, 1, 8, 2, 10, 4, 6, 5};

		// bubbleSort(nums);
		// selectionSort(nums);
		// insertionSort(nums);
		
		for (int i : nums) System.out.print(i + " ");
	}

    public static void bubbleSort(int[] arr) {
    	int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-1; j++) {
				if (arr[j] > arr[j+1]) swap(arr, j, j+1);
			}
		}
    }

    public static void selectionSort(int[] arr) {
    	int minIndex = 0;
    	for (int i = 0; i < arr.length; i++) {
    		minIndex = i;
	    	for (int j = i + 1; j < arr.length; j++) {
	    		if (arr[j] < arr[minIndex]) minIndex = j;
	    	}
	    	swap(arr, minIndex, i);
    	}
    }

    public static void insertionSort(int[] arr) {
    	for (int i = 1; i < arr.length; i++) {
    		int value = arr[i];
    		int index = i;
    		for (int j = i-1; j >= 0; j--) {
    			if (value < arr[j]) swap(arr, index, j);
    			else break;
    			index--;
    		}
    	}
    }
    
    public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
}