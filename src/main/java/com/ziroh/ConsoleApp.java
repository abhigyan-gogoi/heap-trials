package com.ziroh;

import com.ziroh.common.Heap;

public class ConsoleApp {
    public static void main(String[] args) {
        // Initialise heap
        Heap<Integer> heap = new Heap<>();
        // Populate heap
        heap.add(4);
        heap.add(1);
        heap.add(3);
        heap.add(2);
        heap.add(16);
        heap.add(9);
        heap.add(10);
        heap.add(14);
        heap.add(8);
        heap.add(7);
        // Build max heap tree
        heap.buildMaxHeapTree();
        heap.showHeap();
        // Sort the heap array
        heap.maxHeapSortAscending();
        heap.maxHeapSortDescending();
        // Build min heap tree
        heap.buildMinHeapTree();
        heap.showHeap();
        // Sort the heap array
        heap.minHeapSortDescending();
        heap.minHeapSortAscending();
    }
}