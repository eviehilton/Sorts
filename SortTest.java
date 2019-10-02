package sorts;
import java.util.Arrays;
import java.util.Random;

public class SortTest {
	
	 public static <DataType> void randomShuffle(DataType[] numbers, int shuffleCount){
	        Random gen = new Random();
	        for (int i=0; i<shuffleCount; i++){
	           int pos1 = gen.nextInt(numbers.length);
	           int pos2 = gen.nextInt(numbers.length);
	           Sorts.swap(numbers, pos1, pos2);
	        }
	    }//randomShuffle
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        Integer[] values = {1,40, -50, -200, 150, 232, 42, 80};
	        
	        randomShuffle(values, 100);
	        System.out.println("\nTest Bubble Sort: ");        
	        System.out.printf("Before sort: %s\n", Arrays.toString(values));
	        Sorts.bubbleSort(values);
	        System.out.printf("After sort: %s\n", Arrays.toString(values));
	        
	        randomShuffle(values, 100);
	        System.out.println("\nTest Selection Sort: ");        
	        System.out.printf("Before sort: %s\n", Arrays.toString(values));
	        Sorts.selectionSort(values);
	        System.out.printf("After sort: %s\n", Arrays.toString(values));
	        
	        randomShuffle(values, 100);
	        System.out.println("\nTest Insertion Sort: ");        
	        System.out.printf("Before sort: %s\n", Arrays.toString(values));
	        Sorts.insertionSort(values);
	        System.out.printf("After sort: %s\n", Arrays.toString(values));
	        
	        
	        randomShuffle(values, 100);
	        System.out.println("\nTest QuickSort: ");        
	        System.out.printf("Before sort: %s\n", Arrays.toString(values));
	        Sorts.quickSort(values);
	        System.out.printf("After sort: %s\n", Arrays.toString(values));
	        
	        randomShuffle(values, 100);
	        System.out.println("\nTest MergeSort: ");        
	        System.out.printf("Before sort: %s\n", Arrays.toString(values));
	        Sorts.quickSort(values);
	        System.out.printf("After sort: %s\n", Arrays.toString(values));
	        
	    }//main
	    

}
