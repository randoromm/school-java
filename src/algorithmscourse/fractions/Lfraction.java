package algorithmscourse.fractions;

/** This class represents fractions of form n/d where n and d are long integer
 * numbers. Basic operations and arithmetics for fractions are provided.
 */
public class Lfraction implements Comparable<Lfraction> {

    /** Main method. Different tests. */
    public static void main (String[] param) {
        Lfraction test1 = new Lfraction(1, 2);
        Lfraction test2 = new Lfraction(9, 4);

        System.out.println(toLfraction(Math.PI, 7));
    }

    private long numerator, denominator;

    /** Constructor.
     * @param a numerator
     * @param b denominator > 0
     */
    public Lfraction (long a, long b) {
        if (a == 0) {
            numerator = a;
            denominator = 1L;
        } else if (b > 0) {
            numerator = a / gcd(a, b);
            denominator = b / gcd(a, b);
        } else {
            throw new RuntimeException("Denominator must be strictly positive!");
        }
    }

    /** Public method to access the numerator field.
     * @return numerator
     */
    public long getNumerator() {
        return numerator;
    }

    /** Public method to access the denominator field.
     * @return denominator
     */
    public long getDenominator() {
        return denominator;
    }

    /** Conversion to string.
     * @return string representation of the fraction
     */
    @Override
    public String toString() {
        String result = "";
        return result.format("%1$d/%2$d", numerator, denominator);
    }

    /** Equality test.
     * @param m second fraction
     * @return true if fractions this and m are equal
     */
    @Override
    public boolean equals (Object m) {
        long gcd = gcd(((Lfraction) m).numerator, ((Lfraction) m).denominator);
        boolean instanceOfLfraction = m instanceof Lfraction;
        boolean numeratorEqual = numerator == ((Lfraction) m).numerator / gcd;
        boolean denominatorEqual = denominator == ((Lfraction) m).denominator / gcd;


        return instanceOfLfraction && numeratorEqual && denominatorEqual;
    }

    /** Hashcode has to be equal for equal fractions.
     * Materials used: https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    /** Sum of fractions.
     * @param m second addend
     * @return this+m
     */
    public Lfraction plus (Lfraction m) {
        long newDen = denominator * m.denominator;
        long newNum = numerator * newDen / denominator + m.numerator * newDen / m.denominator;
        return new Lfraction(newNum, newDen);
    }

    /** Multiplication of fractions.
     * @param m second factor
     * @return this*m
     */
    public Lfraction times (Lfraction m) {
        return new Lfraction(numerator * m.numerator, denominator * m.denominator);
    }

    /** Inverse of the fraction. n/d becomes d/n.
     * @return inverse of this fraction: 1/this
     */
    public Lfraction inverse() {
        Lfraction one = new Lfraction(1, 1);
        return one.divideBy(this);
    }

    /** Opposite of the fraction. n/d becomes -n/d.
     * @return opposite of this fraction: -this
     */
    public Lfraction opposite() {
        return new Lfraction(-numerator, denominator);
    }

    /** Difference of fractions.
     * @param m subtrahend
     * @return this-m
     */
    public Lfraction minus (Lfraction m) {
        long newDen = denominator * m.denominator;
        long newNum = numerator * newDen / denominator - m.numerator * newDen / m.denominator;
        return new Lfraction(newNum, newDen);
    }

    /** Quotient of fractions.
     * @param m divisor
     * @return this/m
     */
    public Lfraction divideBy (Lfraction m) {
        if (m.numerator == 0) throw new RuntimeException("Cant divide by zero.");
        if (m.numerator < 0) {
            return new Lfraction(numerator * -m.denominator, denominator * -m.numerator);
        }
        return new Lfraction(numerator * m.denominator, denominator * m.numerator);
    }

    /** Comparision of fractions.
     * @param m second fraction
     * @return -1 if this < m; 0 if this==m; 1 if this > m
     */
    @Override
    public int compareTo (Lfraction m) {
        long commonDenominator = denominator * m.denominator;
        long num1 = numerator * commonDenominator;
        long num2 = m.numerator * commonDenominator;

        if (num1 < num2) return -1;
        else if (num1 == num2) return 0;
        return 1;
    }

    /** Clone of the fraction.
     * @return new fraction equal to this
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Lfraction(numerator, denominator);
    }

    /** Integer part of the (improper) fraction.
     * @return integer part of this fraction
     */
    public long integerPart() {

        return numerator / denominator;
    }

    /** Extract fraction part of the (improper) fraction
     * (a proper fraction without the integer part).
     * @return fraction part of this fraction
     */
    public Lfraction fractionPart() {
        return new Lfraction(numerator % denominator, denominator);
    }

    /** Approximate value of the fraction.
     * @return numeric value of this fraction
     */
    public double toDouble() {
        double num = numerator;
        double denom = denominator;
        return num / denom;
    }

    /** Double value f presented as a fraction with denominator d > 0.
     * @param f real number
     * @param d positive denominator for the result
     * @return f as an approximate fraction of form n/d
     */
    public static Lfraction toLfraction (double f, long d) {
        return new Lfraction(Math.round(f * d), d);
    }

    /** Conversion from string to the fraction. Accepts strings of form
     * that is defined by the toString method.
     * @param s string form (as produced by toString) of the fraction
     * @return fraction represented by s
     */
    public static Lfraction valueOf (String s) {
        if (!s.matches("([-]{0,1}[\\d]+[/]{1}[\\d]+)")) {
            throw new RuntimeException("String doesn't match the proper form");
        }
        String[] arr = s.split("/");
        long num = Long.parseLong(arr[0]);
        long denom = Long.parseLong(arr[1]);
        return new Lfraction(num, denom);
    }

    /**
     * Method to find greatest common divisor of 2 integers.
     * @param a first integer
     * @param b second integer
     * @return greatest common divisor
     */
    public static long gcd(long a, long b) {
        if (a == 0 || b == 0) return Math.abs(a+b); // returns which ever is not 0
        return gcd(b, a%b);
    }
}


