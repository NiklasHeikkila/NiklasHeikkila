// These are some sorting algorithms I did in Data structures and Algorithms (811312A)
// course in autumn of 2024.

import java.util.Comparator;

public class SortingAlgorithmsExamples {
    
    
    public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
        int useIndex;
        int firstIndex = fromIndex;
      
        while (fromIndex < toIndex - 1) {
            useIndex = fromIndex;
            while (comparator.compare(array[useIndex], array[useIndex + 1]) > 0) {
                swap(array, useIndex, useIndex + 1);
                if (useIndex > firstIndex){
                useIndex--;
                }
            }
            fromIndex ++;
        }
    }

    public static <T> void swap(T[] array, int first, int second) {
        T temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }

    public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
        toIndex--;
        while (fromIndex < toIndex) {
           swap(array, fromIndex, toIndex);
           fromIndex++;
           toIndex--;
        }
    }

    public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
        int middleIndex;
        if (fromIndex == toIndex) {
            if (comparator.compare(aValue, fromArray[fromIndex]) == 0) {
                return fromIndex;
            } else {
                return -1;
            }
        } else {
            middleIndex = fromIndex + (toIndex - fromIndex) / 2;
            if (comparator.compare(aValue, fromArray[middleIndex]) <= 0) {
                return binarySearchRecursive(aValue, fromArray, fromIndex, middleIndex, comparator);
            } else {
                return binarySearchRecursive(aValue, fromArray, middleIndex + 1, toIndex, comparator);
            }
        }
    }

    // QuickSort metodiin otettu mallia luentomateriaalista. (05-2 TIRA Sorting algorithms Quicksort, Dia 3)

    private static <E> void quickSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
        int partitionIndex;
        if (fromIndex >= 0 && fromIndex < toIndex) {
            partitionIndex = partition(array, fromIndex, toIndex, comparator);
            quickSort(array, fromIndex, partitionIndex - 1, comparator);
            quickSort(array, partitionIndex + 1, toIndex, comparator);
        }
    }

    // Partition metodiin otettu mallia luentomateriaalista. (05-2 TIRA Sorting algorithms Quicksort, Dia 4)

    private static <E> int partition(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
        E pivot;
        int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
        // Valitaan pivotiksi ensimmäisen, keskimmäisen ja viimeisen arvon mediaani. 
        // Lähde: https://en.wikipedia.org/wiki/Quicksort, -> Implementation issues -> Choice of pivot
        if (comparator.compare(array[middleIndex], array[fromIndex]) < 0) {
            swap(array, middleIndex, fromIndex);
        }
        if (comparator.compare(array[toIndex], array[fromIndex]) < 0) {
            swap(array, toIndex, fromIndex);
        }
        if (comparator.compare(array[middleIndex], array[toIndex]) < 0) {
            swap(array, middleIndex, toIndex);
        }
        pivot = array[toIndex];
        int i = fromIndex - 1;
        // Siirretään kaikki pivottia pienemmät arvot pivottia suurempien arvojen edelle.
        for (int j = fromIndex; j < toIndex; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        // Vaihdetaan pivotin ja taulukon ensimmäisen pivottia suuremman arvon paikkaa.
        swap(array, i + 1, toIndex);
        return i + 1;
    }
}
