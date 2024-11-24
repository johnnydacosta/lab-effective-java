package ch.jdc.overloaded;

public class ExecutorOverloaded {

    static class MoreExplicitObject {
        // A custom class with no special relationship to Object, but acts as a base class for MoreMoreExplicitObject.
    }

    static class MoreMoreExplicitObject extends MoreExplicitObject {
        // A subclass of MoreExplicitObject.
    }

    static class Executor {
        // Overloaded method: accepts any Object
        void process(Object obj) {
            System.out.println("Object version called");
        }

        // Overloaded method: accepts a MoreExplicitObject specifically
        void process(MoreExplicitObject obj) {
            System.out.println("MoreExplicitObject version called");
        }

        // Overloaded method: accepts a MoreMoreExplicitObject specifically
        void process(MoreMoreExplicitObject obj) {
            System.out.println("MoreMoreExplicitObject version called");
        }
    }

    public static void main(String[] args) {
        Executor e = new Executor();

        // Call to process(1):
        // - The argument `1` is an integer (int type).
        // - The method process(Object obj) is chosen because:
        //   - There is no method specifically for int.
        //   - The int value '1' is automatically boxed into an Integer object.
        //   - The Integer type matches the Object parameter in process(Object obj).
        e.process(1); // Output: "Object version called"

        // Call to process(new MoreExplicitObject()):
        // - The argument is explicitly an instance of MoreExplicitObject.
        // - The method process(MoreExplicitObject obj) is chosen because it directly matches the type of the argument.
        e.process(new MoreExplicitObject()); // Output: "MoreExplicitObject version called"

        // Call to process(new MoreMoreExplicitObject()):
        // - The argument is explicitly an instance of MoreMoreExplicitObject.
        // - The method process(MoreMoreExplicitObject obj) is chosen because it directly matches the type of the argument.
        // - Although MoreMoreExplicitObject is a subclass of MoreExplicitObject, the most specific method is preferred.
        e.process(new MoreMoreExplicitObject()); // Output: "MoreMoreExplicitObject version called"

        // Call to process(null):
        // - The `null` argument matches all three methods because `null` is compatible with any reference type.
        // - The compiler must choose the **most specific method**:
        //   - `MoreMoreExplicitObject` is more specific than `MoreExplicitObject` because it is a subclass.
        //   - Both `MoreMoreExplicitObject` and `MoreExplicitObject` are more specific than `Object`.
        // - Therefore, the method process(MoreMoreExplicitObject obj) is chosen.
        e.process(null); // Output: "MoreMoreExplicitObject version called"
    }
}
