package ujjwal.core;

import static org.junit.Assert.*;

import org.junit.Test;

/***
 * Cracking the coding interview test Method for removing duplicates from a
 * String
 * 
 * @author ujjsingh
 *
 */

public class RemoveDuplicatesFromString {
    
    
    // Method to remove duplicate characters from String
    private String removeDuplicateCharsFromString(String input) {
        
        if (input == null) {
            return null;
        } else if (input.length() == 1) {
            return input;
        }
        StringBuffer returnString = new StringBuffer();
        boolean[] char_set = new boolean[256];

        for (int i = 0; i < input.length(); i++) {

            // Integer value of the character
            int val = input.charAt(i);
            // Already this character is present , its a repeatition
            if (char_set[val]) {
                continue;
            } else {
                returnString.append(input.charAt(i));
                char_set[val] = true;
            }
        }

        return returnString.toString();
    }


    // method which returns true if all the characters in a string is unique
    private boolean checkIfAllCharactersAreUnique(String str) {
        if (str == null) {
            return true;
        } else if (str.length() == 1) {
            return true;
        }
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }


    @Test
    public void removeDuplicateChars() {
        // String haveDuplicates = "ujjwal singh ujjwal ujjwal";
        String haveDuplicates = "aaabbb";
        String output = removeDuplicateCharsFromString(haveDuplicates);
        System.out.println("The returned string is " + output);
        assertEquals(true, checkIfAllCharactersAreUnique(output));

    }


}
