
/**
 * This class represents a fraction with a numerator and denominator
 *
 * @Alyssa Xu
 * @1.0
 */
public class Fraction {

    //Instance Variables
    private int numerator;
    private int denominator;
    private int win = 0;
    private int loss = 0;
    // Constructors ---------------------------------------------
    /**
     *Default constructor. Creates a fraction of 1/1.
     */
    public Fraction(){
        numerator = 1;
        denominator = 1;
    }

    /** Paramaterized constructor
     * @param num the desired numerator
     * @param den the desired denominator. If denominator is zero, denominator is automaticall set to 1. 
     */
    public Fraction (int num, int den){
        numerator = num;
        denominator = den;
        checkDenominator();
    }
    /** Paramaterized constructor
     * @param num used to create an overload method, no actual purpose.
     */
    public Fraction (int num) {
        numerator = (int) (Math.random() * 9 + 1);
        denominator = (int) (Math.random() * 9 + 1);
    }

    /** Paramaterized constructor
     * @param fraction A string containing a fraction. Set numerator(int) to the String's numerator and denominator(int) to the String's denominator. 
     */
    public Fraction (String fraction){
        int n = fraction.indexOf("/");
        if( n> 0){
            numerator = Integer.parseInt(fraction.substring(0, n ));
            denominator = Integer.parseInt(fraction.substring(n+1));
            checkDenominator();
        } else{
            System.out.println( "invaldid fraction");
            numerator = 1;
            denominator = 1;
        }
    }

    /**
     * Copy constructors
     * @param myFraction A fraction object to copy.
     */
    public Fraction( Fraction myFraction){
        numerator= myFraction.numerator;
        denominator = myFraction.denominator;
    }

    //Behaviour Methods --------------------------
    private void checkDenominator(){
        if (denominator ==0 ){
            System.out.println("Error: denominator can't be zero" + "Changed to 1");
            denominator = 1;
        }
    }
    //Accessors 
    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

    public double toDouble(){
        return (double)numerator/denominator;
    }

    // Mutators ---------------
    public int gcd (){
        // calculates and returns the GCF between two numbers
        int a= numerator;
        int b = denominator;
        while (b!=0){
            int temp = b;
            b= a%b;
            a= temp;
        }
        return a;
    }
    public char randomOperator() {
        char[] operators = {'+', '-', '*', '/'};
        return operators[(int) (Math.random() * operators.length)];
    }

    public void reduce(){
        int n = gcd();
        numerator /= n;
        denominator /= n;

    }

    public void setNum(int n){
        numerator = n;
    }

    public void setDenom(int d){
        denominator = d;
    }
    // Static Methods --------------------
    public static Fraction multiply(Fraction a, Fraction b){
        Fraction myFraction = new Fraction();
        myFraction.numerator = a.numerator * b.numerator;
        myFraction.denominator = a.denominator * b.denominator;
        myFraction.reduce();
        return myFraction;
    }

    public static Fraction divide(Fraction a, Fraction b){
        Fraction myFraction = new Fraction();
        myFraction.numerator = a.numerator * b.denominator;
        myFraction.denominator = a.denominator * b.numerator;
        myFraction.reduce();
        return myFraction;
    }

    public static Fraction add(Fraction a, Fraction b){
        Fraction myFraction = new Fraction();
        myFraction.numerator = a.numerator* b.denominator + b.numerator * a.denominator;
        myFraction.denominator = a.denominator * b.denominator;
        myFraction.reduce();
        return myFraction;
    }

    public static Fraction subtract(Fraction a, Fraction b){
        Fraction myFraction = new Fraction();
        myFraction.numerator = a.numerator* b.denominator - b.numerator * a.denominator;
        myFraction.denominator = a.denominator * b.denominator;
        myFraction.reduce();
        return myFraction;
    }

       public Fraction correctAnswer(Fraction a,  Fraction b, char operator) {
        Fraction result = new Fraction();

        if (operator == '+') {
            result = Fraction.add(a, b);
        } else if (operator == '-') {
            result = Fraction.subtract(a, b);
        } else if (operator == '*') {
            result = Fraction.multiply(a, b);
        } else if (operator == '/') {
            result = Fraction.divide(a, b);
        } 

        return result;
    }
}


