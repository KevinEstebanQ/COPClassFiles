import java.util.Arrays;

public class Sorting{


    public static int[] SelectionSort(int[] A, sortingInformation info){
        for (int i = 0; i < A.length ; i++){
            info.loops++;
            int minIndex = i;

            for (int j = i + 1; j < A.length; j++){

                info.loops++;
                if(A[minIndex] > A[j]) { minIndex = j;
                    info.comparisons++;
                }
            }
            swap(A, i, minIndex, info);
        }
        return A;
    }
public static int[] insertionSort(int[] Array, sortingInformation info){
        //A[1] is the first unsorted element onf a list with length > 1
        //A single element list is always sorted
    for (int i = 1; i < Array.length; i++) {
        info.loops++;
        //index to swap with previous element on the array if A[i] < A[i-1]
        //index initialized at the next unsorted element on each loop
        int j = i;


        //j shouldn't go below 0 as it is an array index
        //check for difference, make the swap to previous element if current is greater
        //move index down once to check with the new previous index
        while(j > 0 && Array[j] < Array[j - 1]) {
            info.comparisons++;
            info.loops++;
            swap(Array, j, j - 1, info);
            j--;
        }
    }
    return Array;
}
    private static void swap(int[] A, int index1, int index2, sortingInformation info){
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
        info.swaps++;
    }


    public static void main(String[] args){
        int[] A = {9,8,7,6,4,3,0};
        int[] A2 = {9,8,7,6,100,20,30};
        sortingInformation A_info = new sortingInformation();
        sortingInformation A2_info = new sortingInformation();
        System.out.println("Array_1: "+Arrays.toString(A));
        int[] A_SelectionSorted = SelectionSort(A, A_info);
        System.out.println("Array_1 SelectionSorted: "+Arrays.toString(A_SelectionSorted));
        System.out.println(A_info);
        System.out.println();
        System.out.println("Array_2: "+Arrays.toString(A2));
        int[] A_insertionSorted = insertionSort(A2, A2_info);
        System.out.println("Array_2 insertionSorted: "+Arrays.toString(A_insertionSorted));
        System.out.println(A2_info);

    }
}