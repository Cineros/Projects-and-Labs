public class GenericSort{

	public static void main(String[] args){
		Integer[] intArray = {9,3,6,10,14,5,18};
		Double[] doubleArray = {9.1,3.1,61.1,10.1,14.1,5.1,18.1};
		String [] stringArray= {"Mary","Mark","John","Matthew","Luke","Snoop","Eminem"};

		System.out.println("Integer data items in original order");
		displayArray(intArray);

		System.out.println("Integer data items in ascending order");
		selectionSort(intArray);
		displayArray(intArray);

		System.out.println("Double data items in original order");
		displayArray(doubleArray);

		System.out.println("Double data items in ascending order");
		selectionSort(doubleArray);
		displayArray(doubleArray);

		System.out.println("String data items in ascending order");
		selectionSort(stringArray);
		displayArray(stringArray);
		
	}

	public static <T extends Comparable<T>>void selectionSort(T[] array){
		int smallest;
		for(int i = 0; i < array.length-1;i++){
			smallest = i;
			for (int element = i +1;element < array.length;element++){
				if (array[element].compareTo(array[smallest]) < 0){
					smallest = element;
				}
			}
			swap(array, smallest, i);
		}
	}

	public static <T> void swap(T[] array, int first, int second){
		T temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	public static <T> void displayArray(T[] array){
		for (T element:array){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
}