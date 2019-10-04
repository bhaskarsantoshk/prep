package amazon.strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        int end = -1;
        int start = 0;
        boolean isWordYet = false;
        for ( int i=A.length()-1; i>=0; i--){
            if ( isWordYet ){
                if ( A.charAt(i) == ' '){
                    start = i+1;
                    break;
                }
            }
            else{
                if ( A.charAt(i) != ' '){
                    end = i;
                    isWordYet = true;
                }
            }
        }
        return end-start+1;
    }

    public static void main (String[] args ){
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord(" world  "));
    }
}
