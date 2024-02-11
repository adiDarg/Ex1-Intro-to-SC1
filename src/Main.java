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
                case 1 -> calculateAreaAndCircumferenceOfCircle();
                case 2 -> convertBetweenCelsiusAndFahrenheit();
                case 3 -> calculateFactorial();
                case 4 -> calculateSumOfNaturalsInRange();
                case 5 -> isPrime();
                case 6 -> isFiveDigitNumberAPalindrome();
                case 7 -> printAllPrimesInRange();
                case 8 -> checkGreatestCommonDivisor();
                case 9 -> quadraticEquationSolver();
                case 10 -> compoundInterest();
                case 11 -> isPartOfFibonacciSeries();
                case 12 -> closestNarcissistNumber();
                case 0 -> System.out.println("Program will now end");
                default -> System.out.println("Invalid input. Input 1-12 for a corresponding calculation or input 0 to end the program");
            }
        }
    }
    public static void calculateAreaAndCircumferenceOfCircle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input radius of circle");
        double radius = scanner.nextDouble();
        double area = radius*radius*3.14;
        double circumference = radius*2*3.14;
        System.out.println(area + " is the area of the circle, " + circumference + " is the circumference of the circle");
    }
    public static void convertBetweenCelsiusAndFahrenheit(){
        Scanner scanner = new Scanner(System.in);
        char temperatureType;
        do {
            System.out.println("Input c to convert from celsius, input f to convert from fahrenheit");
            temperatureType = scanner.next().charAt(0);
        } while (temperatureType != 'c' && temperatureType != 'f');
        System.out.println("Input degrees in chosen temperature type");
        double originalTemperature = scanner.nextDouble();
        double convertedTemperature;
        if (temperatureType == 'c')
            convertedTemperature = originalTemperature * 9/5 + 32;
        else
            convertedTemperature = (originalTemperature -32) * 5/9;
        System.out.println("The converted temperature is: " + convertedTemperature + " degrees ");
    }
    public static void calculateFactorial() {
        Scanner scanner = new Scanner(System.in);
        int num;
        int counter = 0;
        do {
            if (counter > 0) {
                System.out.println("invalid number");
            }
            System.out.println("insert a whole non negative number:");
            num = scanner.nextInt();
            counter++;
        } while (num <= 0);

        int sum = 1;
        for (int i = num; i > 0; i--) {
            sum *= i;
        }
        System.out.println(num + " factorial is: " + sum);
    }
    public static void calculateSumOfNaturalsInRange(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int start;
        int end;
        do {
            System.out.println("Input start of range(natural number)");
            start = scanner.nextInt();
        } while (start <= 0);
        do {
            System.out.println("Input end of range(natural number, bigger than start of range)");
            end = scanner.nextInt();
            if (end == start)
                System.out.println("You cannot input 2 identical numbers");
        } while (end == start || end <= 0);
        if (end > start){
            for (int i = start; i <= end; i++){
                sum += i;
            }
        }
        else{
            for (int i = end; i <= start; i++){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static void isPrime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number");
        int num = scanner.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                isPrime =  false;
                break;
            }
        }
        if (isPrime)
            System.out.println("Number is prime");
        else
            System.out.println("Number is not prime");
    }
    public static void isFiveDigitNumberAPalindrome(){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (!isNumberFiveDigits(number)){
            System.out.println("Input 5 digit number");
            number = scanner.nextInt();
        }
        int reversedNumber = 0;
        int temp = number;
        for (int i = 10000; i >=1; i/=10){
            reversedNumber += (temp%10) * i;
            temp /= 10;
        }
        if (reversedNumber == number)
            System.out.println("Number is a palindrome");
        else
            System.out.println("Number is not a palindrome");

    }
    public static boolean isNumberFiveDigits(int num){
        int digitCount = 0;
        do{
            digitCount++;
            num /=10;
        } while (num >0);
        return digitCount == 5;
    }
    public static void printAllPrimesInRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input starting number");
        int startingNumber = scanner.nextInt();
        System.out.println("Input final number");
        int finalNumber = scanner.nextInt();
        for (int i = startingNumber; i <= finalNumber; i++){
            if (returnIsPrimeValue(i))
                System.out.println(i);
        }
    }
    public static boolean returnIsPrimeValue(int num){
        for (int i = 2; i < num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void checkGreatestCommonDivisor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number");
        int num1 = scanner.nextInt();
        System.out.println("Input second number");
        int num2 = scanner.nextInt();
        int GCD = 1;
        for (int i = 2; i <= num1; i++){
            if (num1 % i == 0 && num2 % i == 0)
                GCD = i;
        }
        System.out.println("Greatest common divisor is :" + GCD);
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
            balance *= Math.pow((interest+1),3);
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