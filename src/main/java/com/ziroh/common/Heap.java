package com.ziroh.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Heap {
    private static final Logger logger = LoggerFactory.getLogger(Heap.class);
    private LinkedList<Node> linkedList;

    public Heap() {
        linkedList = new LinkedList<>();
    }

//    public void add(T data) {
//        Node<T> temp = new Node<>(data);
//        linkedList.add(temp);
//    }

    public void add(Node node) {
        linkedList.add(node);
    }

    public Node removeLast() {
        Node temp = null;
        try {
            temp = linkedList.removeLast();
        } catch (NoSuchElementException e) {
            logger.debug(e.getMessage());
        }
        return temp;
    }

    public Node removeFirst() {
        Node temp = null;
        try {
            temp = linkedList.removeFirst();
        } catch (NoSuchElementException e) {
            logger.debug(e.getMessage());
        }
        return temp;
    }

    public Node getParent() {
        return linkedList.getFirst();
    }

    public Node getLast() {
        return linkedList.getLast();
    }

    public Node get(int index) {
        return linkedList.get(index);
    }

    private void swap (int index1, int index2) {
        Node temp = linkedList.get(index1);
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
        if (left < linkedList.size() && linkedList.get(left).getData().compareTo(linkedList.get(index).getData()) > 0) {
            largest = left;
        } else {
            largest = index;
        }
        if (right < linkedList.size() && linkedList.get(right).getData().compareTo(linkedList.get(largest).getData()) > 0) {
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
        if (left < linkedList.size() && linkedList.get(left).getData().compareTo(linkedList.get(index).getData()) < 0) {
            smallest = left;
        } else {
            smallest = index;
        }
        if (right < linkedList.size() && linkedList.get(right).getData().compareTo(linkedList.get(smallest).getData()) < 0) {
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
        LinkedList<Node> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addFirst(linkedList.removeLast());
            size--;
            maxHeapify(0);
        }
        logger.debug("MAX HEAP ASCENDING SORTED LIST: ");
        for (Node node : sortedList) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void maxHeapSortDescending() {
        buildMaxHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<Node> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addLast(linkedList.removeLast());
            size--;
            maxHeapify(0);
        }
        logger.debug("MAX HEAP DESCENDING SORTED LIST: ");
        for (Node node : sortedList) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void minHeapSortAscending() {
        buildMinHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<Node> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addLast(linkedList.removeLast());
            size--;
            minHeapify(0);
        }
        logger.debug("MIN HEAP ASCENDING SORTED LIST: ");
        for (Node node : sortedList) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void minHeapSortDescending() {
        buildMinHeapTree();
        int size = linkedList.size() - 1;
        LinkedList<Node> sortedList = new LinkedList<>();
        while (size >= 0) {
            swap(0, size);
            sortedList.addFirst(linkedList.removeLast());
            size--;
            minHeapify(0);
        }
        logger.debug("MIN HEAP DESCENDING SORTED LIST: ");
        for (Node node : sortedList) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
        linkedList = sortedList;
    }

    public void getHeap() {
        logger.debug("HEAP ARRAY: ");
        for (Node<?> node : linkedList) {
            System.out.print(node.getData() + ", ");
        }
        System.out.println();
        logger.debug("HEAP TREE: ");
        int level = 1;
        for (int i = 0; i<linkedList.size(); i++){
            if ((i+1) == Math.pow(2, level) ) {
                System.out.println();
                level++;
            }
            System.out.print(linkedList.get(i).getData() + " ");
        }
        System.out.println();
    }
}