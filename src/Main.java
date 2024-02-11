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
            System.out.println("1: Calculates area and circumference of a circle with radius");
            System.out.println("2: Converts celsius to fahrenheit and fahrenheit to celsius");
            System.out.println("3: Calculates the factorial of the given number");
            System.out.println("4: Calculates the sum of natural numbers in given range");
            System.out.println("5: Checks whether a given number is prime");
            System.out.println("6: Checks whether a given 5 digit number is a palindrome");
            System.out.println("7: Prints all prime numbers in a given range");
            System.out.println("8: Calculates the GCD(greatest common divisor) of two given numbers");
            System.out.println("9: Calculates results of a given quadratic equation");
            System.out.println("10: Calculates the compound interest of a given sum of money with a given rate over 3 month periods(until 36 months)");
            System.out.println("11: Checks whether a given number is part of the fibonacci series");
            System.out.println("12: Prints the closest narcissist number to a given number");
            System.out.println("0: Exits program");

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
            balance *= (interest+1);
            double withdrawSum = i%12 == 0? balance: balance/2;
            System.out.println("sum of money to withdraw after " + i + " months is: " + withdrawSum);
            if (i %12 != 0)
                System.out.println("sum was halved for not withdrawing after a full year(or multiple full years)");
            System.out.println();
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
        int closetNarcissistBelow = number;
        while (!isNarcissistNumber(closestNarcissistAbove)&& !isNarcissistNumber(closetNarcissistBelow))
        {
            closestNarcissistAbove++;
            closetNarcissistBelow--;
        }
        int closestNarcissist = isNarcissistNumber(closestNarcissistAbove)? closestNarcissistAbove: closetNarcissistBelow;
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