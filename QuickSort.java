public class QuickSort{
	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 7,9, 0};
		int len = arr.length;
		sortMethod(arr, 0, len-1);
		for(int i = 0; i < len; i++){
			System.out.print(arr[i] + " ");		
		}
		
	}

	static void sortMethod(int[] arr, int start, int end){
		if(start < end){
			int index = partition(arr, start, end);
			sortMethod(arr, start, index-1);
			sortMethod(arr, index+1, end);
		}
	}

	static int partition(int[] arr, int start, int end ){
		int index = start;
		int pivot = arr[end];

		for(int i = start; i < end; i++){
			if(arr[i] <= pivot){
				swap(arr, index, i);
				index++;
			}
		}
		swap(arr, index, end);
		return index;
	}
	static void swap(int[] arr, int l, int r){
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
}

