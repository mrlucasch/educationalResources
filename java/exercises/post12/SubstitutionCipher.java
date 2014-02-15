/*
 * This class is for the post 12 assignment of CS1111.
 * It contains four functions[or methods] that implement the classic 
 * substitution cipher.
 *
 *
 */
public class SubstitutionCipher{


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
     * The encrypt function encrypts a supplied character array text using a supplied character array key.
     * The function uses the previously written encode function to encode each individual character,
     * then it returns the encoded array
     *
     */
    static char[] encrypt(char[] text, char[] key)
    {
        //create an array as long as the text array to store the encoded text
        char[] encodedText = new char[text.length];

        //iterate over the text array and encode each character. Store result in encodedText
        for(int i = 0; i < text.length; i++)
        {
            //encode the value at the index i and then store in encodedText at the same index;
            encodedText[i] = encode(text[i],key);
        }

        //return the encoded text
        return encodedText;

    }

    /*
     * The decrypt function takes in an encrypted char array and a key and then decrypts each individual
     * character using the previous decode function. It then returns the resulting decoded array.
     *
     */
    static char[] decrypt(char[] text, char[] key)
    {
    
        //create an array as long as the text array to store the decoded text.
        char[] decodedText = new char[text.length];

        //iterate over the text array and decode each character. Store result in decodeText
        for(int i = 0; i < text.length; i++)
        {
            //decode the value at index i and then store in decodedtext at the same index;
            decodedText[i] = decode(text[i], key);
        }

        //return the decode text
        return decodedText;
    }



    public static void main(String[] args){
        
       //this is a string that holds the encryption key
        String subKey = "qwertyuiopasdfghjklzxcvbnm"; 

        //convert the string to a char array and store in key
        char[] key = subKey.toCharArray();
       
        //call the function to encode and store the value in encodedValue.
        char encodedValue = encode('a',key);
        
        //call the decode function to decode and store the value in decoded value
        char decodedValue = decode(encodedValue,key);
        
        System.out.println("The value is a");
        System.out.println("The encoded value is "+encodedValue+" the decoded value is "+decodedValue);


        //convert the string to a char array named plainText
        char[] plainText = "attackatdawn".toCharArray();

        //encrypt the plainText using the encrypt function and store in cipherText
        char[] cipherText = encrypt(plainText,key);
        
        //decrypt the ciphertext using the decrypt function and store in decodeText
        char[] decodeText = decrypt(cipherText, key);

        //Print out results
        System.out.println("The plainText was " + String.valueOf(plainText));
        System.out.println("The cipherText was "+ String.valueOf(cipherText));
        System.out.println("The decodeText was " + String.valueOf(decodeText));

        //myster text to decode is held in mystery
        String mystery = "rorngxitqkqwgxzzitofzvigvqsatrofzgqwqkqfrgkrtktrqrgxwst";
        
        //decrypt the mystery string by first converting to a char array and then sending it to decrypt function
        //store the result in char array mysterySolved.
        char[] mysterySolved = decrypt(mystery.toCharArray(), key);

        //print out the results
        System.out.println("The myster string is "+ mystery);
        System.out.println("The mystery string decoded to "+ String.valueOf(mysterySolved) );
    }




}
