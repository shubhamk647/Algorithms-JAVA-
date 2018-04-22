public class MergeSort{
	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 7,9, 0};
		int len = arr.length;
		sortMethod(arr, 0, len-1);
		for(int i = 0; i < len; i++){
			System.out.print(arr[i] + " ");		
		}	
	}

	static void sortMethod(int[] arr, int start, int end){
		if(start >= end){
			return;
		}
		int mid = (start + end)/2;
		sortMethod(arr, start, mid);
		sortMethod(arr, mid+1, end);

		merge(arr, start, mid, end);
	}

	static void merge(int[] arr, int start, int mid, int end){

		int n1 = mid - start + 1;
		int n2 = end - mid;

		int[] firstHalf = new int[n1];
		int[] secondHalf = new int[n2];

		for(int  i = 0; i < n1; i++){
			firstHalf[i] = arr[start + i];
		}
		for(int j = 0; j < n2; j++){
			secondHalf[j] = arr[mid + 1 + j];

		}

		int i = 0, j = 0;
		int k = start;

		while(i < n1 && j < n2){
			if(firstHalf[i] <= secondHalf[j]){
				arr[k++] = firstHalf[i++];
			}
			else{
				arr[k++] = secondHalf[j++];
			}
		}

		while(i < n1){
			arr[k++] = firstHalf[i++];
		}
		while(j < n2){
			arr[k++] = secondHalf[j++];
		}
	}
}