/*
 * This class allows the brain to study material
 *
 *
 * */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Study{


    public Study()
    {
        //sends the file to the function that studies the material
    }
    

    /*
     * The print function allows you to test your results and see the material learned
     *
     */
    public static void print(String[] material)
    {
        for(int i =0; i<material.length; i++)
        {
            System.out.println(material[i]);
        }
    }

    /*
     * This function reads in a file and then returns a data
     * structure with the coresponding data.
     * */
    public static String[] readTheMaterial(String material)
    {
        try{
            //opens a fileReader
            Scanner fileReader = new Scanner(new File(material));
            return studyMaterial(fileReader);
        }
        catch(IOException e){
            System.out.println("File: "+material+" not found!");
            System.exit(0);
        }
        return null; 
    }

    /*
     * Function to read fact sheets. Returns a string array with the studied material 
     */
    private static String[] studyMaterial(Scanner fileReader)
    {    
        //read in the first line of the file which will be the topic 
        String topic = fileReader.nextLine();
        
        //skip the next line
        fileReader.nextLine();

        //read in the number of lines, so we know how big to make the array 
        //that stores the info 
        int length = fileReader.nextInt();
        
        //create the array to store the material
        String[] classMaterial = new String[length];

        //go to next line
        fileReader.nextLine();

        //skip the section divider in the file
        fileReader.nextLine();
        //read in the number of total lines left
        int numLines = fileReader.nextInt();
        
        //skip to next line and skip the line divider
        fileReader.nextLine();
        fileReader.nextLine();


        //create the string to hold each line of file
        String line = "";
        
        //this is a counter to keep track of array indexing
        int counter = 0;

        //Loop until you reach  end of file designator
        for(int i =0; i<numLines; i++)
        {
        
            //Read in the line
            line = fileReader.nextLine();
            if(line.equals("0"))
            {
                continue;
            }
            else if(line.equals("2")) //2 means next line is a title
            {
                //read next line so we can store it
                line = fileReader.nextLine();
                classMaterial[counter] = line; //add title to array
                i++;//increment loop variable
                counter++; //increment index counter
            }
            else if(line.equals("END"))
            {
                break; //reached end of file so lets break;
            }
            else 
            {
                //we've reached this point so it is a valid line.
                classMaterial[counter] = line;
                counter++; //increment index counter
            }


        }
        return classMaterial;
    }
}
