package Chapter5;

public class Question06 {

	// I will use external sorting algorithm for it.
	// For example, the file is 20 GB and the memory available is 2 GB
	// I will divide the file in 20/2 = 10 chunks which will be 2 GB each.
	// I will individually sort each one of them. So that I will have 10 chunks which internally be sorted.
	// Now, I will divide the memory into (n+1) = 11 chunks, each of 1.8 Mb. 
	// In 10 chunks, I will pick up data from the 10 sorted chunks and store them as Min Heap.
	// In the 11'th chunk, I'll pick data from each of the min heaps and sort them and write to file.
	// Whenever any chunk becomes empty, I'll refill it with the corresponding chunk on the local file.
	
}


