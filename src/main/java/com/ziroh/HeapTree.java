package com.ziroh;

import java.util.LinkedList;

public class HeapTree {
    LinkedList<Integer> array;

    public HeapTree(LinkedList<Integer> array) {
        this.array = array;
    }

    private int getRoot() {
        return 1;
    }

    private int getParent(int index) {
        return index/2;
    }

    private int getLeft(int index) {
        return 2*index;
    }

    private int getRight(int index) {
        return (2*index) + 1;
    }

    private LinkedList<Integer> swap(int index, int largest) {
        int temp = array.get(index - 1);
        array.set(index - 1, array.get(largest - 1));
        array.set(largest - 1, temp);
        return array;
    }

    public void maxHeapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest;
        if (left <= array.size() && array.get(left - 1) > array.get(index - 1)) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= array.size() && array.get(right - 1) > array.get(largest - 1)) {
            largest = right;
        }
        if (largest != index) {
            array = swap(index, largest);
            maxHeapify(largest);
        }
    }

    public void minHeapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int smallest;
        if (left <= array.size() && array.get(left - 1) < array.get(index - 1)) {
            smallest = left;
        } else {
            smallest = index;
        }
        if (right <= array.size() && array.get(right - 1) < array.get(smallest - 1)) {
            smallest = right;
        }
        if (smallest != index) {
            array = swap(index, smallest);
            minHeapify(smallest);
        }
    }

    public void buildMaxHeapTree() {
        for (int index = array.size()/2; index >= 1; index--) {
            maxHeapify(index);
        }
    }

    public void buildMinHeapTree() {
        for (int index = array.size()/2; index >= 1; index--) {
            minHeapify(index);
        }
    }

    public void sortDescending() {
        int size = array.size();
        LinkedList<Integer> arrayCopy = (LinkedList<Integer>) array.clone();
        LinkedList<Integer> sortedArray = new LinkedList<>();
        while (size != 0) {
            array = swap(getRoot(), size);
            sortedArray.add(array.remove(size - 1));
            size--;
            maxHeapify(getRoot());
        }
        array = (LinkedList<Integer>) arrayCopy.clone();
        System.out.println("SORT: " + sortedArray);
    }

    public void sortAscending() {
        int size = array.size();
        LinkedList<Integer> arrayCopy = (LinkedList<Integer>) array.clone();
        LinkedList<Integer> sortedArray = new LinkedList<>();
        while (size != 0) {
            array = swap(getRoot(), size);
            sortedArray.add(array.remove(size - 1));
            size--;
            minHeapify(getRoot());
        }
        array = (LinkedList<Integer>) arrayCopy.clone();
        System.out.println("SORT: " + sortedArray);
    }

    public int extractMax(){
        int max = array.get(0);
        array.remove(0);
        return max;
    }

    public int getMax() {
        return array.get(getRoot() - 1);
    }

    public void getHeapTree() {
        System.out.println("HEAP TREE ARRAY: " + array);
        int level = 1;
        for (int i = 0; i<array.size(); i++){
            if ((i+1) == Math.pow(2, level) ) {
                System.out.println();
                level++;
            }
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
}
