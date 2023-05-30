/*Demonstrate the difference between abstract class and interface by writing programs
as well as in keypoints.
 */


package in.ineuron.test;

abstract class Animal {
    public abstract void sound();
}

class Elephant extends Animal {
    @Override
    public void sound() {
        System.out.println("trumpets");
    }
}

public class AbstracclstvsInterface {
    public static void main(String[] args) {
        Animal animal = new Elephant();
        animal.sound();
    }
}

/*difference between abstract class and interface--->
 * Abstract Class--
 * 1) Abstract class can have abstract and non-abstract methods.
 * 2) Abstract class can have final, non-final, static and non-static variables.
 * 3) Abstract class can provide the implementation of interface.
 * 4) An abstract class can extend another Java class and implement multiple Java interfaces.
 * 5) A Java abstract class can have class members like private, protected, etc.
 * 
 * Interface--->
 * 1) Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
 * 2)Interface has only static and final variables.
 * 3)Interface can't provide the implementation of abstract class.
 * 4)An interface can extend another Java interface only.
 * 5)Members of a Java interface are public by default.
 * 
 */

