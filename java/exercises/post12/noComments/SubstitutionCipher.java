public class SubstitutionCipher{


    static char encode (char c, char[] key)
    {
        int letterToNumber = c - 'a';
        
        return key[letterToNumber];
    }
   
    static char decode(char c, char[] key)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
       
        char[] decryptKey = alphabet.toCharArray();
        
        int counter = 0;

        for(int i = 0 ; i < key.length; i++)
        {
            if (key[i] == c)
            { 
                break;
            }

            counter++;
        }
        return decryptKey[counter];

    }

    static char[] encrypt(char[] text, char[] key)
    {
        char[] encodedText = new char[text.length];

        for(int i = 0; i < text.length; i++)
        {
            encodedText[i] = encode(text[i],key);
        }

        return encodedText;

    }

    static char[] decrypt(char[] text, char[] key)
    {
    
        char[] decodedText = new char[text.length];

        for(int i = 0; i < text.length; i++)
        {
            decodedText[i] = decode(text[i], key);
        }

        return decodedText;
    }



    public static void main(String[] args){
        
        String subKey = "qwertyuiopasdfghjklzxcvbnm"; 

        char[] key = subKey.toCharArray();
       
        char encodedValue = encode('a',key);
        
        char decodedValue = decode(encodedValue,key);
        
        System.out.println("The value is a");
        System.out.println("The encoded value is "+encodedValue+" the decoded value is "+decodedValue);


        char[] plainText = "attackatdawn".toCharArray();

        char[] cipherText = encrypt(plainText,key);
        
        char[] decodeText = decrypt(cipherText, key);

        System.out.println("The plainText was " + String.valueOf(plainText));
        System.out.println("The cipherText was "+ String.valueOf(cipherText));
        System.out.println("The decodeText was " + String.valueOf(decodeText));

        String mystery = "rorngxitqkqwgxzzitofzvigvqsatrofzgqwqkqfrgkrtktrqrgxwst";
        
        char[] mysterySolved = decrypt(mystery.toCharArray(), key);

        System.out.println("The myster string is "+ mystery);
        System.out.println("The mystery string decoded to "+ String.valueOf(mysterySolved) );
    }




}
