import java.util.Scanner;
/** Header Block (good programming practice)
Brief Description of Class function: *This class calculates random numbers between two limits
My name: * @author J. Alvarez
 Student Number: * 2588
Name of file: *Lab1.java
Date created: *1/16/2025

This is good formatting for creating code. Stars in front are intended., For the class it is important
 */


public class Lab1 {
    public static void main(String[] args) {

        int num = 1;
        int limit = 0;

        System.out.println("The limit should be greater than or equal to " + limit);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        num = sc.nextInt();
        System.out.println("Enter limit");
        limit = sc.nextInt();

        while(limit <= num) {
            System.out.println("The limit should be greater than or equal to " + limit);
            System.out.println("Enter number");
            num = sc.nextInt();
            System.out.println("Enter limit");
            limit = sc.nextInt();
        }

        System.out.println("Sum determined is " + sum(num, limit));
        sc.close();
    }

    /**
     * Generating a random number between and including min and max
     * @param min -minimum value for range
     * @param max -maximum value for range
     * @return -return random number between min and max
     */
    public static int randomRange(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
    
    /**
     *
     * @param num -number provided by the user
     * @param limit -limit provided by the user that must be greater than num
     * @return -return addition of two values determined by randomRange function
     */
    public static int sum(int num, int limit){
        int rand1 = randomRange(3, 8);
        int rand2 = randomRange(3, 8);
        int val1 = num * rand1;
        int val2 = num * rand2;
        System.out.println("Random values are " + rand1 + " and " + rand2);
        return val1 + val2;
    }
    
}
