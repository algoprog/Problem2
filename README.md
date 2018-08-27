# Problem2
We need to check which blocks each pizzeria can cover. We use a hashmap data structure to keep count of the coverage number of each block. We could use an nxn matrix to do this, where n is the size of the city, but by using a hashmap we save up a lot of memory when n is large. The complexity depends on the data, and in the worst case is O(n^3), when every pizzeria can cover all the other blocks, and every block has one pizzeria.
