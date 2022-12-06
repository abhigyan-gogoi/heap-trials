package com.ziroh;

import com.ziroh.common.Heap;

public class ConsoleApp {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
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

        heap.buildMaxHeapTree();
        heap.getHeap();
        heap.maxHeapSortAscending();
        heap.maxHeapSortDescending();
        heap.buildMinHeapTree();
        heap.getHeap();
        heap.minHeapSortDescending();
        heap.minHeapSortAscending();
    }
}