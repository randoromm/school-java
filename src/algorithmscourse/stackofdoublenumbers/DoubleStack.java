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
        test.op("+");
        System.out.println(test.toString());
        System.out.println(interpret("5 5 5 + 2 5"));
    }

    private LinkedList<Double> stack;

    DoubleStack() {
        stack = new LinkedList<>();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DoubleStack clonedObj = new DoubleStack();
        clonedObj.stack = (LinkedList<Double>)stack.clone();
        return clonedObj;
    }

    public boolean stEmpty() {
        return stack.isEmpty();
    }

    public void push(double a) {
        stack.push(a);
    }

    public double pop() {
        if (stEmpty()) throw new RuntimeException();
        return stack.pop();
    }

    public void op (String s) {
        double first = pop();
        double second = pop();

        if (s.equals("+")) push(second + first);
        if (s.equals("-")) push(second - first);
        if (s.equals("*")) push(second * first);
        if (s.equals("/")) push(second / first);
    }

    public double tos() {
        if (stEmpty()) throw new RuntimeException();
        return stack.peek();
    }

    @Override
    public boolean equals (Object o) {
        return o instanceof DoubleStack && stack.equals(((DoubleStack) o).stack);
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        if (stEmpty()) return bld.append("[]").toString();

        bld.append("[");
        for (int i = stack.size() - 1; i >= 0; i--) {
            bld.append(stack.get(i));
            if (!stack.peek().equals(stack.get(i))) {
                bld.append(", ");
            }
        }

        return bld.append("]").toString();
    }

    public static double interpret(String pol) {
        if (!pol.matches("[\\d\\s*.+/-]+")) throw new RuntimeException();
        DoubleStack stack = new DoubleStack();
        String[] tokens = pol.split(" +");
        for (String s : tokens) {
            if (s.matches("[*+/-]$")) {
                stack.op(s);
            } else if (s.length() > 0) {
                stack.push(Double.parseDouble(s));
            }
        }

        double result = stack.pop();
        if (!stack.stEmpty()) throw new RuntimeException();
        return result;
    }

}
