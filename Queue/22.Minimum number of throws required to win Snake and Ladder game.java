package Queue;

// idea is to consider the snakes and ladders board as a directed graph and run Breadth–first search (BFS) from the starting node, vertex 0, as per game rules. We construct a directed graph, keeping in mind the following conditions:

// For any vertex in graph v, we have an edge from v to v+1, v+2, v+3, v+4, v+5, v+6 as we can reach any of these nodes in one throw of dice from node v.
// If any of these neighbors of v has a ladder or snake, which takes us to position x, then x becomes the neighbor instead of the base of the ladder or head of the snake.
// Now the problem is reduced to finding the shortest path between two nodes in a directed graph problem. We represent the snakes and ladders board using a map.

// The algorithm can be implemented as follows in C++, Java, and Python:
