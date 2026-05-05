package heaps;

public class Heap{
    public static void MinHeapify(int[] A, int i){
        MinHeapify(A, i, A.length);
    }
    private static void MinHeapify(int[] A, int i, int size){
        int Left = (2*i) + 1;
        int Right = (2*i) + 2;
        int smallest = i;

        if(Left < size&& A[Left] < A[smallest]){
            smallest = Left;
        }
        if(Right < size && A[Right] < A[smallest]){
            smallest = Right;
        }
        if(smallest != i){
            swap(A, i,smallest);
            MinHeapify(A, smallest, size);
        }

    }

    public static int[] BuildMinHeap(int A[]){
        for(int i = (A.length - 1)/2; i>=0; i-- ){
            MinHeapify(A, i, A.length);
        }
        return A;
    }

    public static void heapSort(int A[]){
        BuildMinHeap(A);
        int size = A.length;
        for (int i = A.length - 1; i>= 1 ; i--){
            swap(A, 0, i);
            size--;
            MinHeapify(A, 0, size);
        }
    }

    public static void swap(int A[], int indexOne, int indexTwo){
        int temp = A[indexOne];
        A[indexOne] = A[indexTwo];
        A[indexTwo] = temp;

    }
    public static void main(String[] args){
        int[] arr = {5,3,9,1,7,2};
        System.out.println("Original");

        for(int x : arr) System.out.print(x + " ");
        System.out.println();

        heapSort(arr);

        System.out.println("After Sorting");
        for(int x: arr) System.out.print(x + " ");
    }

}