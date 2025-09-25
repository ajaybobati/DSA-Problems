package Heap;

// Introduction to Priority Queues using Binary Heaps
// This article will introduce a significant data structure, priority queue, and discuss how we can implement them using (Binary) Heaps.

// Priority Queue
// A priority queue is an ADT (Abstract Data Type) for maintaining a set S of elements, with each element having a “priority” associated with it. In a priority queue, an element with high priority is served before an element with low priority and vice versa. If two elements have the same priority, they are served according to their order in the queue. It basically supports the following operations:

// push(x): inserts an element x in set S – usually an O(log(n)) operation.
// top() or peek(): returns the element of S with highest (or lowest) priority (but does not modify the queue) – O(1) operation.
// pop(): returns and removes the element of S with highest (or lowest) priority – usually an O(log(n)) operation.
// Heap Data Structure
// Heap data structure can be used to implement a priority queue. A heap data structure should not be confused with the heap, a pool of memory used for dynamic memory allocation. A common implementation of a heap is the binary heap, which is defined as a binary tree with two additional properties:

// Structural property: A binary heap is a complete binary tree, i.e., all levels of the tree, except possibly the last one (deepest) are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.
// Heap Property: The key stored in each node is either “greater than or equal to” or “less than or equal to” the keys in the node’s children.
