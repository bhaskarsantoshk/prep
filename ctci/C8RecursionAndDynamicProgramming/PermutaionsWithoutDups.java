package ctci.C8RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutaionsWithoutDups {
    public ArrayList<String> permutaions( String s){
        ArrayList<String> permutations = new ArrayList<>();
        permutations("", s, permutations);
        return permutations;
    }

    private void permutations(String prefix, String suffix, ArrayList<String> permutations) {
        if ( suffix.length() == 0){
            permutations.add(prefix);
        }
        else{
            for ( int i=0; i<suffix.length(); i++){
                permutations( prefix+suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i+1), permutations);
            }
        }
    }
}
