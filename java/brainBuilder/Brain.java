/*
 * The brain class contains the main method and ties all of the other classes together.
 * 
 *
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Brain{


    public static void main(String[] args)
    {
       Study homework = new Study();

       homework.print(homework.readTheMaterial("3_history.fact"));

    }



}
