package algorithmscourse.stackofdoublenumbers;

import java.util.LinkedList;

public class DoubleStack {

    public static void main (String[] argum) {
        DoubleStack test = new DoubleStack();
        test.push(20);
        test.push(4);
        test.push(7);
        test.push(54);
        System.out.println(test.toString());
        System.out.println(test.pop());
        System.out.println(test.toString());
    }

    public LinkedList<Double> stack;

    DoubleStack() {
        stack = new LinkedList<>();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DoubleStack clonedObj = new DoubleStack();
        LinkedList clonedList = (LinkedList<Double>)stack.clone();
        clonedObj.stack = clonedList;
        return clonedObj; // TODO!!! java.lang.AssertionError: clone must be equal to original; (even tho it is)
    }

    public boolean stEmpty() {
        return stack.isEmpty();
    }

    public void push (double a) {
        stack.push(a);
    } // TODO!!! Deal with overflow?

    public double pop() {
        if (stEmpty()) throw new RuntimeException();
        return stack.pop(); // TODO!!! Confirm exception.
    } // pop

    public void op (String s) {
        double first = stack.pop();
        double second = stack.pop();

        if (s.equals("+")) stack.push(first + second);
        if (s.equals("-")) stack.push(first - second);
        if (s.equals("*")) stack.push(first * second);
        if (s.equals("/")) stack.push(first / second);
    }

    public double tos() {
        return stack.peek();
    }

    @Override
    public boolean equals (Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        DoubleStack tmp = (DoubleStack) o;
        return tmp.stack == stack;
    } // TODO!!! java.lang.AssertionError: two empty stacks must be equal;

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        if (stEmpty()) return bld.append("[]").toString();

        bld.append("[");
        for (int i = stack.size() - 1; i >= 0; i--) {
            bld.append(stack.get(i));
            if (stack.peek() != stack.get(i)) {
                bld.append(", ");
            }
        }

        return bld.append("]").toString();
    }

    public static double interpret (String pol) {
        return 0.; // TODO!!! Your code here!
    }

}


