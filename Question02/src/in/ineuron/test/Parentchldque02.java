/*Write a Java program to invoke parent class constructor from a child class. Create
Child class object and parent class constructor must be invoked. Demonstrate by
writing a program. Also explain key points about Constructor. 
 * 
 */


package in.ineuron.test;



	class Parent {
	    public Parent() {
	        System.out.println("Parent class constructor");
	    }
	}

	class Child extends Parent {
	    public Child() {
	        super(); // Invoke the parent class constructor
	        System.out.println("Child class constructor");
	    }
	}

	public class Parentchldque02 {
	    public static void main(String[] args) {
	        Child child = new Child();
	    }
	}


/*Constructors
	============
	 =>Object creation is not enough, compulsorily we should perform initialization then only the
	   object is in a position to provide the response properly.
	 => Whenever we are creating an object some piece of the code will be executed automatically to
	    perform initialization of an object this piece of code is nothing but constructor.
	 => Main objective of constructor is nothing but initialisation of Object.
	 
There are two rules defined for the constructor:

 1.Constructor name must be the same as its class name
 2.A Constructor must have no explicit return type
 3.A Java constructor cannot be abstract, static, final, and synchronized
 
There are two types of constructors in Java:

1.Default constructor (no-arg constructor)
2.Parameterized constructor
*/
	


