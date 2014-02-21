/**
 *
 * This class represents the facts known by a third grader.
 *
 */
import java.util.*;
import java.lang.*;
public class ThirdGrade{

    public static int addition(int a, int b)
    {
        int add = a+b;
        return add;
    }
        
    public static int subtraction(int a, int b)
    {
        int sub = a - b;
        return sub;
    }

    public static int multiplication(int a, int b)
    {
        int multi = a * b;
        return multi;
    }

    public static char[] array(char[] forward)
    {
        char[] reverse = new char[forward.length];
        for(int i = 0; i < forward.length; i++)
        {
            reverse[i] = forward[(forward.length-1)-i];
        }
        return reverse;
    }

    public static char[] copy(char[] original)
    {
        char[] copied = new char[original.length];
        for(int i=0; i<original.length; i++)
        {
            copied[i] = original[i];
        }
        original[1] ='b';
        copied[0] = 'a';
        return copied;
    }
    public static void main(String[] args)
    {
        int sum = addition(1,2);
        System.out.println("The sum of 1 and 2 is "+sum);
                                                       
        int diff = subtraction(5,3);
        System.out.println("The difference of 5 and 3 is "+diff);
                                                                                
        int product = multiplication(5,5);
        System.out.println("The product of 5 and 5 is "+product);

        char[] word = {'a','b','c','1','2','3'};
        char[] reversed = array(word);
        System.out.println(Arrays.toString(word)+" in reverse is "+Arrays.toString(reversed));

        char[] word2 = {'w','x','y','z'};
        System.out.println("The array beforehand is "+Arrays.toString(word2));
        System.out.println("The return of the copy function is "+Arrays.toString(copy(word2)));
        System.out.println("Afterwards the array is "+Arrays.toString(word2));
    }
}
