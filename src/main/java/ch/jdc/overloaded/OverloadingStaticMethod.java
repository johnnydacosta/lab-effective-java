package ch.jdc.overloaded;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*; // Importing necessary classes

public class OverloadingStaticMethod {

    static String classify(Set<?> s) {
        return "Set";
    }

    static String classify(List<?> lst) {
        return "List";
    }

    static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    static class Animal {
        public String getName() {
            return "Unknown Animal";
        }
    }

    static class Cat extends Animal {
        @Override
        public String getName() {
            return "Cat";
        }
    }

    static class Dog extends Animal {
        @Override
        public String getName() {
            return "Dog";
        }
    }

    public static void main(String[] args) throws IOException {

        // Array of collections with different actual types
        Collection<?>[] collections = {
                new HashSet<String>(), // Actual type: HashSet
                new ArrayList<BigInteger>(), // Actual type: ArrayList
                new HashMap<String, String>().values() // Actual type: Collection (values() returns a Collection)
        };

        // Static method calls
        for (Collection<?> c : collections) {
            // The declared type of 'c' is Collection<?> (from the for loop),
            // so the compiler decides which overload of 'classify' to call at compile time.
            // Even though the actual object (at runtime) might be a HashSet or ArrayList,
            // compile-time resolution does not consider the actual object type.
            // This happens because static methods are bound to the class, not the object.
            System.out.println(classify(c));
            // Result for all three cases:
            // "Unknown Collection" is printed for every element,
        }

        System.out.println();

        // Array of animals with different actual types
        Animal[] animals = {
                new Animal(), // Actual type: Animal
                new Cat(),    // Actual type: Cat
                new Dog(),    // Actual type: Dog
        };

        // Dynamic method calls
        for (Animal a : animals) {
            // The declared type of 'a' is Animal (from the for loop),
            // but instance methods are resolved dynamically at runtime.
            // This means the JVM looks at the actual object type (runtime type)
            // of 'a' to determine which version of the getName() method to call.
            System.out.println(a.getName());
            // Results:
            // "Unknown Animal" for new Animal()
            // "Cat" for new Cat()
            // "Dog" for new Dog()
        }
    }
}
