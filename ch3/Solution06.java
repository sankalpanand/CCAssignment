package Chapter3;
import java.util.LinkedList;
import java.util.Queue;

public class Solution06 
{
	public static void main(String [] args) throws InterruptedException 
	{	
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("cat1"));
		animals.enqueue(new Cat("cat2"));
		animals.enqueue(new Dog("dog1"));
		animals.enqueue(new Dog("dog2"));
		animals.enqueue(new Cat("cat3"));
		animals.enqueue(new Dog("dog3"));
		animals.enqueue(new Dog("dog4"));
		animals.enqueue(new Cat("cat4"));

		System.out.println("Dequeued -> " + animals.dequeueAny().name);
		System.out.println("Dequeued -> " + animals.dequeueAny().name);	
		System.out.println("Dequeued -> " + animals.dequeueAny().name);	

		animals.enqueue(new Dog("dog5"));
		animals.enqueue(new Cat("cat5"));


	}
}

// Parent class animal.
// It will have protected variables which can be accessed by its children.
class Animal 
{
	// We will use integer variable to denote the sequence in which animals are brought into the house
	protected int order; 

	// We will store the name of the Cat/Dog in its parent class which is this Animal
	protected String name; 
}

class Cat extends Animal 
{
	// Save the Cat's name to parent class name variable
	public Cat(String n) 
	{
		super.name = n;
	}	
}

class Dog extends Animal 
{
	// Save the Dog's name to parent class name variable
	public Dog(String n) 
	{
		super.name = n;
	}
}

class AnimalQueue 
{
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();

	// This variable will track the order of insertion of an animal
	private int order = 0;

	// Enqueue is common for any kind of animal
	public void enqueue(Animal a) 
	{
		// Set the order for the animal from the current order in the queue 
		a.order = order;

		// Since the animal will be inserted, increment the order.
		order++;

		// Check what kind of animal is enqueued
		// If it is a dog, add it to the dog queue
		if (a instanceof Dog) 
		{
			dogs.add((Dog) a);
		} 

		// If it is a cat, add it to the dog queue
		else if (a instanceof Cat) 
		{
			cats.add((Cat)a);
		}

		System.out.println("Enqueued -> " + a.name);
	}

	/*Dequeue Methods */

	// Remove Dogs
	public Dog dequeueDogs() 
	{
		return dogs.poll();
	}

	// Remove Cats
	public Cat dequeueCats() 
	{
		return cats.poll();
	}

	// Remove Any Animal
	public Animal dequeueAny() 
	{
		// While dequeuing, if any queue is null, then the task becomes simple. 
		// Remove from the one which is not null 
		if (dogs.size() == 0) 
		{
			return dequeueCats();
		}
		else if (cats.size() == 0) 
		{
			return dequeueDogs();
		}

		// If conntrol reached here, it means both the queues have some animals.
		// Now we need to decide which animal is older.

		// To do that, first get the objects at start of both the queues
		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		// If dog was inserted before cat, it means its index will be smaller
		// then return Dog. Else, Cat.
		if (cat.order > dog.order) 		
			return dequeueDogs();	 		
		else 		
			return dequeueCats();
	}

	public Animal peek() 
	{
		// While peeking, if any queue is null, then the task becomes simple. 
		// peek from the one which is not null 
		if (dogs.size() == 0) 
		{
			return cats.peek();
		} 

		else if (cats.size() == 0) 
		{
			return dogs.peek();
		}

		// If conntrol reached here, it means both the queues have some animals.
		// Now we need to decide which animal is older.

		// To do that, first get the objects at start of both the queues
		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		// If dog was inserted before cat, it means its index will be smaller
		// then return Dog. Else, Cat.
		if (cat.order > dog.order)		
			return dog;
		else 
			return cat;

	}

	public int size() 
	{
		int noOfDogs = dogs.size();
		int noOfCats = cats.size();
		int totalSize = noOfDogs +  noOfCats;
		return  totalSize;
	}

	public Dog peekDogs() 
	{
		return dogs.peek();
	}	

	public Cat peekCats() 
	{
		return cats.peek();
	}
}