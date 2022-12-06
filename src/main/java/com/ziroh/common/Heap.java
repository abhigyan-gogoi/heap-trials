package com.ziroh.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class Heap<E extends Comparable<E>> {
    private static final Logger logger = LoggerFactory.getLogger(Heap.class);
    private LinkedList<E> linkedList;

    public Heap() {
        linkedList = new LinkedList<>();
    }

    public void add(E element) {
        linkedList.add(element);
    }

    private void swap (int index1, int index2) {
        E temp = linkedList.get(index1);
        linkedList.set(index1, linkedList.get(index2));
        linkedList.set(index2, temp);
    }

    private int getLeft(int index) {
        index++;
        return (2*index) - 1;
    }

    private int getRight(int index) {
        index++;
        return ((2*index) + 1) - 1;
    }

    public void maxHeapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest;
        if (left < linkedList.size() && linkedList.get(left).compareTo(linkedList.get(index)) > 0) {
            largest = left;
        } else {
            largest = index;
        }
        if (right < linkedList.size() && linkedList.get(right).compareTo(linkedList.get(largest)) > 0) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    public void minHeapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int smallest;
        if (left < linkedList.size() && linkedList.get(left).compareTo(linkedList.get(index)) < 0) {
            smallest = left;
        } else {
            smallest = index;
        }
        if (right < linkedList.size() && linkedList.get(right).compareTo(linkedList.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    public void buildMaxHeapTree() {
        for (int index = linkedList.size()/2; index >= 0; index--) {
            maxHeapify(index);
        }
    }

    public void buildMinHeapTree() {
        for (int index = linkedList.size()/2; index >= 0; index--) {
            minHeapify(index);
        }
    }

    public void maxHeapSortAscending() {
        buildMaxHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<E> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addFirst(linkedList.removeLast());
            size--;
            maxHeapify(0);
        }
        logger.debug("MAX HEAP ASCENDING SORTED LIST: ");
        for (E element : sortedList) {
            System.out.print(element + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void maxHeapSortDescending() {
        buildMaxHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<E> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addLast(linkedList.removeLast());
            size--;
            maxHeapify(0);
        }
        logger.debug("MAX HEAP DESCENDING SORTED LIST: ");
        for (E element : sortedList) {
            System.out.print(element + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void minHeapSortAscending() {
        buildMinHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<E> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addLast(linkedList.removeLast());
            size--;
            minHeapify(0);
        }
        logger.debug("MIN HEAP ASCENDING SORTED LIST: ");
        for (E element : sortedList) {
            System.out.print(element + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void minHeapSortDescending() {
        buildMinHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<E> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addFirst(linkedList.removeLast());
            size--;
            minHeapify(0);
        }
        logger.debug("MIN HEAP DESCENDING SORTED LIST: ");
        for (E element : sortedList) {
            System.out.print(element + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void getHeap() {
        logger.debug("HEAP ARRAY: ");
        for (E element : linkedList) {
            System.out.print(element + ", ");
        }
        System.out.println();
        logger.debug("HEAP TREE: ");
        int level = 1;
        for (int i = 0; i<linkedList.size(); i++){
            if ((i+1) == Math.pow(2, level) ) {
                System.out.println();
                level++;
            }
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}