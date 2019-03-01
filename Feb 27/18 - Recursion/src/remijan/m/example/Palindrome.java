package remijan.m.example;

public class Palindrome {
    protected String value;
    
    public Palindrome(String value) {
        this.value = value;
    }
    
    public Boolean check() {
        return recurse(value);
    }
    
    private Boolean recurse(String s) {
        // This is the base case of the recursion
        // If the string has a length of 1 or if
        // the string is empty, the string is
        // obviously a palindrome.
        if (s.length() == 1 || s.isEmpty()) {
            return Boolean.TRUE;
        }
        
        // If the string  has length greater than 1, then
        // check and see if the first character of the
        // string and the last character of the string are
        // the same.  If so, then the string has the
        // potential to be a palindrome
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // Now that you know the 1st and last characters
            // are a equal get a substring which removes 
            // the first and last characters
            String substring = s.substring(1, s.length() - 1);
            
            // Now check to see if this substring is a palindrome
            return recurse(substring);
        }
        else {
            // If the first character and the last character
            // of the string are not equal, then the string
            // can't be a palindrome
            return Boolean.FALSE;
        }
        
    }
}
