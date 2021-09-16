/**
* This is the PasswordCheckerUtility class
*
*
* @author Fatima Mancia
*
*/
import java.util.regex.*;
import java.util.ArrayList;
import java.util.*;

class PasswordCheckerUtility{
  private static ArrayList<String> invalid_Passwords;
  public String password;
  public String passwordConfirm;
  public PasswordCheckerUtility(){

  }
   /**
	 * comparePasswords its void.
	 * @return the String s.
	 *
	 */
  public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
    if (!password.equals(passwordConfirm)){
      throw new UnmatchedException("Password do not match");
    }
     /**
	 * comparePasswordsWithReturn compares the paswords.
	 * @return true if the passwords are equal.
	 *
	 */
  }
  public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
    if (password.equals(passwordConfirm)){
      return true;
    }
    else {
      return false;
    }
     /**
	 * invalidPasswords is an array list.
	 * @return the invalid passwords.
	 *
	 */
  }
  public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {
    return invalid_Passwords;
  }
   /**
	 * getInvalidPasswords gets the invalid Passwords.
	 * @return the word in English.
	 *
	 */
  public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
    return invalid_Passwords;
  }
   /**
	 * hasBetweenSixandNineChars its a boolean.
	 * @return true if the password length is between six and nine characters.
	 *
	 */
  public static boolean hasBetweenSixAndNineChars(String password){
    if (password.length() >= 6 && password.length() <= 9){
      return true;
    }
    else {
      return false;
    }
  }
   /**
	 * hasDigit its a boolean.
	 * @return true if the password has a digit.
	 *
	 */
  public static boolean hasDigit(String password) throws NoDigitException{
   for (int i = 0; i < password.length(); i++){
     if(Character.isDigit(password.charAt(i))){
       return true;
     }
   }
   throw new NoDigitException("Does not meet digit requirement");
  }
   /**
	 * hasLowerAlpha its a boolean.
	 * @return true if the password has a lower Alpha.
	 *
	 */
  public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
    for (int i = 0; i < password.length(); i++){
      if(Character.isLowerCase(password.charAt(i))){
        return true;
      }
    }
    throw new NoLowerAlphaException("Does not meet lowercase requirement");
  }
   /**
	 * hasSameCharInSequence its boolean.
	 * @return true if the password has a valid sequence. If not throws exception.
	 *
	 */
  public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < password.length(); i++){
      Character c = password.charAt(i);
      if (set.contains(c)) {
        throw new InvalidSequenceException("Does not meet the sequence requirement");
      }
      else {
        set.add(c);
      }
    }
    return true;
  }
   /**
	 * hasSpecialChar its boolean.
	 * @return true if the password has a special character. If not throws exception.
	 *
	 */
  public static boolean hasSpecialChar(String password) throws NoSpecialSymbolException{
   Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
      throw new NoSpecialSymbolException("Does not meet Special Character requirement");
    }
    return true;
  } 
   /**
	 * hasUpperAlpha its boolean.
	 * @return return true if the pasword has an upper letter. If not throws exception.
	 *
	 */
  public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
    for (int i = 0; i < password.length(); i++){
      if(Character.isUpperCase(password.charAt(i))){
        return true;
      }
    }
    throw new NoUpperAlphaException("Does not meet alpha character requirement");
  }
   /**
	 * isValidLength its boolean.
	 * @return true if the length of the password is valid. If not throw exception.
	 *
	 */
  public static boolean isValidLength(String password) throws LengthException{
    if(password.length() >= 6) {
      return true;
    }
    else {
      throw new LengthException("Does not meet length requirement");
    }
     /**
	 * converterToEnglish translates the word.
	 * @return the word in English.
	 *
	 */
  }
  public static boolean isValidPassword(String password) throws LengthException,
   NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialSymbolException,InvalidSequenceException{
     if (
       (isValidLength(password) == true) && 
       (hasUpperAlpha(password) == true) && 
       (hasLowerAlpha(password) == true) && (hasDigit(password) == true) && (hasSpecialChar(password) == true) && (hasSameCharInSequence(password) == true)){
         return true;
       }
     else {
       return false;
     }
      /**
	 * isWeakPassword its boolean.
	 * @return true if the Password is weak. If not throws exception.
	 *
	 */
   }
  public static boolean isWeakPassword(String password) throws WeakPasswordException, NoSpecialSymbolException {
    if (hasBetweenSixAndNineChars(password)) {
      if (hasSpecialChar(password)) {
        return true;      
        }
      else {
        throw new NoSpecialSymbolException("It does not have a special symbol");
      }
    }
    else {
      throw new WeakPasswordException("It is a weak password");
    }
  }
}