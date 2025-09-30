package LinkedList;

// Delete a linked list in C/C++
// Write a function that takes a linked list, deallocates all of its memory, and sets its head pointer to NULL (the empty list).

// The idea is to iterate through the list and delete each node encountered. There is a slight complication inside the loop since we need to extract the .next pointer before deleting the node since it will be technically unavailable after the delete.

// The algorithm can be implemented as follows in C and C++: