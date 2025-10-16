package utilities;

import java.util.Comparator;
import shapes.Shape;

public class Sorting {

    /**
     * Sorts an array of shapes using Selection Sort.
     * @param shapes The array of shapes to sort.
     * @param comparator The comparator to determine the order. If null, natural ordering is used.
     */
    public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compareShapes(shapes[j], shapes[maxIndex], comparator) > 0) {
                    maxIndex = j;
                }
            }
            Shape temp = shapes[maxIndex];
            shapes[maxIndex] = shapes[i];
            shapes[i] = temp;
        }
    }

    /**
     * Sorts an array of shapes using Merge Sort.
     * @param shapes The array of shapes to sort.
     * @param comparator The comparator to determine the order. If null, natural ordering is used.
     */
    public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
        int mid = shapes.length / 2;
        Shape[] leftHalf = new Shape[mid];
        Shape[] rightHalf = new Shape[shapes.length - mid];

        System.arraycopy(shapes, 0, leftHalf, 0, mid);
        System.arraycopy(shapes, mid, rightHalf, 0, shapes.length - mid);

        mergeSort(leftHalf, comparator);
        mergeSort(rightHalf, comparator);

        merge(shapes, leftHalf, rightHalf, comparator);
    }

    private static void merge(Shape[] mainArray, Shape[] leftHalf, Shape[] rightHalf, Comparator<Shape> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            // For descending order, place the larger element into the main array
            if (compareShapes(leftHalf[i], rightHalf[j], comparator) >= 0) {
                mainArray[k++] = leftHalf[i++];
            } else {
                mainArray[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length) {
            mainArray[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            mainArray[k++] = rightHalf[j++];
        }
    }

    /**
     * Helper method to compare two shapes using either the provided comparator or their natural order.
     * @param a The first shape.
     * @param b The second shape.
     * @param comparator The comparator to use.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    private static int compareShapes(Shape a, Shape b, Comparator<Shape> comparator) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            return a.compareTo(b);
        }
    }
}