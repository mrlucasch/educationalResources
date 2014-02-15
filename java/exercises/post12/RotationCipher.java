/*
 *This class implements the rotational cipher as explained in post12.
 *
 *
 */

public class RotationCipher{  

    /*
     *The rotateKey function takes in the key and rotates the key, by one letter
     *
     */
    static char[] rotateKey(char[] key)
    {
        //keep a temporary key to store the values while rotating.
        char[] tempKey = new char[key.length];
    
        //iterate over the key and shift each index up by one.
        for(int i = 0 ; i < key.length; i++)
        {
            //check if we are at the end of the array
            //in this case we need to set it to the first letter
            //in key. This avoids a nasty error caused from
            //accessing an out of bound value.
            if(i == key.length - 1)
            {
                //set the last character to first character of key
                tempKey[i] = key[0];
            }
            else{
                //other wise set it to the next letter
                tempKey[i] =  key[i+1];
            }
        }
        //return the newly rotated key
        return tempKey;
    }

    /*
    * 
    * The encode function takes in a char named c and a char array that
    * functions as the encryption key. This function should return an 
    * encrypted char value. The function will subtract the letter a from 
    * the character c to get the index of our encoded value. Using the 
    * result it accesses the index and returns the value from key.
    */

    static char encode (char c, char[] key)
    {
        //convert the letter to an index by subtracting a number
        int letterToNumber = c - 'a';
        
        //return the character at the index letterToNumber 
        return key[letterToNumber];
    }




    /*
     *The decode function takes in an encoded value named c and a char 
     * array that functions as the decryption key. This function should
     * return a decrypted value. 
     */
    static char decode(char c, char[] key)
    {
       //String to hold the letters of the alphabet
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
       
        //convert the alphabet string to an array
        char[] decryptKey = alphabet.toCharArray();
        
        //counter to store index of letter
        int counter = 0;

        //iterate through the key string and stop once you have found 
        //your letter.Increment a counter each letter you pass.
        for(int i = 0 ; i < key.length; i++)
        {
            //compare current index vs our letter.
            if (key[i] == c)
            { 
                //we have found our letter break out of loop.
                break;
            }

            //increment counter by 1
            counter++;
        }
        //return the letter in the alphabet with the index of counter.
        return decryptKey[counter];

    }


    /*
     * The encryption function takes in a char array and encrypts 
     * it using the algorithm for the rotational cipher
     *
     */
    static char[] encrypt(char[] text, char[] key)
    {
        //create an array as big as text to store the encoded values
        char[] encodedText = new char[text.length];
        
        //iterate over the text array, and at each index encode the character
        for(int i = 0; i < text.length; i++)
        {
            
            //call the encode function with the key and store return in i index of encodedText[i]
            encodedText[i] = encode(text[i],key);
            
            //rotate the key and then save it.
            key =  rotateKey(key);
        }

       //return the encodedText  
        return encodedText;
    }

    
    /*
     * The decryption function takes in a char array and decrypts it using 
     * the algorithm for the rotational cipher, described in post12
     */
    static char[] decrypt(char[] text, char[] key)
    {
        //create an array as big as text to store the decoded values
        char[] decodedText = new char[text.length];

        //iterate over the text array, and at each index decode the character
        for(int i = 0; i < text.length; i++)
        {
            //call decode function and store return in decodedText
            decodedText[i] = decode(text[i], key);

            //rotate the key and save it
            key = rotateKey(key);
        }

        //return the decoded text
        return decodedText;
    }

    public static void main(String[] args)
    {
        //store the key in a string
        String subKey = "qwertyuiopasdfghjklzxcvbnm";
        //convert the string to a char array
        char[] key = subKey.toCharArray();
        
        //Store the plain text as a string
        String plain = "attackatdawn";

        //Store the mystery string
        String mystery = "ihnhtltvmbjedmqzipsivevatrqdapsniwzabmmkvookmzsnlbhrhljthpl";

        //encrypt the plain text and store as cipher
        char[] cipher = encrypt(plain.toCharArray(),key);
        
        //decrypt the ciphertext and store as text
        char[] text = decrypt(cipher,key);

        //decrypt the mystey text and store as mystery solved
        char[] mysterySolved = decrypt(mystery.toCharArray(), key);

        //print out the results
        System.out.println("The plain text was "+plain);
        System.out.println("The cipher text was "+String.valueOf(cipher));
        System.out.println("The decrypted text was "+String.valueOf(text));
        System.out.println("The mystery cipher text was "+mystery);
        System.out.println("The mystery plain text was "+String.valueOf(mysterySolved));
        

    }


}


