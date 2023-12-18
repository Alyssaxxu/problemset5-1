
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Driver
{
    public static void main(String [] args){
        Fraction milu = new Fraction (355,113);
        final double EPSILON = Math.abs( Math.PI - milu.toDouble() );

        while (Math.abs( Math.PI - milu.toDouble()) > EPSILON){
            if (milu.toDouble() < Math.PI){
                milu.setNum(milu.getNumerator() + 1);
            }
            else{
                milu.setDenom(milu.getDenominator() +1);
            }
        }
        System.out.println("The next closest fraction to π is: " + milu);

        Scanner scanner = new Scanner(System.in);
        Fraction game = new Fraction();
        int wins = 0;
        int loss = 0;

        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        System.out.println("Type 'quit' to end the quiz.");

        while (true) {
            Fraction question = new Fraction(0);
            Fraction answer = new Fraction(1);
            char operator = game.randomOperator();

            System.out.println(  question + " " + operator + " " + answer + "?");
            String userResponse = scanner.nextLine();
            if (userResponse.equalsIgnoreCase("quit")) {
                break;
            }
            Fraction userAnswer = new Fraction(userResponse);
            Fraction correctAnswer = game.correctAnswer(question, answer, operator);
            if (userAnswer.getDenominator() == correctAnswer.getDenominator() && userAnswer.getNumerator() == correctAnswer.getNumerator() ) {
                System.out.println("Correct!");
                wins++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswer);
                loss++;
            }
        }

        System.out.println("Quiz Results:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + loss);
        Fraction winRatio = new Fraction(wins, loss + wins);
        System.out.println("Win/Loss Ratio: " + winRatio);
        int winPercentage = (wins/(loss+wins) * 100);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}
