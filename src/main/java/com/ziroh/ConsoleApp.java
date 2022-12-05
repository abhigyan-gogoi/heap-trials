package com.ziroh;

import java.util.Arrays;
import java.util.LinkedList;

public class ConsoleApp {
    public static void main(String[] args) {
        LinkedList<Integer> array = new LinkedList<>(Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7));
        HeapTree heapTree = new HeapTree(array);
        heapTree.buildMaxHeapTree();
        heapTree.getHeapTree();
        heapTree.sortDescending();
        heapTree.buildMinHeapTree();
        heapTree.getHeapTree();
        heapTree.sortAscending();
    }
}