package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(40);
        list.add(5);
        list.add(20);
        list.add(35);
        list.add(50);

        System.out.println(list);
        heapSort(list);
        System.out.println(list);
    }



    static void heapSort(List<Integer>array){
        int n = array.size();

        for (int i = (n/2)-1; i >=0; i--){
            heapify(array,i,n);
        }
        for (int i = n-1; i >=0; i--){
            int temp = array.get(0);
            array.set(0,array.get(i));
            array.set(i,temp);
            heapify(array,0,i);

        }
    }

    private static void heapify(List<Integer> array, int i, int n) {
        int left = 2*i+1;
        int right = 2*i+2;
        int minIndex = i;

        if (left < n && array.get(left) > array.get(minIndex)){
            minIndex = left;
        }
        if (right < n && array.get(right) > array.get(minIndex)){
            minIndex = right;
        }
        if (i != minIndex){
            int temp = array.get(i);
            array.set(i,array.get(minIndex));
            array.set(minIndex,temp);
            heapify(array,minIndex,n);
        }
    }
}
