package sorts;

/**
 *
 * @author Dr. Mec
 *
 * Notes: Bubble sort, insertion sort, selection sort developed in class
 * Quicksort and Mergesort direct modification from Java Foundations Text
 * Chapter 18.
 */
public class Sorts {

    /**
     * Swap two values in an array at positions pos1 and pos2
     *
     * @param <DataType>
     * @param list -- integer array of elements
     * @param pos1 -- index of a number involved in swap
     * @param pos2 -- index of a second number involved in swap
     */
    public static <DataType> void swap(DataType[] list, int pos1, int pos2) {
        DataType hold = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = hold;
    }//swapInts

    /**
     * an implementation of bubble sort for arrays
     *
     * @param <DataType>
     * @param elements -- array of DataType
     */
    public static <DataType extends Comparable<DataType>> void bubbleSort(DataType[] elements) {
        for (int pass = 0; pass < elements.length; pass++) {
            int swapCount = 0;
            for (int pos = 1; pos < elements.length - pass; pos++) {
                if (elements[pos - 1].compareTo(elements[pos]) > 0) {
                    swap(elements, pos - 1, pos);
                    swapCount++;
                }
            }//for each pos in array
            if (swapCount == 0) {
                break;
            }
        }//pass through array until no sorts       
    } //bubbleSort

    /**
     * an implementation of selection sort for arrays
     *
     * @param <DataType>
     * @param elements -- array of DataType
     */
    public static <DataType extends Comparable<DataType>> void selectionSort(DataType[] elements) {
        for (int pos = 0; pos < elements.length; pos++) {
            int minIndex = pos; //index of smallest number
            for (int i = pos + 1; i < elements.length; i++) {
                if (elements[i].compareTo(elements[minIndex]) < 0) {
                    minIndex = i;
                }
            }//find lowest number
            if (pos != minIndex) {
                swap(elements, pos, minIndex);
            }
        }//pass through array until no sorts       
    } //bubbleSort

    /**
     * an implementation of insertion sort for arrays
     *
     * @param <DataType>
     * @param elements -- array of datatype
     */
    public static <DataType extends Comparable<DataType>> void insertionSort(DataType[] elements) {
        for (int pos = 1; pos < elements.length; pos++) {
            //find position of for current value
            int newPos = 0;
            while (newPos < pos) {
                if (elements[pos].compareTo(elements[newPos]) < 0) {
                    break;
                }
                newPos++;
            }//find new position
            if (newPos != pos) {
                //shift values in array
                DataType hold = elements[pos];
                for (int i = pos; i > newPos; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[newPos] = hold;
            }//if not the same position          
        }//pass through array until no sorts       
    } //bubbleSort

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     *
     * @param <DataType>
     * @param data the array to be sorted
     */
    public static <DataType extends Comparable<DataType>> void quickSort(DataType[] data) {
        quickSort(data, 0, data.length - 1);
    }//quickSort

    /**
     * Recursively sorts a range of objects in the specified array using the
     * quick sort algorithm.
     *
     * @param elements the array to be sorted
     * @param min the minimum index in the range to be sorted
     * @param max the maximum index in the range to be sorted
     */
    private static <DataType extends Comparable<DataType>> void quickSort(DataType[] elements, int min, int max) {
        if (min < max) {
            // create partitions
            int indexofpartition = partition(elements, min, max);

            // sort the left partition (lower values)
            quickSort(elements, min, indexofpartition - 1);

            // sort the right partition (higher values)
            quickSort(elements, indexofpartition + 1, max);
        }
    }//quicksort recursive

    private static <DataType extends Comparable<DataType>> int partition(DataType[] elements, int min, int max) {
        DataType partitionelement;
        int left, right;
        int middle = (min + max) / 2;

        // use the middle data value as the partition element
        partitionelement = elements[middle];
        // move it out of the way for now
        swap(elements, middle, min);

        left = min;
        right = max;
        while (left < right) {
            // search for an element that is > the partition element
            while (left < right && elements[left].compareTo(partitionelement) <= 0) {
                left++;
            }

            // search for an element that is < the partition element
            while (elements[right].compareTo(partitionelement) > 0) {
                right--;
            }

            // swap the elements
            if (left < right) {
                swap(elements, left, right);
            }
        }

        // move the partition element into place
        swap(elements, min, right);

        return right;
    }//partition 

    /**
     * Sorts the specified array of objects using the merge sort algorithm.
     *
     * @param elements the array to be sorted
     */
    public static <DataType extends Comparable<DataType>>
            void mergeSort(DataType[] elements) {
        mergeSort(elements, 0, elements.length - 1);
    }//mergeSort

    /**
     * Recursively sorts a range of objects in the specified array using the
     * merge sort algorithm.
     *
     * @param elements the array to be sorted
     * @param min the index of the first element
     * @param max the index of the last element
     */
    private static <DataType extends Comparable<DataType>>
            void mergeSort(DataType[] elements, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(elements, min, mid);
            mergeSort(elements, mid + 1, max);
            merge(elements, min, mid, max);
        }
    }//mergeSort recursive 

    /**
     * Merges two sorted subarrays of the specified array.
     *
     * @param elements the array to be sorted
     * @param first the beginning index of the first subarray
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
    private static <DataType extends Comparable<DataType>>
            void merge(DataType[] elements, int first, int mid, int last) {
        DataType[] temp = (DataType[]) (new Comparable[elements.length]);

        int first1 = first, last1 = mid;  // endpoints of first subarray
        int first2 = mid + 1, last2 = last;  // endpoints of second subarray
        int index = first1;  // next index open in temp array

        //  Copy smaller item from each subarray into temp until one
        //  of the subarrays is exhausted
        while (first1 <= last1 && first2 <= last2) {
            if (elements[first1].compareTo(elements[first2]) < 0) {
                temp[index] = elements[first1];
                first1++;
            } else {
                temp[index] = elements[first2];
                first2++;
            }
            index++;
        }

        //  Copy remaining elements from first subarray, if any
        while (first1 <= last1) {
            temp[index] = elements[first1];
            first1++;
            index++;
        }

        //  Copy remaining elements from second subarray, if any
        while (first2 <= last2) {
            temp[index] = elements[first2];
            first2++;
            index++;
        }

        //  Copy merged data into original array
        for (index = first; index <= last; index++) {
            elements[index] = temp[index];
        }
    }

}//Sorts

