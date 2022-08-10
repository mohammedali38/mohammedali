package application;

/*
 * Class: CMSC203 
 * Instructor: Professor Grigoriy Grinberg 
 * Description: Our program will implement several methods that are specified in the file “CryptoManager.java”.
 * A Graphical User Interface is provided, as well as a test file, that we should use to make sure our methods work correctly. 
 * Due: 07/10/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: _Mohammed Ali_
*/
 

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) 
	{
		boolean flagSIB; //declare a boolean flag
		flagSIB = true; //assign true to flag
		int indexSIB;
		
		for(indexSIB = 0; indexSIB < plainText.length(); indexSIB++)//for loop for finding if a string is within range
			{
				if(!((UPPER_BOUND >= (int)plainText.charAt(indexSIB)) && (LOWER_BOUND <= (int)plainText.charAt(indexSIB))))
					{ 
						flagSIB = false; //false if any character is out of range
						break;
					}
			}
		
		return flagSIB; //return true if all characters are in range
	}
	
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) 
	{
		String encryptedCaesarTexts = ""; //declaring encryptedCaesar
		int indexEC; //declaring index
		
		if(key > RANGE) //if statement checking if the key is greater than the range of characters,
			{
				while(UPPER_BOUND < key)
				{
					key = (key - RANGE - 1) ;	////subtracting the range from the key until the key is within the workable range
				}
			}
		//substitution
		for(indexEC = 0; indexEC < plainText.length(); indexEC++)
			{
				encryptedCaesarTexts = (encryptedCaesarTexts+(char)(plainText.charAt(indexEC)+key));
			}
		return encryptedCaesarTexts;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		String key = "";
		String encryptedBellasoTexts = "";
		int indexEB;
		int resultEB;
		int jat;

		while((key.length()) != (plainText.length()))
		{
			jat = 0;

			key = (key + bellasoStr.charAt(jat));

			jat++;

			if(jat == bellasoStr.length())
			{
				jat=0;
			}
		}
		
		for(indexEB = 0; indexEB < plainText.length(); indexEB++)

		{
			resultEB = plainText.charAt(indexEB)+key.charAt(indexEB);

			if(UPPER_BOUND < resultEB)
				{
					while(UPPER_BOUND > resultEB)
					{
						resultEB = (resultEB-RANGE);
					}
				}
			encryptedBellasoTexts = (encryptedBellasoTexts + (char)resultEB);

		}
		
		return encryptedBellasoTexts;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) 
	{
		String decryptedCaesarTexts = "";
		int indexDC;

		if(key > RANGE)
			{
				while(key > UPPER_BOUND)
				{
					key = (key - RANGE - 1);
				}
			}

		for(indexDC = 0; indexDC < encryptedText.length(); indexDC++)
		{
			decryptedCaesarTexts = (decryptedCaesarTexts + (char)(encryptedText.charAt(indexDC) - key));
		}

		return decryptedCaesarTexts;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) 
	{
		String key = "";
		String decryptedBellasoTexts = "";
		int jatDB;
		jatDB = 0;
		int indexDB;
		int resultDB;

		while(!((encryptedText.length()) == (key.length())))	//while the encryptedtext length isn't the same as key key length, do the following
			{
				key = (key + bellasoStr.charAt(jatDB));
				jatDB++;

				if((bellasoStr.length() == jatDB))
					{
						jatDB = 0;
					}
			}

		for(indexDB = 0; indexDB < encryptedText.length(); indexDB++)
			{
				resultDB = (encryptedText.charAt(indexDB) - key.charAt(indexDB));
				 
				if(LOWER_BOUND > resultDB)
					{
						while(LOWER_BOUND > resultDB)
							{
								resultDB = (resultDB+RANGE);
							}
					}

				decryptedBellasoTexts = (decryptedBellasoTexts +(char)resultDB);
			}
		
		return decryptedBellasoTexts;
	}
}
