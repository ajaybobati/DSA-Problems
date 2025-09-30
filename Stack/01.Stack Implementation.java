package Stack;

// Stack Implementation in C
// A stack is a linear data structure that serves as a collection of elements, with three main operations.

// Push operation, which adds an element to the stack.
// Pop operation, which removes the most recently added element that was not yet removed, and
// Peek operation, which returns the top element without modifying the stack.
//  The push and pop operations occur only at one end of the structure, referred to as the top of the stack. The order in which elements come off a stack gives rise to its alternative name, LIFO (for Last–In, First–Out).

// Following is a simple representation of a stack with push and pop operations:

//  LIFO Order Stack

//  A stack may be implemented to have a bounded capacity. If the stack is full and does not contain enough space for push operation, then the stack is considered in an overflow state.

// Stack Implementation using an array:

// A (bounded) stack can be easily implemented using an array. The first element of the stack (i.e., bottom-most element) is stored at the 0'th index in the array (assuming zero-based indexing). The second element will be stored at index 1 and so on… We also maintain a variable top to keep track of the stack’s size by recording the total number of items pushed so far. It points to a location in the array where the next element is to be inserted. Thus, the stack itself can be effectively implemented as a 3–element structure:

// structure stack:    maxsize : integer    top : integer    items : array of item
