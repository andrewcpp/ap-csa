
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {6, 3, 1, 7, 9, 2, 8, 4, 5};
		divide(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void divide(int[] arr) {
		if (arr.length <= 1) return;
		int[] front = new int[arr.length / 2];
		int[] back = new int[arr.length - front.length];
		for (int i = 0; i < front.length; i++) front[i] = arr[i];
		for (int i = 0; i < back.length; i++) back[i] = arr[arr.length / 2 + i];
		divide(front);
		divide(back);
		conquer(front, back, arr);
	}
	
	public static void conquer(int[] front, int[] back, int[] arr) {
		int index = 0, frontIndex = 0, backIndex = 0;
		while (index < arr.length) {
			if (front.length == frontIndex && back.length == backIndex) {
				break;
			} else if (front.length == frontIndex && back.length > backIndex) {
				arr[index] = back[backIndex];
				backIndex++;
				index++;
				continue;
			} else if (back.length == backIndex && front.length > frontIndex) {
				arr[index] = front[frontIndex];
				frontIndex++;
				index++;
				continue;
			}
			if (front[frontIndex] < back[backIndex]) {
				arr[index] = front[frontIndex];
				frontIndex++;
			} else if (back[backIndex] < front[frontIndex]) {
				arr[index] = back[backIndex];
				backIndex++;
			} else {
				arr[index] = front[frontIndex];
				frontIndex++;
			}
			index++;
		}
	}

}
