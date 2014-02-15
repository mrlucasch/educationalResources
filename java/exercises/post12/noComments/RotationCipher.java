public class RotationCipher{  

    static char[] rotateKey(char[] key)
    {
        char[] tempKey = new char[key.length];
    
        for(int i = 0 ; i < key.length; i++)
        {
            if(i == key.length - 1)
            {
                tempKey[i] = key[0];
            }
            else{
                tempKey[i] =  key[i+1];
            }
        }
        return tempKey;
    }


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
            
            key =  rotateKey(key);
        }

        return encodedText;
    }

    
    static char[] decrypt(char[] text, char[] key)
    {
        char[] decodedText = new char[text.length];

        for(int i = 0; i < text.length; i++)
        {
            decodedText[i] = decode(text[i], key);

            key = rotateKey(key);
        }

        return decodedText;
    }

    public static void main(String[] args)
    {
        String subKey = "qwertyuiopasdfghjklzxcvbnm";
        char[] key = subKey.toCharArray();
        
        String plain = "attackatdawn";

        String mystery = "ihnhtltvmbjedmqzipsivevatrqdapsniwzabmmkvookmzsnlbhrhljthpl";

        char[] cipher = encrypt(plain.toCharArray(),key);
        
        char[] text = decrypt(cipher,key);

        char[] mysterySolved = decrypt(mystery.toCharArray(), key);

        System.out.println("The plain text was "+plain);
        System.out.println("The cipher text was "+String.valueOf(cipher));
        System.out.println("The decrypted text was "+String.valueOf(text));
        System.out.println("The mystery cipher text was "+mystery);
        System.out.println("The mystery plain text was "+String.valueOf(mysterySolved));
        

    }


}


