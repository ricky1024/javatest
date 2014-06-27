import java.util.*;
public class MinK {
	public ArrayList<Integer> minK(int[] arr, int k) {
		if(k>arr.length) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(k==arr.length) {
			for(int i = 0; i < arr.length; i++) {
				result.add(arr[i]);
			}
			return result;
		}
		result.clear();
		for(int i = 0; i < arr.length; i++) {
			if(result.size()<k) {
				result.add(arr[i]);
				printList(result);
				System.out.println("   " + result.size());
			} else {
				int max = maxOne(result);
				int index = result.indexOf(max);
				if(arr[i]<max) {
					result.remove(index);
					result.add(arr[i]);
				}
				printList(result);
				System.out.println();
			}
		}
		return result;
	}
	public int maxOne(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < list.size(); i++) {
			max = max>list.get(i)?max:list.get(i);
		}
		return max;
	}
	public void printList(ArrayList<Integer> list) {
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
	}
	public static void main(String[] args) {
		MinK obj = new MinK();
		int[] array = {5,6,4,3,2,1};
		int k = 4;
		ArrayList<Integer> list = obj.minK(array, k);
		obj.printList(list);
	}
}