import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int userProgramChoice = -1;
        while (userProgramChoice != 0)
        {
            System.out.println("Choose Calculation:");
            // Message for every calculation available
            userProgramChoice = scanner.nextInt();
            switch (userProgramChoice){
                case 1 -> areaAndCircumferenceOfCircle(); // calc1
                case 2 -> {} // calc2
                case 3 -> {} // calc3
                case 4 -> {} // calc4
                case 5 -> {} // calc5
                case 6 -> {} // calc6
                case 7 -> {} // calc7
                case 8 -> {} // calc8
                case 9 -> {} // calc9
                case 10 -> {} // calc10
                case 11 -> {} // calc11
                case 12 -> {} // calc12
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
}
