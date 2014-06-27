public class BinarySearch {
	public int recursiveBinarySearch(int[] arr, int target) {
		return binarySearch(arr, target, 0, arr.length-1);
	}
	public int binarySearch(int[] arr, int target, int start, int end) {
		if(arr[start]>arr[end]) {
			System.out.println("not sorted");
			return 0;
		}
		if(start>end) {
			System.out.println("range wrong");
			return 0;
		} else if(start==end && arr[start]!=target) {
			System.out.println("no result");
			return 0;
		}
		int center = (start+end)/2;
		if(arr[center]==target) {
			return center;
		} else if(arr[center]<target) {
			return binarySearch(arr, target, center+1, end);
		} else {
			return binarySearch(arr, target, start, center-1);
		}
	}

	public int iterativeBinarySearch(int[] arr, int target) {
		return binarySearchIteration(arr, target, 0, arr.length-1);
	}
	public int binarySearchIteration(int[] arr, int target, int start, int end) {
		if(arr[start]>arr[end]) {
			System.out.println("not sorted");
			return 0;
		}
		if(start>end) {
			System.out.println("range wrong");
			return 0;
		} else if(start==end && arr[start]!=target) {
			System.out.println("no result");
			return 0;
		}
		while(true) {
			int center = (start+end)/2;
			if(arr[center] == target) {
				return center;
			} else if (arr[center]<target) {
				start = center+1;
			} else {
				end = center-1;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,5,6,7,8};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.recursiveBinarySearch(arr,2));
		System.out.println(bs.iterativeBinarySearch(arr,6));
	}
}