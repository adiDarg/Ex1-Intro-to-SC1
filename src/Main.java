import java.lang.ref.Cleaner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int userProgramChoice = -1;
        while (userProgramChoice != 0)
        {
            System.out.println("Choose Calculation:");
            System.out.println("1: Input radius to get area and circumference of a circle");
            // Message for every calculation available besides 1
            System.out.println("0: Exit program");
            userProgramChoice = scanner.nextInt();
            switch (userProgramChoice){
                case 1 -> areaAndCircumferenceOfCircle();
                case 2 -> {} // calc2
                case 3 -> {} // calc3
                case 4 -> {} // calc4
                case 5 -> {} // calc5
                case 6 -> {} // calc6
                case 7 -> {} // calc7
                case 8 -> {} // calc8
                case 9 -> quadraticEquationSolver();
                case 10 -> compoundInterest();
                case 11 -> isPartOfFibonacciSeries();
                case 12 -> closestNarcissistNumber();
                case 0 -> System.out.println("Program will now end");
                default -> System.out.println("Invalid input. Input 1-12 for a corresponding calculation or input 0 to end the program");
            }
        }
    }
    public static void areaAndCircumferenceOfCircle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input radius of circle");
        double radius = scanner.nextDouble();
        double area = radius*radius*3.14;
        double circumference = radius*2*3.14;
        System.out.println(area + " is the area of the circle, " + circumference + " is the circumference of the circle");
    }
    public static void quadraticEquationSolver(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input coefficient of x squared(a)");
        float a = scanner.nextFloat();
        System.out.println("Input coefficient of x (b)");
        float b = scanner.nextFloat();
        System.out.println("Input free number(c)");
        float c = scanner.nextFloat();
        float discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
        {
            System.out.println("Equation has no solutions");
        }
        else if (discriminant == 0)
        {
            System.out.println("Equation has one solution");
            float result = -b /(2*a);
            System.out.println("The solution of the equation is: " + result);
        }
        else
        {
            System.out.println("Equation has two solutions");
            float result1 = (-b + (float)Math.sqrt(discriminant)) /(2 * a);
            float result2 = (-b - (float)Math.sqrt(discriminant)) /(2 * a);
            System.out.println("The first solution of the equation is: " + result1);
            System.out.println("The second solution of the equation is: " + result2);
        }
    }
    public static void compoundInterest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input starting sum");
        double balance = scanner.nextDouble();
        System.out.println("Input interest in percent");
        double interest = scanner.nextDouble()/100;
        for (int i = 3; i <= 36; i+= 3)
        {
            balance *= interest * interest * interest;
            double withdrawSum = i%12 == 0? balance: balance/2;
            System.out.println("sum of money to withdraw after " + i + " months is: " + withdrawSum);
        }

    }
    public static void isPartOfFibonacciSeries(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        int number = scanner.nextInt();
        int currentFibonacciNum = 1;
        int previousFibonacciNum = 0;
        while (currentFibonacciNum < number)
        {
            int temp = currentFibonacciNum;
            currentFibonacciNum += previousFibonacciNum;
            previousFibonacciNum = temp;
        }
        if (currentFibonacciNum == number)
        {
            System.out.println("Number received from user is part of the fibonacci series");
        }
        else
        {
            System.out.println("Number received from user is not part of the fibonacci series");
        }
    }
    public static void closestNarcissistNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number");
        int number = scanner.nextInt();
        int closestNarcissistAbove = number;
        int closetNarcissitBelow = number;
        while (!isNarcissistNumber(closestNarcissistAbove)&& !isNarcissistNumber(closetNarcissitBelow))
        {
            closestNarcissistAbove++;
            closetNarcissitBelow--;
        }
        int closestNarcissist = isNarcissistNumber(closestNarcissistAbove)? closestNarcissistAbove: closetNarcissitBelow;
        System.out.println(closestNarcissist + " is the closest narcissist number to the input(" + number + ")");
    }
    public static boolean isNarcissistNumber(int number){
        int numberCopy = number;
        int digitCount = 0;
        do
        {
            numberCopy /= 10;
            digitCount++;
        } while (numberCopy >0);
        int sumOfDigitsToPowerOfDigitCount = 0;
        int expectedResult = number;
        do
        {
            sumOfDigitsToPowerOfDigitCount += (int) Math.pow(number%10, digitCount);
            number/=10;
        } while (number >0);
        return sumOfDigitsToPowerOfDigitCount == expectedResult;
    }
}