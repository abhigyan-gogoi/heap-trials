package com.ziroh;

import com.ziroh.common.Heap;
import com.ziroh.common.Node;

public class ConsoleApp {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(new Node<>(4));
        heap.add(new Node<>(1));
        heap.add(new Node<>(3));
        heap.add(new Node<>(2));
        heap.add(new Node<>(16));
        heap.add(new Node<>(9));
        heap.add(new Node<>(10));
        heap.add(new Node<>(14));
        heap.add(new Node<>(8));
        heap.add(new Node<>(7));

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