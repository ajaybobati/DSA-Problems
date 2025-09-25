package Heap;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i + 1); }
    private int right(int i) { return (2 * i + 2); }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = key;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }
    private void heapify(int i) {
        int l = left(i), r = right(i);
        int smallest = i;

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
}

class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i + 1); }
    private int right(int i) { return (2 * i + 2); }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new key
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = key;
        int current = size;
        size++;

        // Heapify up
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Extract maximum element
    public int extractMax() {
        if (size <= 0) return Integer.MIN_VALUE;
        if (size == 1) return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    // Heapify down
    private void heapify(int i) {
        int l = left(i), r = right(i);
        int largest = i;

        if (l < size && heap[l] > heap[largest]) largest = l;
        if (r < size && heap[r] > heap[largest]) largest = r;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
}

 class HeapExample {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        System.out.println("Extract Min: " + minHeap.extractMin()); // 1

        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        System.out.println("Extract Max: " + maxHeap.extractMax()); // 6
    }
}
